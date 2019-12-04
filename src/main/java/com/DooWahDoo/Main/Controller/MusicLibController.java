package com.DooWahDoo.Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DooWahDoo.Main.Model.MusicLibrary;
import com.DooWahDoo.Main.Repo.MusicLibRepo;
import com.DooWahDoo.Main.SearchSong.MusicSearch;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@CrossOrigin
@RestController
@RequestMapping("/music")
public class MusicLibController {
	@Autowired
	private MusicSearch musicSearch;
	
	@Autowired
	private MusicLibRepo musicLibRepo;
	
//	@Autowired
//	private MusicLibrary musicLibrary;

	@GetMapping("/test")
	public String Hello(@RequestParam(value="Artist") String artist ) {
		return "Hello"+artist;
	}
	
	@GetMapping("/getExcel")
	public String getExcel() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\kaust\\Downloads\\Karaoke Catalog .xlsx";
		 Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
		 Sheet sheet = workbook.getSheetAt(0);
		 DataFormatter dataFormatter = new DataFormatter();
		 Iterator<Row> rowIterator = sheet.rowIterator();
		 int i=0;
		 int j=1;
		 MusicLibrary musicLibrary;
		 List<MusicLibrary> arr = new ArrayList<MusicLibrary>();
		 while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	            i++;
	            if(i==20000)
	            	break;
	            musicLibrary = new MusicLibrary();
	            musicLibrary.setArtist(dataFormatter.formatCellValue(row.getCell(0)));
	            musicLibrary.setDescription(" ");
	            musicLibrary.setDuration(200);
	            musicLibrary.setGenre(dataFormatter.formatCellValue(row.getCell(3)));
	            musicLibrary.setTitle(dataFormatter.formatCellValue(row.getCell(4)));
	            //musicLibRepo.save(musicLibrary);
	            arr.add(musicLibrary);
	            
//	            // Now let's iterate over the columns of the current row
//	            Iterator<Cell> cellIterator = row.cellIterator();

//	            while (cellIterator.hasNext()) {
//	            	if(j==3)
//	            	{
//	            		
//	            	}
//	                Cell cell = cellIterator.next();
//	                String cellValue = dataFormatter.formatCellValue(cell);
//	                System.out.print(cellValue + "\t");
//	            }
	            //System.out.println();
	        }
		 musicLibRepo.saveAll(arr);
		return "Success";
	}

//	@RequestMapping("/searchAll")
//	public List search(String q) {
//		List searchResults = null;
//		try {
//			searchResults = musicSearch.searchAll(q);
//		} catch (Exception ex) {
//
//		}
//
//		return searchResults;
//	}

//	@RequestMapping("/searchArtist")
//	public List searchArtist(String q) {
//		List searchResults = null;
//		try {
//			searchResults = musicSearch.searchArtist(q);
//		} catch (Exception ex) {
//
//		}
//
//		return searchResults;
//	}

//	@RequestMapping("/searchSong")
//	public List searchSong(String q) {
//		List searchResults = null;
//		try {
//			searchResults = musicSearch.searchSong(q);
//		} catch (Exception ex) {
//
//		}
//
//		return searchResults;
//	}

//	@RequestMapping("/searchGenre")
//	public List searchGenre(String q) {
//		List searchResults = null;
//		try {
//			searchResults = musicSearch.searchGenre(q);
//		} catch (Exception ex) {
//
//		}
//
//		return searchResults;
//	}
}
