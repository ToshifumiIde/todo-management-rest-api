package net.ti.todo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


/**
 * Spring Securityの実行前に実行される
 * 認証用途として、JWT Tokenの検証とユーザー情報をSpringSecurityに提供する
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtTokenProvider jwtTokenProvider;
  private final UserDetailsService userDetailsService;
  private static final String BEARER = "Bearer ";

  /**
   * サーブレット・コンテナ（Javaプログラムを動かすソフト）からサーブレット（Javaプログラム）に到達するまでの前処理（フィルタ）を実行する<br>
   * <ol>
   *   <li>JWT Tokenの取得</li>
   *   <li>JWT Tokenの検証</li>
   *   <li>ユーザー詳細情報の取得</li>
   * </ol>
   *
   * @param request     HTTPリクエスト
   * @param response    HTTPレスポンス
   * @param filterChain フィルターチェーン（ = サーブレット・コンテナから提供される、リソースに対するフィルタリングされたリクエストの呼び出しチェーン）
   * @see "https://spring.pleiades.io/spring-framework/docs/current/javadoc-api/org/springframework/web/filter/OncePerRequestFilter.html#doFilter(jakarta.servlet.ServletRequest,jakarta.servlet.ServletResponse,jakarta.servlet.FilterChain)"
   */
  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request,
                                  @NonNull HttpServletResponse response,
                                  @NonNull FilterChain filterChain) throws ServletException, IOException {

    // Get JWT Token from HTTP Request
    String token = getTokenFromHttpRequest(request);

    // validate token
    if (StringUtils.hasText(token) && jwtTokenProvider.validateJwtToken(token)) {
      String username = jwtTokenProvider.getUserName(token);

      UserDetails userDetails = userDetailsService.loadUserByUsername(username);

      UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
        userDetails,
        null,
        userDetails.getAuthorities()
      );

      authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    filterChain.doFilter(request, response);
  }

  /**
   * HTTPリクエストヘッダーからJWT Tokenを取得する<br>
   * Authorization HeaderがBearer の場合：Bearer を除いたTokenを返却<br>
   * Authorization HeaderがBearer 以外：nullを返却
   *
   * @param request HTTPリクエスト
   * @return Token または null
   */
  private String getTokenFromHttpRequest(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");

    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER)) {
      return bearerToken.substring(BEARER.length());
    }

    return null;
  }

}
