import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;


@Slf4j
public class JWTDemo {

    @Test
    public void test() {

    }


    // 生成 JWT
    public static String generateToken(String data, Key key) {
        return Jwts.builder()
                .setSubject(data)   // 保存长字符串
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key)   // 使用 HMAC SHA-256 签名
                .compact();
    }

    // 解密 JWT
    public static String parseToken(String token, Key key) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static void main(String[] args) {
        String longString = "This is a long string to be shortened and encrypted";

        // 创建密钥
        byte[] secretBytes = Base64.getDecoder().decode("YXNkZkBzZGZAZHNmc2RmCg=="); // Base64 编码密钥
        Key key = new SecretKeySpec(secretBytes, SignatureAlgorithm.HS256.getJcaName());

        // 生成 token
        String jwtToken = generateToken(longString, key);
        System.out.println("生成的 JWT Token: " + jwtToken);

        // 解密 token
        String decryptedString = parseToken(jwtToken, key);
        System.out.println("解密后的字符串: " + decryptedString);
    }
}
