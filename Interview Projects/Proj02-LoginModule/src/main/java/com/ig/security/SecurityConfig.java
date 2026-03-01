package com.ig.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
//@EnableWebSecurity
public class SecurityConfig 
{
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity httpSecurity)
	 * throws Exception { httpSecurity .authorizeHttpRequests( auth -> auth
	 * .requestMatchers("/auth/**").permitAll() .anyRequest().authenticated() );
	 * return httpSecurity.build(); }
	 */

		/*
		 * @Bean public AuthenticationManager authenticationManager(
		 * AuthenticationConfiguration config) throws Exception { return
		 * config.getAuthenticationManager(); }
		 */

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
		/*
		 * @Bean public UserDetailsService userDetailsService(DataSource dataSource) {
		 * return new JdbcUserDetailsManager(dataSource); }
		 */
}
