package pl.coderslab.charity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@Configuration
@ComponentScan(value = "pl.coderslab")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource datasource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(datasource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select email, password from user where email=?")
                .authoritiesByUsernameQuery("select username, role from role where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/donations/**").access("hasRole('USER')")
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .and().logout()
                .logoutSuccessUrl("/");
        http.csrf().disable();
        http.logout();
    }
}
