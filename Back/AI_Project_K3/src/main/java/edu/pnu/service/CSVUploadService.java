package edu.pnu.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.pnu.domain.Recycling;
import edu.pnu.persistence.RecyclingRepository;

@Service
public class CSVUploadService {
	
	@Autowired
	private RecyclingRepository recyclingRepo;
	
	public String uploadCSV(MultipartFile file) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"))) {
			List<Recycling> dataList = new ArrayList<>();
			String line;
			br.readLine(); // header skip 
			while((line = br.readLine()) != null) {
				// spli을 기준으로 columns 자름(근데 csv 파일인데 뭐가 기준인건지 모르겠다..)			
//				String[] columns = line.split(",")
			}
		}catch(Exception e) {
			
		}
		
		return null;
	}
	
}
