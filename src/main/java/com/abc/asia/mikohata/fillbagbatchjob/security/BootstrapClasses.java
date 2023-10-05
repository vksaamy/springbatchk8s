package com.abc.asia.mikohata.fillbagbatchjob.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BootstrapClasses {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapClasses.class);

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    @Profile("!test & !local")
    public AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager(
            ClientRegistrationRepository clientRegistrationRepository,
            OAuth2AuthorizedClientService authorizedClientService) {
        try {
            logger.info(
                    "%%%%Start creating oauth2client" + clientRegistrationRepository.toString());
            logger.info("%%%%authorized client repo " + authorizedClientService.toString());
            OAuth2AuthorizedClientProvider authorizedClientProvider =
                    OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build();

            AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager =
                    new AuthorizedClientServiceOAuth2AuthorizedClientManager(
                            clientRegistrationRepository, authorizedClientService);

            authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
            logger.info("Finished creating oauth2client");

            return authorizedClientManager;
        } catch (Exception e) {
            logger.error("%%%Error creating authorized client manager " + e);
        }
        return null;
    }
}
