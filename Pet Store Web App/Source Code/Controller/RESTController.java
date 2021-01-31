package com.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Cat;
import com.model.Dog;
import com.model.Fish;
import com.model.Inventory;
import com.model.Receipt;
import com.model.Response;
import com.model.Sale;
import com.model.Turtle;
import com.model.User;

@RestController
public class RESTController {
	Inventory inventory = new Inventory();
	Sale sale = new Sale();
	
	@GetMapping("/loginservice")
	public Response loginservice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String inputUsername = request.getParameter("username");
		String inputPassword = request.getParameter("password");
		User newUser = LoginService.login(inputPassword, inputUsername);
		if (newUser == null) {
			return new Response("FAIL", null);
		} else {
			User.setCurrentUser(newUser.getUsername());
			return new Response("SUCCESS", newUser.getUsername() );
		}
	}
	
	@GetMapping("/buy")
	public Response buy(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String item = request.getParameter("items");
		sale.setUser(User.getCurrentUser());
		if (item.equals("cat")) {
			InventoryService.removeItem(inventory, new Cat());
			TransactionService.addNewItemToSale(sale, new Cat(), inventory);
		}
		if (item.equals("dog")) {
			InventoryService.removeItem(inventory, new Dog());
			TransactionService.addNewItemToSale(sale, new Dog(), inventory);
		}
		if (item.equals("fish")) {
			InventoryService.removeItem(inventory, new Fish());
			TransactionService.addNewItemToSale(sale, new Fish(), inventory);
		}
		if (item.equals("turtle")) {
			InventoryService.removeItem(inventory, new Turtle());
			TransactionService.addNewItemToSale(sale, new Turtle(), inventory);
		}

		Double amount =sale.getTotalAmount().doubleValue();
		
		return new Response("SUCCESS", amount);
	}
	
	@GetMapping("/remove")
	public Response remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String item = request.getParameter("items");
		if (item.equals("cat")) {
			InventoryService.addItem(inventory, new Cat());
			TransactionService.removeItemFromSale(sale, new Cat());
		}
		if (item.equals("dog")) {
			InventoryService.addItem(inventory, new Dog());
			TransactionService.removeItemFromSale(sale, new Dog());
		}
		if (item.equals("fish")) {
			InventoryService.addItem(inventory, new Fish());
			TransactionService.removeItemFromSale(sale, new Fish());
		}
		if (item.equals("turtle")) {
			InventoryService.addItem(inventory, new Turtle());
			TransactionService.removeItemFromSale(sale, new Turtle());
		}

		Double amount =sale.getTotalAmount().doubleValue();		
		return new Response("SUCCESS", amount);
	}
	
	@GetMapping("/cancelSale")
	public Response cancelSale(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TransactionService.cancelSale(sale);
		sale = new Sale();
		return new Response("SUCCESS", sale.getAnimals());
	}
	
	@GetMapping("/pay")
	public Response pay(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BigDecimal paymentAmount = new BigDecimal(Double.parseDouble(request.getParameter("amount")));
		BigDecimal change = TransactionService.payCash(sale, paymentAmount);
		Receipt r = TransactionService.createReceipt(sale);
		sale = new Sale();
		return new Response("SUCCESS", r);
	}
	
	@GetMapping("/lookupReceipt")
	public Response lookupReceipt(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		String receiptNumberText = request.getParameter("receiptNumber");
		Long receiptID = Long.parseLong(receiptNumberText);
		sale = TransactionService.readReceipt(receiptID);
		return new Response("SUCCESS", sale);
	}
	
	@GetMapping("/newSale")
	public Response newSale(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		sale = new Sale();
		return new Response("SUCCESS", "New Sale");
	}
	
	@GetMapping("/xReading")
	public Response xReading(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		BigDecimal amount = TransactionService.xReading();
		return new Response("SUCCESS", amount);
	}
	
	@GetMapping("/zReading")
	public Response zReading(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		BigDecimal amount = TransactionService.zReading();
		return new Response("SUCCESS", amount);
	}
	
	@GetMapping("/refund")
	public Response refund(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BigDecimal originalAmount = new BigDecimal(Double.parseDouble(request.getParameter("originalAmount")));
		BigDecimal refund = originalAmount.subtract(sale.getTotalAmount());
		sale.setRefunded(refund);
		TransactionService.createReceipt(sale);
		return new Response("SUCCESS", refund);
	}
	
	@GetMapping("/fullRefund")
	public Response fullRefund(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String originalAmount = request.getParameter("originalAmount");
		BigDecimal refund = new BigDecimal(Double.parseDouble(originalAmount));
		sale.setRefunded(refund);
		sale.setVoided(true);
		TransactionService.cancelSale(sale);
		TransactionService.createReceipt(sale);
		return new Response("SUCCESS", "Sale Refunded");
	}
}
