package com.bonify.group.bank.management.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonify.group.bank.management.entity.BankDetailsManagementEntity;
import com.bonify.group.bank.management.model.BankDetailsManagementDTO;
import com.bonify.group.bank.management.repository.BankDetailsManagementRepository;
import com.bonify.group.bank.management.util.BankDetailsManagementUtlils;

/**
 * @author chirag suthar
 * 
 * Bank Management service 
 */
@Service
public class BankDetailsManagementService {

	/**
	 * applicationDetailRepository
	 */
	@Autowired
	BankDetailsManagementRepository bankDetailsManagmentRepository;

	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 *             MEthod to load bank details from CSV file to Database
	 */
	public void loadBankDetails() throws FileNotFoundException, IOException {

		List<BankDetailsManagementDTO> bankDetailsManagementDTOs = BankDetailsManagementUtlils
				.processInputFile("/data/bank_details_upload_file.csv");
		List<BankDetailsManagementEntity> bankDetails = new ArrayList<>();
		BankDetailsManagementEntity bankDetailsManagementEntity = null;
		for (BankDetailsManagementDTO bankDetailsManagementDTO : bankDetailsManagementDTOs) {
			bankDetailsManagementEntity = new BankDetailsManagementEntity();
			bankDetailsManagementEntity.setBank_identifier(bankDetailsManagementDTO.getBank_identifier());
			bankDetailsManagementEntity.setName(bankDetailsManagementDTO.getName());
			bankDetails.add(bankDetailsManagementEntity);
		}
		bankDetailsManagmentRepository.saveAll(bankDetails);
	}

	/**
	 * @param bankId
	 * @return
	 * 
	 * 		Method to get Bank details based on bank Id
	 */
	public Optional<BankDetailsManagementDTO> getBankDetailsById(String bankId) {
		Optional<BankDetailsManagementEntity> bankDetailsManagmentEntityOptional = bankDetailsManagmentRepository
				.findById(bankId);
		if (bankDetailsManagmentEntityOptional.isPresent()) {
			BankDetailsManagementEntity bankDetailsManagmentEntity = bankDetailsManagmentEntityOptional.get();
			return Optional.of(new BankDetailsManagementDTO(bankDetailsManagmentEntity.getName(),
					bankDetailsManagmentEntity.getBank_identifier()));
		} else {
			return Optional.ofNullable(null);
		}
	}

}
