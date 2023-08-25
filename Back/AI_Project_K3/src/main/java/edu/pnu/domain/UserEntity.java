//회원 정보를 담는 Entity Class

package edu.pnu.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "user_db")
@NoArgsConstructor
@Table(name = "user_db")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 주요 식별자 값이 데이터베이스에서 자동으로 생성되도록 지정하는 어노테이션. 여기서는 IDENTITY 전략을 사용하여 자동 생성.
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id", unique = true)
    // 엔터티 필드와 데이터베이스 컬럼을 매핑하는 어노테이션. 필드 이름과 컬럼 이름이 다를 경우에 사용. 혹시나 잘못 입력될 수도 있어서
    // 추가적으로 기입한 것임.
    private String user_id;

    @Column(name = "user_pw")
    private String user_pw;

    @Transient
    // DB에 저장하지 않아도 됨. Test 후 DB 열 수정 예정.
    private String user_pw_chk;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "authority")
    private String authority;

    @Builder
    public UserEntity(
        Integer id,
        String user_id,
        String user_pw,
        String user_pw_chk,
        String name,
        String email,
        LocalDate birth,
        String authority) {
            this.id = id;
            this.user_id = user_id;
            this.user_pw = user_pw;
            this.user_pw_chk = user_pw_chk;
            this.name = name;
            this.email = email;
            this.birth = birth;
            this.authority = authority;
        }
}
