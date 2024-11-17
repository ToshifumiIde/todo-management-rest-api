package net.ti.todo.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

  /**
   * 認証処理のEntryPoint
   *
   * @param request       HTTPリクエスト
   * @param response      HTTPレスポンス
   * @param authException 認証例外
   * @see "https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/web/AuthenticationEntryPoint.html"
   */
  @Override
  public void commence(
    HttpServletRequest request,
    HttpServletResponse response,
    AuthenticationException authException) throws IOException, ServletException {

    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
  }
}
