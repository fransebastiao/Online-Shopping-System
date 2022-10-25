/*
 * SecurityConfig.java
 * Author: Sharfaa Sedick Anthony 220041571
 * */
package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder encoder(){
        //Encodes our passwords for a more secure login system

        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService (BCryptPasswordEncoder bCryptPasswordEncoder){
        //Creating the roles for the system
        InMemoryUserDetailsManager man = new InMemoryUserDetailsManager();
        man.createUser(User.withUsername("admin-user")
                .password(bCryptPasswordEncoder.encode("65ff7492d30"))
                .roles("ADMIN")
                .build()
        );

        man.createUser(User.withUsername("client-user")
                .password(bCryptPasswordEncoder.encode("1253208465b"))
                .roles("USER")
                .build()
        );
        return man;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
    {
        //Allocating the roles permissions
        httpSecurity.httpBasic()
                .and().csrf().disable().formLogin().disable()
                //Place all roles for different domains below

                //Path matcher For the Product System
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/**/product/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/product/delete/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/product/read/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/product/find-all").hasAnyRole("USER","ADMIN")

                //Path matcher For the Account System
                .antMatchers(HttpMethod.POST, "/**/account/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/account/delete/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/account/read/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/account/find-all").hasAnyRole("USER","ADMIN")

                //Path matcher For the Product System
                .antMatchers(HttpMethod.POST, "/**/category/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/category/delete/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/category/read/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/category/find-all").hasAnyRole("USER","ADMIN")

                //Path matcher For the Login System
                .antMatchers(HttpMethod.POST, "/**/login/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/login/delete/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/login/read/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/login/find-all").hasAnyRole("USER","ADMIN")

                //Path matcher For the Payment System
                .antMatchers(HttpMethod.POST, "/**/payment/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/payment/delete/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/payment/read/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/payment/find-all").hasAnyRole("USER","ADMIN")

                //Path matcher For the Region System
                .antMatchers(HttpMethod.POST, "/**/region/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/region/delete/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/region/read/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/region/find-all").hasAnyRole("USER","ADMIN")

                //Path matcher For the Shipment System
                .antMatchers(HttpMethod.POST, "/**/shipment/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/shipment/delete/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/shipment/read/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/shipment/find-all").hasAnyRole("USER","ADMIN")

                //Path matcher For the Shopping Cart System
                .antMatchers(HttpMethod.POST, "/**/shoppingcart/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/shoppingcart/delete/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/shoppingcart/read/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/shoppingcart/find-all").hasAnyRole("USER","ADMIN")

                //Path matcher For the User System
                .antMatchers(HttpMethod.POST, "/**/user/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/user/delete/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/user/read/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/user/find-all").hasAnyRole("USER","ADMIN")

                //Path matcher For the Order System
                .antMatchers(HttpMethod.POST, "/**/order/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/order/delete/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/order/read/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**/order/find-all").hasAnyRole("USER","ADMIN")


                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return httpSecurity.build();
    }
}
