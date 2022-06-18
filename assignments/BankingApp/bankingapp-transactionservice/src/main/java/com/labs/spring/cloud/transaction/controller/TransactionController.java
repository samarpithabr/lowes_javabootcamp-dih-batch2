package com.labs.spring.cloud.transaction.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.labs.spring.cloud.transaction.model.Account;
import com.labs.spring.cloud.transaction.model.ResponseMessage;
import com.labs.spring.cloud.transaction.model.Transaction;
import com.labs.spring.cloud.transaction.service.TransactionService;


@RestController
public class TransactionController {
	@Autowired
	TransactionService transactionService;

//	Create Transaction 	POST	/transactions
//	Get All Transactions	GET		/transactions
//	Update Transaction	PUT		/transactions/{id}
//	Delete Transaction	DELETE	/transactions/{id}
//	Get Transaction		GET		/transactions/{id}

	@PostMapping
	public ResponseEntity<ResponseMessage> createTransaction(@RequestBody @Valid Transaction transaction) throws Exception {

		transactionService.create(transaction);

		// Getting current resource path
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transaction.getId())
				.toUri();

		return ResponseEntity.created(location).body(this.getResponse(transaction.getAccountNumber(), "Transaction Created"));
	}

	@GetMapping
	public List<Transaction> getAll() {
		return transactionService.list();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseMessage> updateTransaction(@RequestBody @Valid Transaction transaction, @PathVariable Account id) {
		transaction.setAccountNumber(id);
		transactionService.update(transaction);

		return ResponseEntity.ok().body(this.getResponse(transaction.getAccountNumber(), "Transaction Updated"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseMessage> deleteTransaction(@PathVariable Account id) {
		transactionService.delete(id);

		ResponseMessage response = getResponse(id, "Transaction Deleted");

		return ResponseEntity.accepted().body(response);
	}

	@GetMapping("/{id}")
	public Transaction getTransaction(@PathVariable Account id) {
		return transactionService.get(id);
	}

	private ResponseMessage getResponse(Account id, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setId(null);
		response.setStatus(HttpStatus.OK.name());
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage(message);
		return response;
	}

	private ResponseMessage getErrorResponse(Integer id, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setId(id);
		response.setStatus(HttpStatus.BAD_REQUEST.name());
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage(message);
		return response;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<ResponseMessage> handleValidationException(MethodArgumentNotValidException ex) {
		FieldError error = ex.getBindingResult().getFieldError("name");
		System.out.println("Error Message: " + error.getCode() + " - " + error.getDefaultMessage());
		return ResponseEntity.badRequest().body(this.getErrorResponse(-1, error.getDefaultMessage()));
	}
}

