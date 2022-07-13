package com.tribune.backend.infrastructure.config.security;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.filter.KeycloakAuthenticationProcessingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**
 * The {@link EnableGlobalMethodSecurity} enables direct config of role-based access
 * to our controllers. See the following example:
 * <pre>{@code
 * @PreAuthorize("hasRole('USER')")
 * @GetMapping("/title)
 * public ResponseEntity<String>getTitle(){
 *      //
 *      return title;
 * }
 * }</pre>
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@KeycloakConfiguration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    /**
     * The other way around
     * return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
     * */
    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new NullAuthenticatedSessionStrategy();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        super.configure(http);
        // Enable CORS and disable CSRF
        http
                .cors()
                .and()
                .csrf().disable()
                // Set session management to stateless
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/v1/transaction/status/**").hasRole(MERCHANT)
                .antMatchers(HttpMethod.POST, "/v1/transaction/**").hasRole(MERCHANT)
                .antMatchers(HttpMethod.POST, "/v1/users/**").anonymous()
                .antMatchers(HttpMethod.GET, "/api/user-data/me", "/actuator/**").permitAll()
                .antMatchers(HttpMethod.GET, "/v1/dummy/**").permitAll()
                .antMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs", "/v3/api-docs/**").permitAll()
                .anyRequest().fullyAuthenticated();
    }

    /**
     * provided by keycloak to handle authentication failures.
     * */
    @Bean
    @Override
    protected KeycloakAuthenticationProcessingFilter keycloakAuthenticationProcessingFilter() throws Exception {
        KeycloakAuthenticationProcessingFilter filter = new KeycloakAuthenticationProcessingFilter(this.authenticationManagerBean());
        filter.setSessionAuthenticationStrategy(this.sessionAuthenticationStrategy());
        filter.setAuthenticationFailureHandler(new TribuneKeycloakAuthenticationFailureHandler());
        return filter;
    }

    public static final String MERCHANT = "merchant";
    public static final String USER = "user";
    public static final String MANAGE_USERS = "manage-users";
}