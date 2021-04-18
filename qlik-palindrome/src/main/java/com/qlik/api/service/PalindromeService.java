package com.qlik.api.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {

	private static Map<String, Integer> memMap = new HashMap<String,Integer>();
	private static final String Level = "level";

	public boolean checkPalindrome(String str) {
		updateLevel();

		int i = 0, j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) == str.charAt(j)) {
				i++;
				j--;

			} else {				
				return false;
			}
		}		
		updateCount(str);
		return true;
	}

	private void updateCount(String str) {
		if (memMap.get(str) == null) {			
			memMap.put(str, 1);
		} else {			
			memMap.put(str, memMap.get(str) + 1);
		}	

	}

	private void updateLevel() {
		if (memMap.get(Level) == null) {			
			memMap.put(Level, 1);
		} else {			
			memMap.put(Level, memMap.get(Level) + 1);
		}		
	}

	public Map<String,Integer> getCount() {
		return memMap;
	}

}
