package edu.pnu.domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
// table이름과 class 이름이 달라서 테이블 이름 정해줘야 함
@Table(name = "total_recycle")
public class Recycling {
	@Id
	// Auto - Increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int detect_log_id;
	private int device_id;
	private String ai_result;
	private Date date;
	private String time;
	private int ce;
	private int rm;
	private String reason;
	private String img_url;
	
}
