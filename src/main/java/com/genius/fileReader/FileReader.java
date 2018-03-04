package com.genius.fileReader;

import java.util.List;

import com.genius.model.Transaction;

public interface FileReader {
	
	public List<Transaction> readFile(String filePath);

}
