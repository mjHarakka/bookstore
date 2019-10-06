package com.mikkoharakka.bookstore.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	// Another possible way to go: https://docs.spring.io/spring-security/site/docs/current/guides/html5/hellomvc-javaconfig.html
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("mikko").password(passwordEncoder().encode("sala")).roles("USER")
          .and()
          .withUser("admin").password(passwordEncoder().encode("sudo")).roles("ADMIN");
    }
	
	@Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		.antMatchers("/h2-console/**").permitAll()
        		.anyRequest().authenticated()
        		.and()
        	.formLogin()
        		.loginPage("/login")
        		.permitAll()
        		.and()
        	.logout()
        		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        		.and()
        	.httpBasic()
        	.and().csrf().ignoringAntMatchers("/h2-console/**")
        	.and().headers().frameOptions().sameOrigin();
    }	
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}