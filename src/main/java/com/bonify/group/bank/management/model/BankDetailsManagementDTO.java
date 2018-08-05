package com.bonify.group.bank.management.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BankDetailsManagementDTO {

	private String bank_identifier;

	private String name;

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @return the bank_identifier
	 */
	public final String getBank_identifier() {
		return bank_identifier;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @param bank_identifier
	 *            the bank_identifier to set
	 */
	public final void setBank_identifier(String bank_identifier) {
		this.bank_identifier = bank_identifier;
	}

	public BankDetailsManagementDTO(String name, String bank_identifier) {
		super();
		this.bank_identifier = bank_identifier;
		this.name = name;
	}

}
