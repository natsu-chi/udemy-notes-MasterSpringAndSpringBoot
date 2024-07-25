package com.chi.demo02.mvc;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {
    // LDAP or Database
    // In Memory

    // customAuthenticationSuccessHandler
    private final CustomAuthenticationSuccessHandler CustomAuthenticationSuccessHandler;

    public SpringSecurityConfiguration(CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.CustomAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    // InMemoryUserDetailsManager
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        // 無加密版本
        // UserDetails userDetails = User.withDefaultPasswordEncoder()
        //                             .username("usera")
        //                             .password("123456")
        //                             .roles("USER", "ADMIN")
        //                             .build();

        // BCrypt 加密版本
        // Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        // UserDetails userDetails = User.builder()
        //                             .passwordEncoder(passwordEncoder)
        //                             .username("usera")
        //                             .password("123")
        //                             .roles("USER", "ADMIN")
        //                             .build();
        // return new InMemoryUserDetailsManager(userDetails);

        // 重構
        return createUserDetails("usera", "123");

    }

    private InMemoryUserDetailsManager createUserDetails(String name, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(name)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         // for H2 DB (tutorials - some methods deprecated)
         // http.authorizeRequests(auth -> auth.anyRequest().authenticated());
         // http.formLogin(withDefaults());
         // http.csrf().disable();
         // http.headers().frameOptions().disable();
         // return http.build();

        http.csrf(csrf -> csrf.disable())
                .headers(headers ->headers.frameOptions(frameOptions -> frameOptions.disable()))
                .authorizeHttpRequests(auth -> auth
                        // .requestMatchers("/h2-console/**").permitAll()  // 允許訪問 H2 控制台
                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .successHandler(CustomAuthenticationSuccessHandler) // 使用自定義的成功處理程序
                        .permitAll()) // 自定義登錄頁面
                .logout(logout -> logout.permitAll());
        return http.build();
    }
}
