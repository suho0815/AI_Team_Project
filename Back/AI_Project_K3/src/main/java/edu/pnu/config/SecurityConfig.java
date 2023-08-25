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
        security
        .csrf(csrf -> csrf.disable())
        .cors();

        security
        .authorizeHttpRequests(auth -> {
            auth.requestMatchers("/user/**").authenticated()
                    .requestMatchers("/employee/**").hasAnyRole("EMPLOYEE", "MANAGER") // manager, admin만 허용
                    .requestMatchers("/Manager/**").hasRole("MANAGER") // admin만 허용
                    .anyRequest().permitAll();
        });

        return security.build();

    }
}
