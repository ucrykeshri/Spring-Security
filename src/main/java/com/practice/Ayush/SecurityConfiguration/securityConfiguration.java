package com.practice.Ayush.SecurityConfiguration;

import org.apache.tomcat.websocket.WsWebSocketContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//This annotation is used to enable Spring Security in your application.
// It indicates that this class will be used as a configuration class for defining security-related settings.
// We are adding users and its corresponding password who can access the api.
@EnableWebSecurity
public class securityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
       auth.inMemoryAuthentication()
               .withUser("Ayush")
               .password("Hello")
               .roles("USER");
    }


//created a ben
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
       return NoOpPasswordEncoder.getInstance();
    }
}
