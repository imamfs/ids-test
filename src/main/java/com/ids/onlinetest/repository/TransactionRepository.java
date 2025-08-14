package com.ids.onlinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ids.onlinetest.model.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {

}
