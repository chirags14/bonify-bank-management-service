package com.bonify.group.bank.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bonify.group.bank.management.entity.BankDetailsManagementEntity;

/**
 * @author chirag suthar
 * 
 * 
 * Database layer repository to load and get bank details
 *
 */
@Repository
public interface BankDetailsManagementRepository extends JpaRepository<BankDetailsManagementEntity, String> {


}
