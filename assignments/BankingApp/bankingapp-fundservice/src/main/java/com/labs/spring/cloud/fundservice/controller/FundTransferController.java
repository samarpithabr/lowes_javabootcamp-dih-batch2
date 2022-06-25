package com.labs.spring.cloud.fundservice.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.labs.spring.cloud.fundservice.model.FundTransfer;
import com.labs.spring.cloud.fundservice.model.ResponseMessage;
import com.labs.spring.cloud.fundservice.service.FundTransferService;

@RestController
@RequestMapping("/funds_transfer")
public class FundTransferController {

	@Autowired
	FundTransferService fundTransferService;

//	Create fundtransfer 	POST	/fundtransfer
//	Get All fundtransfer	GET		/fundtransfer
//	Update fundtransfer		PUT		/fundtransfer/{id}
//	Delete fundtransfer		DELETE	/fundtransfer/{id}
//	Get fundtransfer		GET		/fundtransfer/{id}

	@PostMapping
	public ResponseEntity<ResponseMessage> createFundTransfer(@RequestBody @Valid FundTransfer ft) throws Exception {

		fundTransferService.create(ft);

		// Getting current resource path
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ft.getId())
				.toUri();

		return ResponseEntity.created(location).body(this.getResponse(ft.getId(), "Fund Transfer Created"));
	}

	@GetMapping
	public List<FundTransfer> getAll() {
		return fundTransferService.list();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseMessage> updateFundTransfer(@RequestBody @Valid FundTransfer ft,
			@PathVariable Integer id) {
		ft.setId(id);
		fundTransferService.update(ft);

		return ResponseEntity.ok().body(this.getResponse(ft.getId(), "Fund Transfer Updated"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseMessage> deleteFundTransfer(@PathVariable Integer id) {
		fundTransferService.delete(id);

		ResponseMessage response = getResponse(id, "Fund Transfer Deleted");

		return ResponseEntity.accepted().body(response);
	}

	@GetMapping("/{id}")
	public FundTransfer getFundTransfer(@PathVariable Integer id) {
		return fundTransferService.get(id);
	}

	private ResponseMessage getResponse(Integer id, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setId(id);
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