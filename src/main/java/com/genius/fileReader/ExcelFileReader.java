package com.genius.fileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.genius.model.Transaction;

@Service
public class ExcelFileReader implements FileReader {
	
	private static ExcelFileReader excelReader = null;
	
	private ExcelFileReader() {}
	
	public static ExcelFileReader getExcelFileReaderInstance() {
		if(excelReader == null) {
			synchronized(ExcelFileReader.class) {
				if(excelReader == null) {
					excelReader = new ExcelFileReader();
				}
			}
		}
		return excelReader;
	}
	

	@Override
	public List<Transaction> readFile(String filePath) {
		
		List<Transaction> list = new ArrayList<>();
		
		try {
            FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            iterator.next(); // to ignore header
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Transaction trns = new Transaction();
                trns.setExtTransactionId(currentRow.getCell(0).getStringCellValue());
                trns.setClientID(currentRow.getCell(1).getStringCellValue());
                trns.setSecurityID(currentRow.getCell(2).getStringCellValue());
                trns.setTransactionType(currentRow.getCell(3).getStringCellValue());
                trns.setTransactionDate(currentRow.getCell(4).getDateCellValue());
                trns.setMarketValue(currentRow.getCell(5).getNumericCellValue());
                trns.setPriority(currentRow.getCell(6).getStringCellValue());
                list.add(trns);
            }
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return list;
	}
	
	/*public static void main(String[] args) {
		ExcelFileReader reader = ExcelFileReader.getExcelFileReaderInstance();	
		String filePath = "F:\\MyWorkSpace\\MyFeeCalculator\\src\\com\\vinu\\resources\\Sample Data.xlsx";
		List<Transaction> list = reader.readFile(filePath);
		for(Transaction trx : list)
			System.out.println(trx);	
	}*/
}
