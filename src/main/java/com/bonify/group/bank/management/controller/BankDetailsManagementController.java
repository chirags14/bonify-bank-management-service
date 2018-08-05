package com.bonify.group.bank.management.controller;

import java.io.IOException;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bonify.group.bank.management.model.BankDetailsManagementDTO;
import com.bonify.group.bank.management.service.BankDetailsManagementService;

/**
 * @author chirag suthar
 * 
 * Rest Controller class for laoding and getting bank details
 * 
 */
@RestController
@ControllerAdvice
public class BankDetailsManagementController extends ResponseEntityExceptionHandler {

	/**
	 * LOG
	 */
	final static Logger LOG = Logger.getLogger(BankDetailsManagementController.class);
	
	/**
	 * bankDetailsManagmentService
	 */
	@Autowired
	private BankDetailsManagementService bankDetailsManagmentService ;

	/**
	 * @param offer
	 * @return Endpoint to load bank details from csv file located at data\bank_details_upload_file.csv
	 */
	@RequestMapping(value = "/bank/records", method = RequestMethod.POST)
	public ResponseEntity<String> createBankDetails() {
		LOG.debug("Recevied request to load bank details from csv file...");
		try {
			bankDetailsManagmentService.loadBankDetails();
		} catch (IOException e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LOG.debug("Bank details have been loaded....");
		// if offer is saved successfully based on constraints then return 201
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	/**
	 * @return Endpoint to get Bank name based on bank Id
	 */
	@RequestMapping(value = "/bank/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getBankNameById(@PathVariable("id") String bankId) {
		LOG.debug("Recevied request to get bank name by id ...");
		Optional<BankDetailsManagementDTO> bankDetailsManagmentDTOOptional =  bankDetailsManagmentService.getBankDetailsById(bankId);
		if (bankDetailsManagmentDTOOptional.isPresent()) {
			BankDetailsManagementDTO bankDetailsManagmentDTO = bankDetailsManagmentDTOOptional.get();
			System.out.println("Bank Name : "+ bankDetailsManagmentDTO.getName());
			return ResponseEntity.ok(bankDetailsManagmentDTO.getName());
		} else {
			System.out.println("No such Bank with provided bank Id : " + bankId);
			return ResponseEntity.noContent().build();
		}
	}

}
