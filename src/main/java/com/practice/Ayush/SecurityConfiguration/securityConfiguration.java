package com.practice.Ayush.SecurityConfiguration;

import org.apache.tomcat.websocket.WsWebSocketContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
               .roles("USER")
               .and()
               .withUser("Ritika")
               .password("World")
               .roles("ADMIN");
    }
    // This function takes http requests as parameters and
    // only gives authorization to apis with /**(all) but with
    // user role = "USER"
    //.hasanyRole() -> we can add multiple user roles.
    @Override
    protected void configure(HttpSecurity http)throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/admin")
                .hasRole("ADMIN").antMatchers("/user")
                .hasRole("USER")
                .antMatchers("/")
                .permitAll()
                .and().formLogin();
    }


//created a ben
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
       return NoOpPasswordEncoder.getInstance();
    }

}
