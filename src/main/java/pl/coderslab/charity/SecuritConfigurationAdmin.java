package pl.coderslab.charity;

import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.charity.repository.SuccessLoginHandler;

@EnableWebSecurity
@Configuration
@ComponentScan(value = "pl.coderslab")
class SecurityConfigurationAdmin extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoderAdmin() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource datasource;

    @Autowired
    private SuccessLoginHandler handler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(datasource)
                .passwordEncoder(passwordEncoderAdmin())
                .usersByUsernameQuery("select email, password, enabled from user where email=?")
                .authoritiesByUsernameQuery("select username, role from role where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ADMIN')").anyRequest().authenticated()
                .and().formLogin()
                .defaultSuccessUrl("/admin")
                .loginPage("/login")
                .successHandler(handler);
        http.csrf().disable();
        http.logout();
    }
}
