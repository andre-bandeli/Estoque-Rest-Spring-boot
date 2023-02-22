package com.br.Maintenance.maintenance.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("Pardeep").password(passwordEncoder().encode("test@123"))
                .authorities("USER", "ADMIN");

        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint).and()
                .authorizeRequests((request) -> request.antMatchers("/h2-console/**", "/api/v1/auth/login").permitAll()
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated())
                .addFilterBefore(new JWTAuthenticationFilter(userService, jWTTokenHelper),
                        UsernamePasswordAuthenticationFilter.class);

        http.csrf().disable().cors().and().headers().frameOptions().disable();

    }




}