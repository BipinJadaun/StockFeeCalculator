package com.genius.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genius.model.ProcessingFee;
import com.genius.model.Transaction;
import com.genius.model.TransactionType;

@Service
public class FeeCalculator {
	
	@Autowired
	private ServiceHelper helper;

	/*
	 * calculates processing fee for all the transactions
	 * @param Transection List
	 * @return Transection List updated with processing fee
	 */
	public List<Transaction> calculateProcessingFee(List<Transaction> transections){
		
		double processingFee = 0;		
		List<Transaction> transectionsWithFee = new ArrayList<>();
		
		for(Transaction trx : transections) {
			if(helper.isIntradayTransaction(trx, transections)) {
				processingFee = ProcessingFee.TEN.getFees();
			}else{
				processingFee = calculateFee(trx);				
			}
			trx.setProcessingFee(processingFee);
			transectionsWithFee.add(trx);
		}
		return transectionsWithFee;	
	}
	
		/*
		 * Calculates the processing fee for non intraday transactions
		 * @param Transection
		 * @return processing fee for given transaction 
		 */
		private double calculateFee(Transaction trx) {
			
			double processingFee = 0;

			if(trx.getPriority().equals("Y")){
				processingFee = ProcessingFee.FIVE_HUNDREAD.getFees();	
			} 
			else if(trx.getTransactionType().equals(TransactionType.SELL.toString()) || trx.getTransactionType().equals(TransactionType.WITHDRAW.toString())){
				processingFee = ProcessingFee.HUNDREAD.getFees();
			}
			else if(trx.getTransactionType().equals(TransactionType.BUY.toString()) || trx.getTransactionType().equals(TransactionType.DEPOSIT.toString())){
				processingFee = ProcessingFee.FIFTY.getFees();			
			}
			
			return processingFee;
		}

}
