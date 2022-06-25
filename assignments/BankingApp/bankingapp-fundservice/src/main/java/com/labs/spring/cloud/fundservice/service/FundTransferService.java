package com.labs.spring.cloud.fundservice.service;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.labs.spring.cloud.fundservice.model.FundTransfer;
import com.labs.spring.cloud.fundservice.repository.fundRepository;

@Service
public class FundTransferService {

	@Autowired
	fundRepository fundTransRepo;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	String transactionId;

	/**
	 * @param customer
	 * @return
	 */
	
	public Integer create(FundTransfer ft) {
		
		ft.setStatus("PENDING");
		ft.toString();
		
		fundTransRepo.save(ft);
		int transId =0;
		
		String msg = ft.getId() + "," + ft.getSourceAccountId() + "," + ft.getDestinationAccountId() + "," + String.valueOf(ft.getAmount()) + "," + ft.getType()  + "," + ft.getDescription() + "," + transId ;
		
		kafkaTemplate.send("FUNDTRANSFER_CREATED", msg);
		
		return ft.getId();
	}
		
//	public Integer add(FundTransfer fundtrans) {
//		fundTransRepo.save(fundtrans);
//		return fundtrans.getId();
//	}	

	public void update(FundTransfer fundtrans) {
		fundTransRepo.save(fundtrans);
	}

	public FundTransfer get(Integer id) {
		Optional<FundTransfer> ft = fundTransRepo.findById(id);
		return ft.isPresent() ? ft.get() : null;
	}

	public void delete(Integer id) {
		fundTransRepo.deleteById(id);
	}

	public List<FundTransfer> list() {
		return fundTransRepo.findAll();
	}

	public void deleteAll() {
		fundTransRepo.deleteAll();
	}
	
	@KafkaListener(topics = "FUNDTRANSFER_APPROVED", groupId="fundtransfer-service")
    public void listenOrderApproval(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("###################Fund Transfer Approved Received: " + cr.value());
        // Logic to update order with APPROVED status
        Integer approvedOrderId = new Integer(cr.value().toString());
        FundTransfer order = fundTransRepo.findById(approvedOrderId).get();
        order.setStatus("APPROVED");
        
        // Save Order
        fundTransRepo.save(order);
    }
    
    @KafkaListener(topics = "FUNDTRANSFER_REJECTED", groupId="fundtransfer-service")
    public void listenOrderRejection(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("###################Fund Transfer Rejected Received: " + cr.value());
        // Logic to update order with REJECTED status
        Integer rejectedOrderId = new Integer(cr.value().toString());
        FundTransfer order = fundTransRepo.findById(rejectedOrderId).get();
        order.setStatus("REJECTED");
        
        // Save Order
        fundTransRepo.save(order);
    }    

}


