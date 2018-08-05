package com.bonify.group.bank.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity Class
 *
 */
@Entity
@Table(name = "BANK_DETAILS")
public class BankDetailsManagementEntity {
	
	/**
	 * jobTitle
	 */
	@Id
	@Column(name = "BANK_ID")
	private String bank_identifier;
	
	/**
	 * jobTitle
	 */
	@Column(name = "BANK_NAME")
	private String name;

	/**
	 * @return the bank_identifier
	 */
	public final String getBank_identifier() {
		return bank_identifier;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param bank_identifier the bank_identifier to set
	 */
	public final void setBank_identifier(String bank_identifier) {
		this.bank_identifier = bank_identifier;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

}
