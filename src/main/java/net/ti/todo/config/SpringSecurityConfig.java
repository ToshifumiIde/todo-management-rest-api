package net.ti.todo.config;

import lombok.RequiredArgsConstructor;
import net.ti.todo.security.JwtAuthenticationEntryPoint;
import net.ti.todo.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

  private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  private final JwtAuthenticationFilter jwtAuthenticationFilter;
  private final UserDetailsService userDetailsService;

  @Bean
  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


  /**
   * @param http HTTPリクエスト
   * @return http
   * @see "https://spring.pleiades.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html#exceptionHandling(org.springframework.security.config.Customizer)
   * @see "https://spring.pleiades.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html#addFilterBefore(jakarta.servlet.Filter,java.lang.Class)"
   */
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
        authorize.requestMatchers(HttpMethod.POST, "/login").permitAll();
        authorize.anyRequest().authenticated();
      }).httpBasic(Customizer.withDefaults());

    // 例外処理の設定、認証のエントリポイントにJWT認証のエントリポイントを追加する
    http.exceptionHandling(exception ->
      exception.authenticationEntryPoint(jwtAuthenticationEntryPoint)
    );

    // 既知のFilterクラスの1つ前に新たにJwtAuthenticationFilterを追加する（追加フィルタ、既知のフィルタクラス）
    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
    return configuration.getAuthenticationManager();
  }
}
