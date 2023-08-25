package edu.pnu.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
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
	
//	read csv file -> insert DB
	public String uploadCSV(MultipartFile file) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"))) {
			List<Recycling> dataList = new ArrayList<>();
			String line;
			br.readLine(); // header skip
			while ((line = br.readLine()) != null) {
				// spli을 기준으로 columns 자름(근데 csv 파일인데 뭐가 기준인건지 모르겠다..)
				String[] columns = line.split(",");

				Long detect_log_id = Long.parseLong(columns[0]);
				Integer device_id = Integer.parseInt(columns[1]);
				String ai_result = columns[2];
				LocalDate date = LocalDate.parse(columns[3]);
				String time = columns[4];
				Integer ce = Integer.parseInt(columns[5]);
				Integer rm = Integer.parseInt(columns[6]);
				String reason = columns[7];
				String img_url = columns[8];
				
				Recycling recycle = new Recycling();
				
				recycle.setDetect_log_id(detect_log_id);
				recycle.setDevice_id(device_id);
				recycle.setAi_result(ai_result);
				recycle.setDate(date);
				recycle.setTime(time);
				recycle.setCe(ce);
				recycle.setRm(rm);
				recycle.setReason(reason);
				recycle.setImg_url(img_url);
				
				dataList.add(recycle);
			}
			
			recyclingRepo.saveAll(dataList);
			br.close();
			
			return "Upload Success";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Error Occurred : " + e.getMessage();
		}
	}
}
