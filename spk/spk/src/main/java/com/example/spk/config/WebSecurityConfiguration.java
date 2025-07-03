package com.example.spk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.cors(Customizer.withDefaults())
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(
								"/",
								"/favicon.ico",
								"/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg",
								"/**/*.html", "/**/*.css", "/**/*.js"
						).permitAll()

						.requestMatchers(HttpMethod.GET, "/api/**", "/**").permitAll()
						.requestMatchers(HttpMethod.POST, "/api/**", "/**").permitAll()
						.requestMatchers(HttpMethod.PUT, "/api/**", "/**").permitAll()
						.requestMatchers(HttpMethod.DELETE, "/api/**", "/**").permitAll()

						.requestMatchers("/api/**", "/api/auth/**", "/api/users/**", "/api/files/**", "/api/car/**")
						.permitAll()

						.anyRequest().authenticated()
				);

		return http.build();
	}
}
