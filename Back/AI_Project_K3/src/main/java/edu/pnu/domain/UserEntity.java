//회원 정보를 담는 Entity Class

package edu.pnu.domain;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Table(name="user_db")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 주요 식별자 값이 데이터베이스에서 자동으로 생성되도록 지정하는 어노테이션. 여기서는 IDENTITY 전략을 사용하여 자동 생성.
    private Integer id;
    @Column(columnDefinition = "user_id")
    private String userId;
    private String user_pw;
    @Transient
    // DB에 저장하지 않아도 됨. Test 후 DB 열 수정 예정.
    private String user_pw_chk;
    private String name;
    private String email;
    private LocalDate birth;
    private String authority;

}
