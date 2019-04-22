package com.bh.transaction.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transactions implements Serializable {

	private static final long serialVersionUID = 8233643476663287840L;

	private List<Transaction> transactions;

}
