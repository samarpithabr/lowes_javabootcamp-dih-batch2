package com.labs.spring.cloud.service;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.security.auth.login.AccountException;
import javax.security.auth.login.AccountNotFoundException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field.Str;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.labs.spring.cloud.model.Account;
import com.labs.spring.cloud.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository acctRepo;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public Collection<Account> getAccounts() {
		return acctRepo.findAll();
	}

	public String createAccount(Account account) throws AccountException {
		// if (account.getId() == null || account.getId().isEmpty()) {
		if (account.getId() == null) {
			throw new RuntimeException("Account Id mandatory");
		}
		acctRepo.save(account);
		return "Account created";
	}

	// public void updateAccount(String id, Account account) {
	public void updateAccount(Integer id, Account account) throws AccountException {
		account.setId(id);
		acctRepo.save(account);
		
	}

	public void deleteAccount(Integer id) throws AccountException {

		System.out.println("Account: " + acctRepo.findById(id).get().getId());
		acctRepo.delete(acctRepo.findById(id).get());		

	}

	public Account getAccount(Integer id) throws AccountException {
		Optional<Account> account = acctRepo.findById(id);
		return account.isPresent() ? account.get() : null;
	}

	public void clear() {
		acctRepo.deleteAll();
	}

	@KafkaListener(topics = "FUNDTRANSFER_PROCESSING", groupId = "account-service")
	public void listenAccountApproval(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Transaction Processing: " + cr.value());

		String msg = (String) cr.value();
		String[] tokens = msg.split(",");
		String ftId = tokens[0];
		String fromacctId = tokens[1];
		String amount = tokens[3];
		String transType = tokens[4];
		String toaccountId = tokens[2];
		String desc = tokens[5];
		String transId = tokens[6];

		double dAmount = Double.valueOf(amount);

		// Logic to check credit limit
		Account srcacct = acctRepo.findById(Integer.valueOf(fromacctId)).get();

		Account dstacct = acctRepo.findById(Integer.valueOf(toaccountId)).get();

		if (srcacct != null && dstacct != null) {
			if (transType.equals("DEBIT")) {
				double availableBalance = srcacct.getBalance();
				if (availableBalance >= dAmount) {
					if (dstacct.getStatus().equals("BLOCKED")) {
						System.out.println("FUNDTRANSFER REJECTED :: " + transId);
						kafkaTemplate.send("FUNDTRANSFER_REJECTED", transId);
					} else {
						srcacct.setBalance(availableBalance - dAmount);
						dstacct.setBalance(dstacct.getBalance() + dAmount);
						System.out.println("FUNDTRANSFER APPROVED :: " + transId);
						acctRepo.save(srcacct);
						acctRepo.save(dstacct);
						kafkaTemplate.send("FUNDTRANSFER_APPROVED", transId);
					}
				} else {
					System.out.println("FUNDTRANSFER REJECTED :: " + transId);
					kafkaTemplate.send("FUNDTRANSFER_REJECTED", transId);
				}
			} else if (transType.equals("CREDIT")) {
				double availableBalance = dstacct.getBalance();

				if (availableBalance >= dAmount) {
					if (srcacct.getStatus().equals("BLOCKED")) {
						System.out.println("FUNDTRANSFER REJECTED :: " + transId);
						kafkaTemplate.send("FUNDTRANSFER_REJECTED", transId);
					} else {

						srcacct.setBalance(availableBalance + dAmount);
						dstacct.setBalance(dstacct.getBalance() - dAmount);
						System.out.println("FUNDTRANSFER APPROVED :: " + transId);
						acctRepo.save(srcacct);
						acctRepo.save(dstacct);
						kafkaTemplate.send("FUNDTRANSFER_APPROVED", transId);
					}
				} else {
					System.out.println("FUNDTRANSFER REJECTED :: " + transId);
					kafkaTemplate.send("FUNDTRANSFER_REJECTED", transId);
				}
			}
		} else {
			System.out.println("FUNDTRANSFER REJECTED :: " + transId);
			kafkaTemplate.send("FUNDTRANSFER_REJECTED", transId);
		}

	}

}