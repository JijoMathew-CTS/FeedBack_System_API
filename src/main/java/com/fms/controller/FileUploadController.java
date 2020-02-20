package com.fms.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fms.service.ExcelService;

@CrossOrigin(origins = "*")
@RestController
public class FileUploadController {
	
	private String fileLocation;
	
	@Autowired
	ExcelService excelService;
	 
	@PostMapping("/uploadFile")
	public String uploadFile(Model model, MultipartFile file) throws IOException, InvalidFormatException {
	   
		InputStream in = file.getInputStream();
	    File currDir = new File(".");
	    String path = currDir.getAbsolutePath();
	    fileLocation = path.substring(0, path.length() - 1) + "TempUploads\\"+file.getOriginalFilename();
	        
	    FileOutputStream f = new FileOutputStream(fileLocation);
	    int ch = 0;
	    while ((ch = in.read()) != -1) {
	        f.write(ch);
	    }
	    f.flush();
	    f.close();
	    model.addAttribute("message", "File: " + file.getOriginalFilename() 
	      + " has been uploaded successfully!");
	    
	   excelService.saveExcel(fileLocation,file.getOriginalFilename());
	    
	    return "excel";
	}
}
