package edu.pnu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.pnu.persistence.RecyclingRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

<<<<<<< HEAD
	@Autowired
	private RecyclingRepository recyclingRepo;
	
	@Autowired
	private AuthenticationConfiguration authConfig;
	
	
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
	
	// password 암호화
     @Bean
     public BCryptPasswordEncoder encodePwd() {
         return new BCryptPasswordEncoder();
     }

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
    //     security.authorizeHttpRequests(auth -> {
    //         auth.requestMatchers("/user/**").authenticated()
    //                 .requestMatchers("/employee/**").hasAnyRole("EMPLOYEE", "MANAGER") // manager, admin만 허용
    //                 .requestMatchers("/Manager/**").hasRole("MANAGER") // admin만 허용
    //                 .anyRequest().permitAll();
    //     });
=======
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
>>>>>>> b9f9eee9a81cce4f053f65698aadfd5cb3ff4b09

    //     return security.build();

    // }
}
