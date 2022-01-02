package com.practice.client.web;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class ArticlesController {

    @Autowired
    private WebClient webClient;
    Logger logger = LogManager.getLogger();

    @GetMapping(value = "/articles")
    public String[] getArticles(
        @RegisteredOAuth2AuthorizedClient("articles-client-authorization-code") OAuth2AuthorizedClient authorizedClient
    ) {
        System.out.println("\"HI\" = " + "HI");
        logger.info("HI");
        System.out.println("authorizedClient = " + authorizedClient);
        return webClient
            .get()
            .uri("http://127.0.0.1:8091/articles")
            .attributes(oauth2AuthorizedClient(authorizedClient))
            .retrieve()
            .bodyToMono(String[].class)
            .block();
    }
}
