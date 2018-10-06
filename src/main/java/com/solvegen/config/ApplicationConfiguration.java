package com.solvegen.config;

import com.solvegen.services.BookService;
import com.solvegen.util.CatalogXmlParser;
import com.solvegen.util.LocalDateAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Application configuration class.
 *
 * @author Alexander Naumov
 */


@EnableWebMvc
@Configuration
@ComponentScan("com.solvegen")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

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
