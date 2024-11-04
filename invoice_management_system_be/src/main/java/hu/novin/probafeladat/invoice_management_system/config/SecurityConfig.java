package hu.novin.probafeladat.invoice_management_system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(customizer -> customizer.disable());

        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

        httpSecurity.authorizeHttpRequests(requests -> requests
                .requestMatchers("/auth/login").permitAll()
                .requestMatchers("/auth/logout").permitAll()
                .requestMatchers("/users/{id}").hasAuthority("VIEW_ADMIN_PAGE")
                .requestMatchers("/users/getAllUsers").hasAuthority("VIEW_ADMIN_PAGE")
                .requestMatchers("/users/removeUser").hasAuthority("VIEW_ADMIN_PAGE")
                .requestMatchers("/users/createUser").hasAuthority("VIEW_INVOICES")
                .requestMatchers("/users/current-user").hasAuthority("VIEW_INVOICES")
                .requestMatchers("/invoices/{id}").hasAuthority("VIEW_INVOICES")
                .requestMatchers("/invoices/getAllInvoices").hasAuthority("VIEW_INVOICES")
                .requestMatchers("/invoices/createInvoice").hasAuthority("MANAGE_INVOICE")
                .requestMatchers("/invoices/removeInvoice/{id}").hasAuthority("MANAGE_INVOICE")
                .requestMatchers("/roles/{id}").hasAuthority("VIEW_ADMIN_PAGE")
                .requestMatchers("/roles/{name}").hasAuthority("VIEW_ADMIN_PAGE")
                .requestMatchers("/roles/getAllRoles").hasAuthority("VIEW_ADMIN_PAGE")
                .requestMatchers("/roles/createRole").hasAuthority("VIEW_ADMIN_PAGE")
        );

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        return provider;
    }

}
