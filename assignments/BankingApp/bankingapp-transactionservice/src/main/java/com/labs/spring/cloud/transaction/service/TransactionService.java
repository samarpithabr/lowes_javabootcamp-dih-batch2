package com.labs.spring.cloud.transaction.service;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.labs.spring.cloud.transaction.model.Account;
import com.labs.spring.cloud.transaction.model.Transaction;
import com.labs.spring.cloud.transaction.repository.TransactionRepository;

@Service
public class TransactionService {


	@Autowired
	TransactionRepository transactionRepo;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public Integer create(Transaction transaction) {
		transactionRepo.save(transaction);
	
		
		String msg = transaction.getId() + "," + transaction.getId() + "," + String.valueOf(transaction.getType());
		
		kafkaTemplate.send("Transcation_CREATED", msg);
		
		return transaction.getId();
	}

	public void update(Transaction transaction) {
		transactionRepo.save(transaction);
	}

	public Transaction get(Account accountnumber) {
		Optional<Transaction> emp = transactionRepo.findById(accountnumber); 
		return  emp.isPresent() ? emp.get() : null;
	}

	public void delete(Account empId) {
		transactionRepo.deleteById(empId);
	}

	public List<Transaction> list() {
		return transactionRepo.findAll();
	}
	
	public void deleteAll()
	{
		transactionRepo.deleteAll();
	}
	
//    @KafkaListener(topics = "transcation_APPROVED", groupId="transaction-service")
//    public void listenTransactionApproval(ConsumerRecord<?, ?> cr) throws Exception {
//        System.out.println("###################Transaction Approved Received: " + cr.value());
//        // Logic to update transaction with APPROVED status
//        Account approvedaccountnumber = new Account();
//        Transaction transaction = transactionRepo.findById(approvedaccountnumber).get();
//        transaction.setStatus("APPROVED");
//        
//        // Save Transaction
//        transactionRepo.save(transaction);
//    }
//    
//    @KafkaListener(topics = "transaction_REJECTED", groupId="transaction-service")
//    public void listenTransactionRejection(ConsumerRecord<?, ?> cr) throws Exception {
//        System.out.println("###################Transaction Rejected Received: " + cr.value());
//        // Logic to update transaction with REJECTED status
//        Account rejectedaccountnumber = new Account();
//        Transaction transaction = transactionRepo.findById(rejectedaccountnumber).get();
//        transaction.setStatus("REJECTED");
//        
//        // Save Transaction
//        transactionRepo.save(transaction);
//    }    
}
