package com.aes.iqbtestcaserest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class WebConfig {
//     @Bean
//     WebMvcConfigurer corsConfig() {
//         return new WebMvcConfigurer() {
//             @Override
//             public void addCorsMappings(CorsRegistry registry) {
//                 registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
//                         .allowedOrigins("http://localhost:4200/");
//             }
//         };
//     }
// }

@Configuration
public class WebConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeHttpRequests((authz) -> authz
                                .anyRequest().permitAll()
                )
                .csrf(csrf -> csrf
                        .disable());
        // @formatter:on
        return http.build();
    }
}
