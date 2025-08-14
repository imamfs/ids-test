package com.ids.onlinetest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ids.onlinetest.dto.DataResponse;
import com.ids.onlinetest.dto.ListTrxDTO;
import com.ids.onlinetest.dto.Status;
import com.ids.onlinetest.service.TransactionService;


@RestController
@RequestMapping("/api")
public class TransactionController {

	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	private TransactionService transactionService;
	
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@GetMapping("/transactions")
	public ResponseEntity<DataResponse> getAllTransactions() throws JsonProcessingException {
		// Ambil data dari service transaction 
		List<ListTrxDTO> list = transactionService.getAllTransactions();
		
		// Mapping data status transaksi secara hardcoded
		List<Status> listStatus = List.of(new Status("0","SUCCESS"), new Status("1","FAILED"));
		
		// Set data daftar transaksi dan data status transaksi ke dalam object response
		DataResponse response = DataResponse.builder().data(list).status(listStatus).build();
		
		logger.info("List transaction response: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
		
		// Kembalikan data response dengan status ok
		return ResponseEntity.ok(response);
	}

}
