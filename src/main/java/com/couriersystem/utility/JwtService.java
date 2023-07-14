package com.couriersystem.utility;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.couriersystem.repository.entity.enums.Roles;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Component
public class JwtService {

    private final String issuer = "sevcanaslan";
    private final String secretKey = "dfşlgjkd543t09bjo66";

    public Optional<String> createToken(Long id, String role){
        String token= null;
        Long exDate = 1000L*60*150;
        try{
            /**
             * DİKKAT!!!!
             * Claim objelerinin içine önemli ve herkes ile paylaşmayacağınız bilgileri koymazsınız
             * email, username, password v.s. gibi önemli bilgiler payload içinde olamaz.
             */
            token = JWT.create().withAudience()
                    .withClaim("id",id)
                    .withClaim("Role", role)
                    .withIssuer(issuer) // jwt nin sahibi
                    .withIssuedAt(new Date()) // token oluşturulma tarihi
                    .withExpiresAt(new Date(System.currentTimeMillis()+exDate))
                    .sign(Algorithm.HMAC512(secretKey));
            return Optional.of(token);
        }catch (Exception exception){
            return Optional.empty();
        }
    }

    public Boolean verifyToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if(decodedJWT == null)
                return false;
        }catch (Exception exception){
            return false;
        }
        return true;
    }

    public Optional<Long> getByIdFromToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if(decodedJWT == null)
                return Optional.empty();
            Long id = decodedJWT.getClaim("id").asLong();
            return Optional.of(id);
        }catch (Exception exception){
            return Optional.empty();
        }
    }

}
