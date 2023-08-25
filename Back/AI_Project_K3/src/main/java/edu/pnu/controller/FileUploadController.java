package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.pnu.service.CSVUploadService;

// restcontroller : RESTAPI를 위한 데이터를 반환하는 컨트롤러
// json & xml 형태의 데이터를 반환하는 컨트롤러에 사용
@RestController
// 해당 컨트롤러 클래스 내의 모든 메서드에 대한 url 경로가 upload로 시작됨
//@RequestMapping("/upload")
public class FileUploadController {
	
	@Autowired
	private CSVUploadService uploadCSVService;
	
//	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/file")
	public String uploadCSVFile(@RequestParam("file") MultipartFile file) {
		return uploadCSVService.uploadCSV(file);
	}
	
}
