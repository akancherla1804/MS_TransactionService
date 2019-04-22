package com.bh.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bh.transaction.constants.Constants;
import com.bh.transaction.model.TransactionRequest;
import com.bh.transaction.model.Transactions;
import com.bh.transaction.service.TransactionService;


@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@PostMapping(Constants.URI_ADD_TRANSACTION)
	public Transactions updateAccount(@RequestBody TransactionRequest transactionRequest) {
		return transactionService.updateAccountTransaction(transactionRequest);
	}
	
	@GetMapping(Constants.URI_GET_ALL_TRANSACTION)
	public Transactions getTransactions(@PathVariable String customerId) {
		return transactionService.getAllTransactions(customerId);
	}
}
