package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//	@Autowired
//	private RecyclingRepository recyclingRepo;
//	
//	@Autowired
//	private AuthenticationConfiguration authConfig;
	
	
	// Security Setting
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception{
		http.csrf(abcd -> abcd.disable());
		http.sessionManagement(abcd -> abcd.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.authorizeHttpRequests(authorize -> {
			authorize
			.requestMatchers("/member/**").authenticated()
            .requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/file", "/readAllRecycle").permitAll()
            .anyRequest().authenticated();
		});
		
		http.cors();
		
		return http.build();
	}
	
}
