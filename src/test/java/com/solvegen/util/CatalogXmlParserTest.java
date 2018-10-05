package com.solvegen.util;

import com.solvegen.config.ApplicationConfiguration;
import com.solvegen.models.Book;
import com.solvegen.models.Catalog;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.xml.bind.JAXBException;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Test class for {@link CatalogXmlParser} class.
 *
 * @author Alexander Naumov
 */


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class CatalogXmlParserTest {

    @Autowired
    private CatalogXmlParser catalogXmlParser;

    private Book book;

    @Before
    public void setup() {
        book = new Book();
        book.setId("bk107");
        book.setAuthor("God");
        book.setTitle("Holly Bible");
        book.setGenre("Drama");
        book.setPrice(0.00);
        book.setPublishDate(LocalDate.of(2000, 11, 17));
        book.setDescription("Everything will be good...");
    }

    @After
    public void destroy() {
        book = null;
    }

    @Test
    public void getCatalogFromFile() throws JAXBException {
        Catalog catalog = catalogXmlParser.getCatalogFromFile();
        assertNotNull(catalog);
        assertTrue(catalog.getBooks().size() > 0);
    }

    @Test
    public void saveCatalogToFile() throws JAXBException {
        int size = catalogXmlParser.getCatalogFromFile().getBooks().size();
        Catalog mainCatalog = catalogXmlParser.getCatalogFromFile();
        mainCatalog.getBooks().add(book);
        catalogXmlParser.saveCatalogToFile(mainCatalog);
        assertTrue(size != catalogXmlParser.getCatalogFromFile().getBooks().size());

    }
}