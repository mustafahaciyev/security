package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.formLogin(login -> login.loginPage("/login").permitAll())
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(HttpMethod.GET,"/security/public").permitAll()
                        .requestMatchers(HttpMethod.POST,"/security/public").hasAuthority("USER")
                        .requestMatchers("security/user").hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers("security/admin").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails publicUser = User.withDefaultPasswordEncoder()
//                .username("public")
//                .password("password")
//                .authorities("PUBLIC")
//                .build();
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .authorities("USER")
//                .build();
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("password")
//                .authorities("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user,publicUser,admin);
//
//    }

}
