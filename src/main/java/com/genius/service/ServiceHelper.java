package com.genius.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.genius.model.Transaction;
import com.genius.model.TransactionType;

@Service("helper")
public class ServiceHelper {
	
	/*
	 * checks if a transaction is IntraDay
	 * @param Transaction
	 * @param Transections List
	 * @return is given transaction intraday or not
	 */
	public boolean isIntradayTransaction(Transaction trx, List<Transaction> transections) {
		boolean isIntraDay = false;
		
		for (Transaction trans : transections) {
			if(trans.getClientID().equals(trx.getClientID()) && trans.getSecurityID().equals(trx.getSecurityID()) && trans.getTransactionDate().equals(trx.getTransactionDate())){
				if((trans.getTransactionType().equals(TransactionType.BUY.toString()) && trx.getTransactionType().equals(TransactionType.SELL.toString())) ||
						(trans.getTransactionType().equals(TransactionType.SELL.toString()) && trx.getTransactionType().equals(TransactionType.BUY.toString()))){
					isIntraDay = true;						
					break;
				}
			}
		}
		return isIntraDay;	
	}

}
