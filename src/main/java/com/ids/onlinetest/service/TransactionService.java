package com.ids.onlinetest.service;

import java.util.List;

import com.ids.onlinetest.dto.ListTrxDTO;

public interface TransactionService {
	
	// Interface untuk mendapatkan data transaksi
	List<ListTrxDTO> getAllTransactions();
	
}
