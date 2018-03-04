package com.genius.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.genius.model.Transaction;

@Repository("storage")
public class InMemoryStorage {
	
	List<Transaction> transectionList = new ArrayList<>();
	
	public void saveTransections(List<Transaction> list) {
		transectionList.addAll(list);
	}
	
	public List<Transaction> getTransections(){
		return transectionList;
	}

}
