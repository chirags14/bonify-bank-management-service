package com.bonify.group.bank.management.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;

import com.bonify.group.bank.management.model.BankDetailsManagementDTO;

public class BankDetailsManagementUtlils {
	
	public static List<BankDetailsManagementDTO> processInputFile(String inputFilePath) throws FileNotFoundException, IOException {
	    List<BankDetailsManagementDTO> inputList = new ArrayList<BankDetailsManagementDTO>();
	    Pattern pattern = Pattern.compile(";");
	    try (BufferedReader bufferedReader = new BufferedReader(
	            new InputStreamReader(new ClassPathResource(inputFilePath).getInputStream()));){
	    	inputList = bufferedReader
	    		    .lines()
	    		    .skip(1)
	    		    .map(line -> {
	    		            String[] x = pattern.split(line);
	    		            return new BankDetailsManagementDTO(x[0],
	    		                              x[1]);
	    		        })
	    		    .collect(Collectors.toList());
	    }
	    return inputList ;
	} 
	
	

}
