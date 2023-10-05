package com.abc.asia.mikohata.fillbagbatchjob.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class KeycloakRealmRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    // @Value("${keycloak.client.id}")
    public String clientId;

    private static final Logger log = LoggerFactory.getLogger(KeycloakRealmRoleConverter.class);

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {

        final Map<String, Object> resourceAccess =
                (Map<String, Object>) jwt.getClaims().get("resource_access");
        // final Map<String, Object> clientAccess = ((Map<String, Object>)
        // resourceAccess.get(clientId));
        final Map.Entry<String, Object> clientEntry = resourceAccess.entrySet().iterator().next();
        // final Map<String, Object> clientAccess =  ((Map<String, Object>)
        // resourceAccess.get("SYSVAR01"));
        final Map<String, Object> clientAccess =
                (Map<String, Object>) resourceAccess.get(clientEntry.getKey());
        final List authorities =
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
        return authorities;
    }
}
