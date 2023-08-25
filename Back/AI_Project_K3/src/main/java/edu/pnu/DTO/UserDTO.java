package edu.pnu.DTO;

import java.time.LocalDate;

import edu.pnu.domain.UserEntity;
import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String user_id;
    private String user_pw;
    private String user_pw_chk;
    private String name;
    private String email;
    private LocalDate birth;
    private String authority;

    public UserEntity toEntity() {
        return UserEntity.builder()
        .user_id(user_id)
        .user_pw(user_pw)
        .name(name)
        .email(email)
        .birth(birth)// LocalDate 생성
        .authority(authority)
        .build();
    }
}
