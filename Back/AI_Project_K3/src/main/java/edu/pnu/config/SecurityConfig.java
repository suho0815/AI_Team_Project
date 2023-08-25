package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
      @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security.csrf(csrf->csrf.disable());
        security.cors();

        security
        .authorizeHttpRequests(auth -> {
            auth.requestMatchers("/user/**").authenticated()
                    .requestMatchers("/employee/**").hasAnyRole("EMPLOYEE", "MANAGER") // manager, admin만 허용
                    .requestMatchers("/Manager/**").hasRole("MANAGER") // admin만 허용
                    .anyRequest().permitAll();
        });

        security.formLogin(frmLogin->frmLogin.disable()); 
		// Form을 이용한 로그인을 사용하지 않겠다는 설정 즉 .html파일을 작성하지 않아도 된다		

        return security.build();

    }
}
