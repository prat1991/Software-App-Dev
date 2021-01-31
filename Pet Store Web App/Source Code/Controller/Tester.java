package com.controller;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Cat;
import com.model.Receipt;
import com.model.Sale;

public class Tester {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		String testLong = "1525647329693";
		Long idTest = Long.parseLong(testLong);
		System.out.println(idTest);
		
		//		Sale newSale = new Sale();
//		newSale.getAnimals().add(new Cat());
//		newSale.setDrawer("Drawer 1");
//		newSale.setUser("Zeke");
//		
//		Receipt r = TransactionService.convertToReceipt(newSale);
//		System.out.println(r);
//		
//		
//		
//		ObjectMapper mapper = new ObjectMapper();
//		String filename = newSale.getSaleDate().toString()+".json";
//		
//		//Object to JSON in file
//		mapper.writeValue(new File(filename), r);
//
//		//Object to JSON in String
//		
//		
//		//Read files back into java
//		
//		File folder = new File("/Users/zekethao/Documents/workspace-sts-3.9.2.RELEASE/POSWebApp/");
//		File[] listOfFiles = folder.listFiles(new FileFilter() {
//
//            public boolean accept(File dir) {
//                String name = dir.getName();
//                if(name.endsWith(".json")) {
//                    return true;
//                }
//				return false;
//            }
//        });
//		List sales = new ArrayList<Receipt>();
//
//	    for (int i = 0; i < listOfFiles.length; i++) {
//	      if (listOfFiles[i].isFile()) {
//	    	  System.out.println("printing file name: " + listOfFiles[i].getName());
//	    	  //TODO differentiate from our receipts and not receipts
//	    	  Receipt oldR = mapper.readValue(new File(listOfFiles[i].getName()), Receipt.class);
//	    	  sales.add(oldR);
//	      } else if (listOfFiles[i].isDirectory()) {
//	        System.out.println("Directory " + listOfFiles[i].getName());
//	      }
//	    }
//	    List saleList = new ArrayList<Sale>();
//	    
//	    for(int i=0; i< sales.size(); i++) {
//	    		saleList.add(TransactionService.convertFromReceipt((Receipt) sales.get(i)));
//	    }
//	    
//	    for(int i=0; i< saleList.size(); i++) {
//	    		Sale thisSale = (Sale) saleList.get(i);
//	    		System.out.println(thisSale.getTotalAmount().toString());
//	    }
		
		
	    
	}
}
