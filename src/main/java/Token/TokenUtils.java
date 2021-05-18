package Token;

import com.google.common.collect.ImmutableMap;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class TokenUtils {
    private static final String SECRET_KEY = "@author%zhuGu";

    /**
     * 创建 token
     * @param userId 用户id
     * @param phone 手机号码
     * @return token
     */
    public static String createToken(long userId, String phone) {
        return Jwts.builder()
                .setSubject("zhuGu")
                .setExpiration(new Date(new Date().getTime() + 1000L * 60 * 60 * 24 * 600))
                .claim("userId", userId)
                .claim("phone", phone)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    /**
     * 获取用户id
     */
    public static long getUserId(String token) {
        ImmutableMap<String, Object> claims = getClaims(token);
        if (claims.isEmpty()) {
            claims = getClaims(UrlKt.decode(token, StandardCharsets.UTF_8));
        }
        return ((Number) claims.getOrDefault("userId", 0L)).longValue();
    }

    /**
     * 获取手机号码
     */
    public static String getPhone(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return (String) claims.get("phone");
    }

    private static ImmutableMap<String, Object> getClaims(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token).getBody();
            String phone = (String) claims.getOrDefault("phone", "");
            long userId = ((Number) claims.getOrDefault("userId", 0L)).longValue();
            return ImmutableMap.of(
                    "userId", userId,
                    "phone", phone
            );
        } catch (Exception ex) {
            // token invalid
            return ImmutableMap.of();
        }
    }
}
