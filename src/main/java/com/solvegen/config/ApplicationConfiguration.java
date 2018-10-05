package com.solvegen.config;

import com.solvegen.services.BookService;
import com.solvegen.util.CatalogXmlParser;
import com.solvegen.util.LocalDateAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Application configuration class.
 *
 * @author Alexander Naumov
 */


@EnableWebMvc
@Configuration
@ComponentScan("com.solvegen")
public class ApplicationConfiguration {

    @Bean
    public BookService bookService() {
        return new BookService();
    }

    @Bean
    public LocalDateAdapter localDateAdapter() {
        return new LocalDateAdapter();
    }

    @Bean
    public CatalogXmlParser catalogXmlParser() {
        return new CatalogXmlParser();
    }

}
