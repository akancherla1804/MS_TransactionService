package com.bh.transaction.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction implements Serializable {

	private static final long serialVersionUID = -6319016444864599904L;

	private String transactionDate;
	private String transactionDetail;
	private double transactionAmount;
	private String customerId;
	private String accountType;


}
