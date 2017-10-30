package com.msa.common.config.security;

import com.msa.common.config.security.filter.CsrfTokenBindingRspHeaderFilter;
import com.msa.common.config.security.handler.LoginFailureHandler;
import com.msa.common.config.security.handler.LoginSuccessHandler;
import com.msa.common.config.security.handler.SignoutSuccessHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthEntryPoint          authEntryPoint;
    @Autowired
    private LoginSuccessHandler     loginSuccessHandler;
    @Autowired
    private LoginFailureHandler     loginFailureHandler;
    @Autowired
    private SignoutSuccessHandler   signoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/users/**")
                .permitAll()
                .antMatchers("/api/**", "/logout")
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()
                .httpStrictTransportSecurity()
                .disable()
                .and()
                .formLogin()
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)
                .permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .and()
                .logout()
                .deleteCookies("remove")
                .invalidateHttpSession(false)
                .logoutSuccessHandler(signoutSuccessHandler)
                .permitAll();

        // CSRF tokens handling // http.csrf().disable();
        http.addFilterAfter(new CsrfTokenBindingRspHeaderFilter(), CsrfFilter.class);
    }
}
