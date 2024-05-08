package com.goott.EComponents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.goott.EComponents.model.PCImageRepository;

@Service
public class Upload {
	
	@Autowired
	private PCImageRepository prepository;	
	
	public boolean fileUpload(MultipartFile mFile, int pnum) {
		boolean isUpload = false;
		String uploadPath = "C:\\NCS\\workspace(springBoot)\\EComponents\\src\\main\\resources\\static\\";
		
		
		
	}
	
	
	
}
