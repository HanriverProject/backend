package com.example.hanriver.infrastructure.web.auth.security;

import com.example.hanriver.infrastructure.web.auth.oauth2.handler.OAuth2LoginFailureHandler;
import com.example.hanriver.infrastructure.web.auth.oauth2.handler.OAuth2LoginSuccessHandler;
import com.example.hanriver.infrastructure.web.auth.oauth2.service.CustomOAuth2UserService;
import com.example.hanriver.infrastructure.web.auth.oauth2.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import java.util.Arrays;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@AllArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfigure {
    private final OAuth2LoginFailureHandler oAuth2LoginFailureHandler;
    private final OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(form->form.loginPage("/login").disable()) // FormLogin 사용 X
                .httpBasic(AbstractHttpConfigurer::disable) // httpBasic 사용 X
                .csrf(AbstractHttpConfigurer::disable)// csrf 보안 사용 X
                .sessionManagement(sesson -> sesson.sessionCreationPolicy(STATELESS))
                .securityMatcher("/**")
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("sign-up").permitAll())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/","/css/**","/images/**","/js/**","/favicon.ico","/h2-console/**").permitAll())
                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
                .oauth2Login(oauth -> oauth.failureHandler(oAuth2LoginFailureHandler).successHandler((oAuth2LoginSuccessHandler)));




        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(provider);
    }



}
