package net.ti.todo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

  private final UserDetailsService userDetailsService;

  @Bean
  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf((csrf) -> csrf.disable())
      .authorizeHttpRequests(authorize -> {
//        authorize.requestMatchers(HttpMethod.POST, "/todos/**").hasRole("ADMIN");
//        authorize.requestMatchers(HttpMethod.PUT, "/todos/**:complete").hasAnyRole("ADMIN", "USER");
//        authorize.requestMatchers(HttpMethod.PUT, "/todos/**:incomplete").hasAnyRole("ADMIN", "USER");
//        authorize.requestMatchers(HttpMethod.PUT, "/todos/**").hasRole("ADMIN");
//        authorize.requestMatchers(HttpMethod.DELETE, "/todos/**").hasRole("ADMIN");
//        authorize.requestMatchers(HttpMethod.GET, "/todos/**").hasAnyRole("ADMIN", "USER");
//        authorize.requestMatchers(HttpMethod.GET , "/todos/**").permitAll();
        authorize.anyRequest().authenticated();
      })
      .httpBasic(Customizer.withDefaults());
    return http.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
    return configuration.getAuthenticationManager();
  }
}
