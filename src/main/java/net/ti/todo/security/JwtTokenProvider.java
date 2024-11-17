package net.ti.todo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;


/**
 * JWT Token生成に必要となる機能を提供するクラス
 */
@Component
public class JwtTokenProvider {

  @Value("${app.jwt-secret}")
  private String jwtSecret;

  @Value("${app.jet-expiration-milliseconds}")
  private long jwtExpirationDate;

  /**
   * JWT Tokenを生成する
   *
   * @param authentication 認証情報
   * @return 生成したJWTのToken
   */
  public String generateToken(Authentication authentication) {
    String username = authentication.getName();

    Date currentDate = new Date();

    Date expiredDate = new Date(currentDate.getTime() + jwtExpirationDate);

    String token = Jwts.builder()
      .setSubject(username)
      .setIssuedAt(new Date())
      .setExpiration(expiredDate)
      .signWith(this.key())
      .compact();

    return token;
  }

  /**
   * JWT Tokenからユーザー名（メールアドレス）を取得する<br>
   *
   * @param token JWT Token
   * @return ユーザー名（メールアドレス）
   * @see "https://javadoc.io/doc/io.jsonwebtoken/jjwt-api/latest/io/jsonwebtoken/Jwts.html#parser()"
   * @see "https://javadoc.io/doc/io.jsonwebtoken/jjwt-api/latest/io/jsonwebtoken/JwtParserBuilder.html"
   * @see "https://javadoc.io/doc/io.jsonwebtoken/jjwt-api/latest/io/jsonwebtoken/JwtParser.html"
   * @see "https://javadoc.io/doc/io.jsonwebtoken/jjwt-api/latest/io/jsonwebtoken/Jwt.html"
   */
  public String getUserName(String token) {

    //    以下講座内で紹介されていたメソッド、非推奨メソッドがいくつかあるため修正する
    //    Claims claims = Jwts.parser()
    //      .setSigningKey(key())
    //      .build()
    //      .parseClaimsJws(token)
    //      .getBody();

    Claims claims = Jwts.parser()
      .verifyWith(key())
      .build()
      .parseSignedClaims(token)
      .getPayload();

    String username = claims.getSubject();

    return username;
  }

  /**
   * JWT Tokenのバリデーションを実施する
   *
   * @param token JWT Token
   * @return 検証結果（boolean）
   * @see ""
   */
  public boolean validateJwtToken(String token) {
    Jwts.parser()
      .setSigningKey(this.key())
      .build()
      .parse(token);
    return true;
  }

  /**
   * 指定されたキー バイト配列に基づいて、HMAC-SHA アルゴリズムで使用するための新しい<br>
   * JWT tokenのJWT Secretキーインスタンスを作成する<br>
   *
   * @return JWTのシークレットキー
   * @see "https://javadoc.io/doc/io.jsonwebtoken/jjwt-api/0.11.2/io/jsonwebtoken/security/Keys.html#hmacShaKeyFor(byte[])"
   */
  private SecretKey key() {
    return Keys.hmacShaKeyFor(
      Decoders.BASE64.decode(jwtSecret)
    );
  }
}
