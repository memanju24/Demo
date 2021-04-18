package com.qlik.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qlik.api.service.PalindromeService;

@RestController
@RequestMapping("/demo")
public class PalindromeController {
	
	@Autowired
	private PalindromeService palindromeService;
	
			
	@GetMapping("/is_palindrome/{id}")
	public Object getCommentById(@PathVariable(value = "id") String str) {	
		return palindromeService.checkPalindrome(str);					
	}
	
	@GetMapping("/palindrome_counts")
	public Map<String,Integer> getCounts() {
		return palindromeService.getCount();
	}
}
