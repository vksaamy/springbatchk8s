package com.abc.asia.mikohata.fillbagbatchjob.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.io.Serializable;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class TokenUtil implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(TokenUtil.class);

    @Value("${keycloak.token.signkey:nokey}")
    public String SIGNING_KEY;

    public String AUTHORITIES_KEY = "resource_access";

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = null;
        try {
            claims = getAllClaimsFromToken(token);
        } catch (ExpiredJwtException e) {
            log.error("ExpiredJwtException" + e);
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            log.error("UnsupportedJwtException" + e);
        } catch (MalformedJwtException e) {
            log.error("MalformedJwtException" + e);
        } catch (SignatureException e) {
            log.error("MalformedJwtException" + e);
        } catch (IllegalArgumentException e) {
            log.error("SignatureException" + e);
        } catch (NoSuchAlgorithmException e) {
            log.error("NoSuchAlgorithmException" + e);
        } catch (InvalidKeySpecException e) {
            log.error("InvalidKeySpecException" + e);
        }
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token)
            throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException,
                    SignatureException, IllegalArgumentException, NoSuchAlgorithmException,
                    InvalidKeySpecException {
        return Jwts.parser()
                .setSigningKey(generatePublicKey(SIGNING_KEY))
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    UsernamePasswordAuthenticationToken getAuthenticationToken(
            final String token, final Authentication existingAuth, final UserDetails userDetails) {

        JwtParser jwtParser = null;
        try {
            jwtParser = Jwts.parser().setSigningKey(generatePublicKey(SIGNING_KEY));
        } catch (NoSuchAlgorithmException e) {
            log.error("No such algorithm" + e);
        } catch (InvalidKeySpecException e) {
            log.error("Invalid Key Spec Exception " + e);
        }

        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

        final Claims claims = claimsJws.getBody();
        // log.debug("###" + claims.toString());
        //        for (Map.Entry<String, Object> entry : claims.entrySet()) {
        //            log.debug("$$$$" + entry.getKey() + " = " + entry.getValue());
        //        }
        //        final Collection<? extends GrantedAuthority> authorities =
        //                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
        //                        .map(SimpleGrantedAuthority::new)
        //                        .collect(Collectors.toList());
        final Map<String, Object> resourceAccess =
                (Map<String, Object>) claims.get("resource_access");
        // final Map<String, Object> clientAccess = ((Map<String, Object>)
        // resourceAccess.get("CODETABLE01"));
        final Map.Entry<String, Object> clientEntry = resourceAccess.entrySet().iterator().next();
        // final Map<String, Object> clientAccess =  ((Map<String, Object>)
        // resourceAccess.get("SYSVAR01"));
        final Map<String, Object> clientAccess =
                (Map<String, Object>) resourceAccess.get(clientEntry.getKey());
        // final List roles = (List<String>) clientAccess.get("roles");
        final List<? extends GrantedAuthority> authorities =
                Arrays.stream(
                                clientAccess
                                        .get("roles")
                                        .toString()
                                        .replace("[", "")
                                        .replace("]", "")
                                        .split(","))
                        .map(roleName -> "ROLE_" + roleName.trim()) // prefix to map to a Spring
                        // Security "role"
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }

    public PublicKey generatePublicKey(String publicKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        KeyFactory kf = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec pubKeySpecX509EncodedKeySpec =
                new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
        return kf.generatePublic(pubKeySpecX509EncodedKeySpec);
    }
}
