package com.labs.spring.cloud.controller;


import java.net.URISyntaxException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.labs.spring.cloud.exception.AccountException;
import com.labs.spring.cloud.model.Account;
import com.labs.spring.cloud.service.AccountService;


@RestController
public class AccountserviceController {
	 private static Logger log = LoggerFactory.getLogger(AccountserviceController.class);
	   
	   @Autowired
	   AccountService accountService;
	   
	  
	   
	   @DeleteMapping("/{id}")
	   public ResponseEntity<Object> delete(@PathVariable("id") Integer id) { 
//	      accountRepo.remove(id);
		   
		accountService.deleteAccount(id);
		   
	      return new ResponseEntity<>("Account is deleted successsfully", HttpStatus.OK);
	   }
	   
	   @PutMapping("/{id}")
	   public ResponseEntity<Object> updateAccount(@PathVariable("id") Integer id, @RequestBody Account account) { 
//	      accountRepo.remove(id);
//	      account.setId(id);
//	      accountRepo.put(id, account);
		   
		   accountService.updateAccount(id, account);
		   account.setType("Account Active");
	      return new ResponseEntity<>("Account is updated successsfully", HttpStatus.OK);
	   }
	   
	   @PostMapping
		@Transactional
	   public ResponseEntity<String> createAccount(@RequestBody Account account) throws URISyntaxException, AccountException {
		   
//	      accountRepo.put(account.getId(), account);
		   
		   accountService.createAccount(account);
		 
	      return new ResponseEntity<>("Account is created successfully", HttpStatus.CREATED);
	   }
	   
	   @GetMapping
	   public ResponseEntity<Object> getAccount() throws InterruptedException {
		  log.info("Received request to list accounts...");

		  
//	      return new ResponseEntity<>(accountRepo.values(), HttpStatus.OK);
		  
		  return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
	   }
	}
