package com.abc.asia.mikohata.fillbagbatchjob.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Component;

@Component
@Profile("!test & !local")
public class TokenManager {

    @Value("${client.registration.name}")
    private String clientRegistrationName;

    @Value("${spring.security.oauth2.client.registration.codetable.client-id}")
    private String clientId;

    private final AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager;

    private static final Logger log = LoggerFactory.getLogger(TokenManager.class);

    public TokenManager(
            AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager) {
        this.authorizedClientManager = authorizedClientManager;
    }

    public String getAccessToken() {
        try {
            OAuth2AuthorizeRequest authorizeRequest =
                    OAuth2AuthorizeRequest.withClientRegistrationId(clientRegistrationName)
                            .principal(clientId)
                            .build();

            OAuth2AuthorizedClient authorizedClient =
                    this.authorizedClientManager.authorize(authorizeRequest);

            OAuth2AccessToken accessToken = authorizedClient.getAccessToken();

            return accessToken.getTokenValue();
        } catch (Exception e) {
            log.error("Error getting token " + e);
        }
        return null;
    }
}
