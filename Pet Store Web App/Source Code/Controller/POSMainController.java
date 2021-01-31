package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;

@Controller
public class POSMainController {
	
	@GetMapping("/")
    public String login() {
        return "login";
    }
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/pos*")
    public String pos() {
        return "pos";
    }

}
