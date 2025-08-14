package com.ids.onlinetest.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ids.onlinetest.dto.ListTrxDTO;
import com.ids.onlinetest.model.Transactions;
import com.ids.onlinetest.repository.TransactionRepository;
import com.ids.onlinetest.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	// Buat formatter string untuk formate date dan big decimal
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-ss HH:mm:ss");
	private static final DecimalFormat AMOUNT_FORMATTER = new DecimalFormat("###0");

	private TransactionRepository transactionRepository;

	// Constructor Injection
	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	@Override
	public List<ListTrxDTO> getAllTransactions() {
		// Ambil data dari repositori transactions menggunakan spring jpa 
		List<Transactions> transactions = transactionRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));

		// Mapping data yang berhasil didapatkan dari db, ke dalam object response
		List<ListTrxDTO> list = mapListToResponse(transactions);

		return list;
	}

	private List<ListTrxDTO> mapListToResponse(List<Transactions> transactions) {
		// Mapping data transaksi menggunakan stream
		return transactions.stream().map(data -> {
			String transactionDate = data.getTransactionDate().toInstant().atZone(ZoneId.systemDefault())
					.format(DATE_FORMATTER);

			return ListTrxDTO.builder().id(data.getId()).productID(data.getProduct().getProductId())
					.productName(data.getProduct().getProductName()).amount(formatAmount(data.getAmount()))
					.customerName(data.getCustomer().getCustomerName()).status(data.getStatus())
					.transactionDate(transactionDate).createdBy(data.getCustomer().getCustomerName())
					.createdOn(transactionDate).build();
		}).toList();
	}
	
	private String formatAmount(BigDecimal amount) {
		return AMOUNT_FORMATTER.format(amount);
	}

}
