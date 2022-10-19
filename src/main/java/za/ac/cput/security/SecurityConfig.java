package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected InMemoryUserDetailsManager userDetailsService() {

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password(encoder().encode("password"))
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password(encoder().encode("password"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{

        return http
                .csrf(csfr -> csfr.disable())
                .authorizeRequests(auth -> {
                    auth.antMatchers(HttpMethod.POST,"/save").hasRole("ADMIN");
                    auth.antMatchers(HttpMethod.DELETE,"/delete/{user}").hasRole("ADMIN");
                    auth.antMatchers(HttpMethod.GET,"/read/{id}").hasRole("USER");
                    auth.antMatchers(HttpMethod.GET,"/ListAll").hasRole("USER");

                    //Path matcher For the Category System
                    auth.antMatchers(HttpMethod.POST, "/**//save").hasRole("ADMIN");
                    auth.antMatchers(HttpMethod.DELETE, "/**/category/delete/{id}").hasRole("ADMIN");
                    auth.antMatchers(HttpMethod.GET, "/**/category/read/{id}").hasAnyRole("USER","ADMIN");
                    auth.antMatchers(HttpMethod.GET, "/**/category/findall").hasAnyRole("USER","ADMIN");

                    //Path matcher For the Product System
                    auth.antMatchers(HttpMethod.POST, "/**//save").hasRole("ADMIN");
                    auth.antMatchers(HttpMethod.DELETE, "/**/product/delete/{id}").hasRole("ADMIN");
                    auth.antMatchers(HttpMethod.GET, "/**/product/read/{id}").hasAnyRole("USER","ADMIN");
                    auth.antMatchers(HttpMethod.GET, "/**/product/findall").hasAnyRole("USER","ADMIN");
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
