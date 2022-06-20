package io.brothersoo.acktion.config;

import io.brothersoo.acktion.filter.CustomAuthenticationFilter;
import io.brothersoo.acktion.filter.CustomAuthorizationFilter;
import io.brothersoo.acktion.util.AuthUtil;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final AuthUtil authUtil;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final UserDetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .userDetailsService(userDetailsService)
        .passwordEncoder(bCryptPasswordEncoder);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .cors().configurationSource(request -> {
          CorsConfiguration cors = new CorsConfiguration();
          cors.setAllowedOrigins(Arrays.asList("http://localhost:8080"));
          cors.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
          cors.setAllowedHeaders(Arrays.asList("*"));
          return cors;
        })
        .and()
        .authorizeHttpRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/auth/**").permitAll()
        .anyRequest().permitAll()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilter(
            new CustomAuthenticationFilter(authenticationManagerBean(), authUtil))
        .addFilterBefore(
            new CustomAuthorizationFilter(authUtil), UsernamePasswordAuthenticationFilter.class
        );
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
