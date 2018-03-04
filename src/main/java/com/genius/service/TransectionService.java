package com.genius.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genius.database.InMemoryStorage;
import com.genius.fileReader.FileReader;
import com.genius.model.Transaction;


@Service("service")
public class TransectionService {
	
	@Autowired
	private FileReader fileReader;
	
	@Autowired
	private InMemoryStorage storage;
	
	@Autowired
	private FeeCalculator feeCalculator;
	
	
	/*
	 * read transactions from input file and persist in inMemoryStorage
	 * @param filepath 	
	 */
	public void persistTransections(String filePath){
		
		List<Transaction> transections = fileReader.readFile(filePath);
		List<Transaction> transectionsWithFee = feeCalculator.calculateProcessingFee(transections);
		storage.saveTransections(transectionsWithFee);		
	}
}
