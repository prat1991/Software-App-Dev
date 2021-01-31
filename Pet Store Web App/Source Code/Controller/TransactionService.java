package com.controller;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Animal;
import com.model.Cat;
import com.model.Dog;
import com.model.Fish;
import com.model.Inventory;
import com.model.Receipt;
import com.model.Sale;
import com.model.Transaction;
import com.model.Turtle;
import com.model.User;

public class TransactionService {

	public static void addNewItemToSale(Sale sale, Animal item, Inventory inventory) {
		sale.getAnimals().add((Animal) item);
		
		if (item.getClass() == Cat.class) {
			((Cat) item).inStock--;
		}
		if (item.getClass() == Fish.class) {
			((Fish) item).inStock--;
		}
		if (item.getClass() == Turtle.class) {
			((Turtle) item).inStock--;
		}
		
		InventoryService.removeItem(inventory, item);
		InventoryService.restock();
	}

	public static void removeItemFromSale(Sale sale, Animal item) {
		for (int i=0; i<sale.getAnimals().size();i++) {
			if (item.getClass() == Cat.class && sale.getAnimals().get(i).getClass() == Cat.class) {
				((Cat) item).inStock++;
				sale.getAnimals().remove(i);
				break;
			}
			if (item.getClass() == Dog.class && sale.getAnimals().get(i).getClass() == Dog.class) {
				((Dog) item).inStock++;
				sale.getAnimals().remove(i);
				break;
			}
			if (item.getClass() == Fish.class && sale.getAnimals().get(i).getClass() == Fish.class) {
				((Fish) item).inStock++;
				sale.getAnimals().remove(i);
				break;
			}
			if (item.getClass() == Turtle.class && sale.getAnimals().get(i).getClass() == Turtle.class) {
				((Turtle) item).inStock++;
				sale.getAnimals().remove(i);
				break;
			}
		}
				
	}
	
	public static void cancelSale(Sale sale) {
		List<Animal> animals = sale.getAnimals();
		for (int i = animals.size() - 1; i>=0; i--) {
			removeItemFromSale(sale, animals.get(i));
		}
	}
	
	public static BigDecimal payCash(Sale sale, BigDecimal paymentAmount) throws Exception {
		Transaction transaction = new Transaction();
		transaction.setTotalAmount(sale.getTotalAmount());
		transaction.setPaymentAmount(paymentAmount);
		if (sale.getTotalAmount().doubleValue() > paymentAmount.doubleValue()) {
			throw new Exception("Not enough money given. Need more: " + sale.getTotalAmount().subtract(paymentAmount));
		}		
		
		return paymentAmount.subtract(sale.getTotalAmount());
	}
	
	public static Receipt convertToReceipt(Sale sale) {
		Receipt r = new Receipt();
		r.setTotal(sale.getTotalAmount());
		r.setDrawer(sale.getDrawer());
		r.setRefunded(sale.getRefunded());
		if (sale.getUser().equals("") || sale.getUser()== null) {
			r.setUsername("ali");
		} else {
			r.setUsername(sale.getUser());
		}
		r.setIsVoided(sale.isVoided());
		r.setUID(sale.getUID());
		r.setSaleDate(sale.getSaleDate());
		
		for (int i=0; i< sale.getAnimals().size(); i++) {
			if (sale.getAnimals().get(i).getClass() == Cat.class) {
				r.getItems().add("Cat");
			} else if (sale.getAnimals().get(i).getClass() == Dog.class) {
				r.getItems().add("Dog");
			} else if (sale.getAnimals().get(i).getClass() == Fish.class) {
				r.getItems().add("Fish");
			} else if (sale.getAnimals().get(i).getClass() == Turtle.class) {
				r.getItems().add("Turtle");
			}
		}	
		return r;
	}
	public static Sale convertFromReceipt(Receipt r) {
		Sale sale = new Sale();
		sale.setDrawer(r.getDrawer());
		sale.setRefunded(r.getRefunded());
		if (r.getUsername() == null || r.getUsername().equals("")) {
			sale.setUser("ali");
		} else {
			sale.setUser(r.getUsername());
		}
		sale.setVoided(r.getIsVoided());
		sale.setUser(r.getUsername());
		sale.setUID(r.getUID());
		sale.setSaleDate(r.getSaleDate());
		for (int i=0; i< r.getItems().size(); i++) {
			if (r.getItems().get(i).equals("Cat")) {
				sale.getAnimals().add(new Cat());
			} else if (r.getItems().get(i).equals("Dog")) {
				sale.getAnimals().add(new Dog());
			} else if (r.getItems().get(i).equals("Fish")) {
				sale.getAnimals().add(new Fish());
			} else if (r.getItems().get(i).equals("Turtle")) {
				sale.getAnimals().add(new Turtle());
			}
		}
		
		return sale;
	}
	
	public static Receipt createReceipt(Sale sale) throws JsonGenerationException, JsonMappingException, IOException {
		Receipt r = TransactionService.convertToReceipt(sale);
		ObjectMapper mapper = new ObjectMapper();
		String filename = sale.getSaleDate().toString()+".json";
		String jsonInString = mapper.writeValueAsString(r);
		
		File aFile = new File(filename);
	    if (aFile.exists() && !aFile.isDirectory()) {
	    		FileWriter fw = new FileWriter(aFile, false);
	        fw.write(jsonInString);
	        fw.close();
	    } else if (!aFile.exists()) {
	    		mapper.writeValue(new File(filename), r);
	    }
				
		return r;
	}
	
	public static Sale readReceipt(Long id) throws JsonParseException, JsonMappingException, IOException {
		List receipts = loadReceipts();
	    
	    //this converts receipt object to sales
	    List saleList = new ArrayList<Sale>();
	    Sale returnSale = null;
	    
	    for(int i=0; i< receipts.size(); i++) {
	    		Sale sale = TransactionService.convertFromReceipt((Receipt) receipts.get(i));
	    		//return sale where sale.UID is equal to id
	    		if (sale.getUID().equals(id)) {
	    			return sale;
	    		}
	    }
	    
		return null;
	}
	
	public static List<Receipt> loadReceipts() throws JsonParseException, JsonMappingException, IOException {
		//this gets the files
				ObjectMapper mapper = new ObjectMapper();
				File folder = new File("/Users/zekethao/Documents/workspace-sts-3.9.2.RELEASE/POSWebApp/");
				File[] listOfFiles = folder.listFiles(new FileFilter() {

		            public boolean accept(File dir) {
		                String name = dir.getName();
		                if(name.endsWith(".json")) {
		                    return true;
		                }
						return false;
		            }
		        });
				
				//this converts all the files into a receipt object
				List receipts = new ArrayList<Receipt>();

			    for (int i = 0; i < listOfFiles.length; i++) {
			      if (listOfFiles[i].isFile()) {
			    	  System.out.println("printing file name: " + listOfFiles[i].getName());
			    	  Receipt oldR = mapper.readValue(new File(listOfFiles[i].getName()), Receipt.class);
			    	  receipts.add(oldR);
			      } else if (listOfFiles[i].isDirectory()) {
			        System.out.println("Directory " + listOfFiles[i].getName());
			      }
			    }
				return receipts;
	}
	
	//gets the amount of sales within the year for user
	public static BigDecimal xReading() throws JsonParseException, JsonMappingException, IOException {
		List receipts = loadReceipts();
		Double amount = 0.0;
		for (int i =0; i<receipts.size(); i++) {
			Receipt r = (Receipt) receipts.get(i);
			if (User.getCurrentUser() == null || User.getCurrentUser()=="") {
				User.setCurrentUser("ali");
			}
			if (r.getUsername() == null || r.getUsername() =="") {
				r.setUsername("ali");
			} 
			if (r.getUsername().equals(User.getCurrentUser())) {
				amount = amount + r.getTotal().doubleValue();
			}
		}
		return new BigDecimal(amount);
	}
	
	//gets the amount of sales within the year for drawer
	public static BigDecimal zReading() throws JsonParseException, JsonMappingException, IOException {
		List receipts = loadReceipts();
		Double amount = 0.0;
		for (int i =0; i<receipts.size(); i++) {
			Receipt r = (Receipt) receipts.get(i);
			if (r.getDrawer().equals("Register 1")) {
				amount = amount + r.getTotal().doubleValue();
			}
		}
		return new BigDecimal(amount);
	}

}
