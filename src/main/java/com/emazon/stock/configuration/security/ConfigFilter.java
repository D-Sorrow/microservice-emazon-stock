package com.emazon.stock.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static com.emazon.stock.configuration.ConstantsConfiguration.AUTHENTICATION_GET_ARTICLE_HAS_ROLE;
import static com.emazon.stock.configuration.ConstantsConfiguration.URL_AUTHENTICATION_ADD_ARTICLE;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigFilter {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity
                    .csrf(AbstractHttpConfigurer::disable)
                    .httpBasic(Customizer.withDefaults())
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(http -> {
                        //http.requestMatchers("").permitAll();

                        http.requestMatchers(URL_AUTHENTICATION_ADD_ARTICLE)
                                .hasRole(AUTHENTICATION_GET_ARTICLE_HAS_ROLE);

                        http.anyRequest().permitAll();
                    })
                    .build();
    }

}
