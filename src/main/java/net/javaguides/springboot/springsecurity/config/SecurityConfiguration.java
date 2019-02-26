package net.javaguides.springboot.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.javaguides.springboot.springsecurity.service.UserService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .anonymous()
        .and()
                .authorizeRequests()
                .antMatchers("/login")
                .permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers(
                    		"/**",
                    		"/products**",
                            "/registration**",
                            "/js/**",
                            "/css/**",
                            "/fonts.googleapis.com/css**",
                            "/img/**",
                            "/webjars/**").permitAll()
                    
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage("/login")  
                       .defaultSuccessUrl("/products", true)
                         .permitAll()
                .and()
                    .logout()
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/products")
                        .deleteCookies("my-remember-me-cokie")
                .permitAll()
        		.and()
        		.rememberMe()
        		//.key("my-secure-key")
        		.rememberMeCookieName("my-remember-me-cookie")
        		.tokenRepository(persistentTokenRepository())
        		.tokenValiditySeconds(24 * 60 * 60)
        		.and()
        		.exceptionHandling();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    PersistentTokenRepository persistentTokenRepository() {
    	JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
    	tokenRepositoryImpl.setDataSource(dataSource);
    	return tokenRepositoryImpl;
    }

}
