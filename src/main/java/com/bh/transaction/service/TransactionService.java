package com.bh.transaction.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bh.transaction.constants.Constants;
import com.bh.transaction.model.Transaction;
import com.bh.transaction.model.TransactionRequest;
import com.bh.transaction.model.Transactions;

@Service
public class TransactionService {
	private final Logger logger = LoggerFactory.getLogger(TransactionService.class);

	public static Map<String, List<Transaction>> transactionMap;
	static {
		transactionMap = new HashMap<String, List<Transaction>>();
		transactionMap.put("1", new ArrayList<Transaction>());
		transactionMap.put("2", new ArrayList<Transaction>());
		transactionMap.put("3", new ArrayList<Transaction>());
		transactionMap.put("4", new ArrayList<Transaction>());
		transactionMap.put("5", new ArrayList<Transaction>());
		transactionMap.put("6", new ArrayList<Transaction>());
		Set<String> keys = transactionMap.keySet();
		for (String key : keys) {
			Transaction transaction = new Transaction(LocalDateTime.now().toString(), "Amount 15000 is Credited into Primary Current Account", 15000l,
					key, Constants.ACCOUNT_TYPE_PRIMARY);
			transactionMap.get(key).add(transaction);
		}
	}

	public Transactions updateAccountTransaction(TransactionRequest transactionRequest) {
		logger.info("Start TransactionService.updateAccountTransaction() --> Add a new Transaction for the selected customer");
		double transactionAmount = Double.parseDouble(transactionRequest.getTransactionAmount());
		if (transactionMap.containsKey(transactionRequest.getCustomerId()) && transactionAmount > 0) {
			Transaction transaction = new Transaction();
			transaction.setTransactionDetail(getTDetails(transactionAmount, transactionRequest.getTransactionType(),
					transactionRequest.getAccountType()));
			transaction.setAccountType(transactionRequest.getAccountType());
			transaction.setTransactionDate(LocalDateTime.now().toString());
			transaction.setTransactionAmount(transactionAmount);
			transaction.setCustomerId(transactionRequest.getCustomerId());
			transactionMap.get(transactionRequest.getCustomerId()).add(transaction);
			Transactions transactions = new Transactions();
			transactions.setTransactions(transactionMap.get(transactionRequest.getCustomerId()));
			return transactions;
		}
		logger.info("Start TransactionService.updateAccountTransaction() --> Selected Customer is not available in the system.");
		return null;
	}

	private String getTDetails(double amount, String tType, String aType) {
		return tType.equalsIgnoreCase(Constants.TRANSACTION_TYPE_DEBIT)
				? "Amount " + amount + " is " + tType + "ed from " + aType + " Current Account"
				: "Amount " + amount + " is " + tType + "ed into " + aType + " Current Account";

	}

	public Transactions getAllTransactions(String customerId) {
		logger.info("Start TransactionService.getAllTransactions() --> To get all transactions of a selected Customer");
		if (transactionMap.containsKey(customerId)) {
			Transactions transactions = new Transactions();
			transactions.setTransactions(transactionMap.get(customerId));
			return transactions;
		}
		logger.info("Start TransactionService.getAllTransactions() --> Selected Customer is not available in the system.");

		return null;
	}

}
