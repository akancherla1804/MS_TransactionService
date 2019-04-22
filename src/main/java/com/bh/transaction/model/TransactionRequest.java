package com.bh.transaction.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest implements Serializable {

	private static final long serialVersionUID = 3153511678059984082L;
	private String customerId;
	private String transactionAmount;
	private String transactionType;
	private String accountType;

}
