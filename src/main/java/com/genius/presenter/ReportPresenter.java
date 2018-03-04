package com.genius.presenter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.genius.model.Transaction;

@Service("presenter")
public class ReportPresenter {
	
	public void presentTransections(List<Transaction> list) {
	
			System.out.println("Summary Report: ");
			System.out.println("...............................................................................................................");
			System.out.println("Client ID" +"\t"+ "Security ID" +"\t"+ "Transaction Type" +"\t"+  "Transaction Date" +"\t\t\t"+  "Priority" +"\t"+  "Processing Fee");
			System.out.println("...............................................................................................................");
			for (Transaction trx : list) {
				System.out.println(trx.getClientID()+"\t\t" +trx.getSecurityID()+"\t\t" + trx.getTransactionType()+"\t\t\t" 
				+ trx.getTransactionDate()+"\t\t" + trx.getPriority()+"\t\t"  +trx.getProcessingFee());
			}			
		}
}
