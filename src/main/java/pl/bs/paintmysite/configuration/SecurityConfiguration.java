package pl.bs.paintmysite.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.GET).permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.POST).fullyAuthenticated()
                .and().authorizeRequests().antMatchers(HttpMethod.PUT).fullyAuthenticated()
                .and().authorizeRequests().antMatchers(HttpMethod.DELETE).fullyAuthenticated()
                .and().httpBasic();
        httpSecurity.csrf().disable();
        try{

        }finally {

        }
    }


    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
    }
}
