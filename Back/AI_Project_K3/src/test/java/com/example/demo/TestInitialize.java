package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import edu.pnu.domain.Recycling;

@SpringBootTest
public class TestInitialize {

//	@Test
	public String uploadCSV(MultipartFile file) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"))) {
			List<Recycling> dataList = new ArrayList<>();
			String line;
			br.readLine(); // header skip 
			while((line = br.readLine()) != null) {
				// spli을 기준으로 columns 자름(근데 csv 파일인데 뭐가 기준인건지 모르겠다..)		
//				uploadRecord(line);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
//	@Test
	public String uploadRecord() {
		String str = "3635,1,\"{\"\"can\"\": 1, \"\"paper\"\": 1, \"\"vinyl\"\": 1}\",2023-08-17,12:22:54,f,,,가";
		System.out.println(str);
		return null;
	}
	
	@Test
	public String test() {
		System.out.println("hihi");
		return "hihi";
	}
}
