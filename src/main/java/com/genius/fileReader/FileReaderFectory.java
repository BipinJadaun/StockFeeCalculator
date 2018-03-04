package com.genius.fileReader;

import com.genius.exceptions.UnsupportedFileException;
import com.genius.model.FileTypes;

public class FileReaderFectory {
	
	public static FileReader getFileReader(FileTypes fileType) throws UnsupportedFileException {		
		switch (fileType){
			case EXCEL:
				return ExcelFileReader.getExcelFileReaderInstance();
			case CSV:				
				return new CSVFileReader();
			case XML:
				return new XMLFileReader();
			case TEXT:
				return new TextFileReader();
			default:
				System.out.println("PLease enter a valid file Type..");
				throw new UnsupportedFileException("unsupported file type"+ fileType.toString());
		}		
	}
}
