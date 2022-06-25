package com.labs.spring.cloud.transaction.service;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import com.labs.spring.cloud.transaction.model.Transaction;
import com.labs.spring.cloud.transaction.repository.TransactionRepository;
@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepo;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public Integer add(Transaction transaction) {
		transactionRepo.save(transaction);
		return transaction.getId();
	}

	public void update(Transaction transaction) {
		transactionRepo.save(transaction);
	}

	public Transaction get(Integer id) {
		Optional<Transaction> trans = transactionRepo.findById(id);
		return trans.isPresent() ? trans.get() : null;
	}

	public void delete(Integer id) {
		transactionRepo.deleteById(id);
	}

	public List<Transaction> list() {
		return transactionRepo.findAll();
	}

	public void deleteAll() {
		transactionRepo.deleteAll();
	}

	@KafkaListener(topics = "FUNDTRANSFER_APPROVED", groupId = "transaction-service")
	public void listenTransApproval(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Transaction Approved Received: " + cr.value());
		// Logic to update order with APPROVED status
		Integer approvedOrderId = new Integer(cr.value().toString());
		Transaction order = transactionRepo.findById(approvedOrderId).get();
		order.setStatus("APPROVED");

		// Save Order
		transactionRepo.save(order);
	}

	@KafkaListener(topics = "FUNDTRANSFER_REJECTED", groupId = "transaction-service")
	public void listenTransactionRejection(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Transaction Rejected Received: " + cr.value());
		// Logic to update order with REJECTED status
		Integer rejectedOrderId = new Integer(cr.value().toString());
		Transaction transaction = transactionRepo.findById(rejectedOrderId).get();
		
		Transaction transNew = transaction;
		transNew.setStatus("REJECTED");
		transNew.setDescription("Refund: from transaction id reference " + rejectedOrderId);

		transactionRepo.save(transNew);

	}

	@KafkaListener(topics = "FUNDTRANSFER_CREATED", groupId = "transaction-service")
	public void listenTransactionCreation(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Transaction Created: " + cr.value());

		String msg = (String) cr.value();
		String[] tokens = msg.split(",");
		String transactionId = tokens[0];
		String fromacctId = tokens[1];
		String toaccountId = tokens[2];
		String amount = tokens[3];
		String transType = tokens[4];
		String desc = tokens[5];
		String transId = tokens[6];

		double dAmount = Double.valueOf(amount);

		Transaction transNew = new Transaction();
		transNew.setAmount(dAmount);
		transNew.setDescription(msg);
		transNew.setFromaccountid(Integer.parseInt(fromacctId));
		transNew.setStatus("CREATED");
		transNew.setToaccountid(Integer.parseInt(toaccountId));
		transNew.setType(transType);
		transNew.setDescription(desc);

		int id = add(transNew);

		String actmsg = transNew.getId() + "," + transNew.getFromaccountid() + "," + transNew.getToaccountid() + ","
				+ String.valueOf(transNew.getAmount()) + "," + transNew.getType() + "," + transNew.getDescription()
				+ "," + transNew.getId();

		kafkaTemplate.send("FUNDTRANSFER_PROCESSING", actmsg);

	}

}