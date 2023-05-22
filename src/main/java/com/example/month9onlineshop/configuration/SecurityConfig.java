package com.example.month9onlineshop.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin(Customizer.withDefaults());
//                .loginPage("/login")
//                .failureUrl("/login?error=true");

        http.logout(Customizer.withDefaults());
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")
//                .clearAuthentication(true)
//                .invalidateHttpSession(true);

        http.authorizeRequests().antMatchers("/cartItems/**").permitAll();


        http.authorizeRequests()
                .antMatchers("/profile")
                .authenticated()
                .and()
                .authorizeRequests()
                .anyRequest()
                .permitAll();


        http.sessionManagement().maximumSessions(50);

        http.csrf().disable();
//        http
//                .csrf(csrf ->
//                        csrf
//                                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                );


    }
}
