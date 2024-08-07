package com.chi.demo05;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


// @RestController
public class JwtAuthenticationResource {

    private JwtEncoder jwtEncoder;

    public JwtAuthenticationResource(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }
    
    @PostMapping("/authenticate")
    public JwtResponse authenticate(Authentication authentication) { 
        return new JwtResponse(createToken(authentication));
    }

    private String createToken(Authentication authentication) {
        var claims = JwtClaimsSet.builder()
                                 .issuer("self")
                                 .issuedAt(Instant.now())
                                 .expiresAt(Instant.now().plusSeconds((60*30))) // 設定 token 的過期時間為 30 分鐘後
                                 .subject(authentication.getName()) // 設定 token 的主體為認證用戶的名稱
                                 .claim("scope", createScope(authentication)) // 新增自定義聲明 scope，值為用戶的權限範圍
                                 .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    private String createScope(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(a -> a.getAuthority())
                .collect(Collectors.joining(" "));
    }

    record JwtResponse(String token) {} // Java 14 引入的一種特殊類型，用於簡化資料攜帶類的定義。它自動生成了構造函數、getter、equals()、hashCode() 和 toString() 方法
}
