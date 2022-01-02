package com.practice.resource.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticlesController {

    Logger logger = LogManager.getLogger();

    @GetMapping("/articles")
    public String[] getArticles() {
        logger.info("HI");
        return new String[] { "Article 1", "Article 2", "Article 3" };
    }
}
