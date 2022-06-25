package com.labs.spring.cloud.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.labs.spring.cloud.transaction.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	//public List<Customer> findByName(String name);

	//public List<Customer> findByPrimeAndLocation(boolean prime, String location);

}