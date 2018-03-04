package com.genius.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.genius.database.InMemoryStorage;
import com.genius.exceptions.UnsupportedFileException;
import com.genius.fileReader.FileReader;
import com.genius.fileReader.FileReaderFectory;
import com.genius.model.FileTypes;
import com.genius.model.Transaction;
import com.genius.presenter.ReportPresenter;
import com.genius.service.TransectionService;

public class TestingFileReader {
	
	static InMemoryStorage storage;
	static TransectionService service;
	static String resourceDir;
	static ReportPresenter presenter;
	static ClassPathXmlApplicationContext context;
	
	@BeforeClass
	public static void setUp() throws Exception{
		context = new ClassPathXmlApplicationContext("/com/genius/resources/applicationContext.xml");		
		storage = (InMemoryStorage) context.getBean("storage");
		service = (TransectionService) context.getBean("service");
		presenter = (ReportPresenter) context.getBean("presenter");
		resourceDir = "src/main/java/com/genius/resources/";
	}

	//testing for Excel file type
	@Test
	public void testExcelFileReader() throws UnsupportedFileException {
		String filePath = resourceDir + "Sample Data.xlsx";			
		service.persistTransections(filePath);
		
		List<Transaction> list = storage.getTransections();
		presenter.presentTransections(list);	
		
	}
}
