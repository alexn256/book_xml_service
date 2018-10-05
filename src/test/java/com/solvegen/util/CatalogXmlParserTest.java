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
        book.setId("bk103");
        book.setAuthor("Corets, Eva");
        book.setTitle("Maeve Ascendant");
        book.setGenre("Fantasy");
        book.setPrice(5.95);
        book.setPublishDate(LocalDate.of(2000, 11, 17));
        book.setDescription("After the collapse of a nanotechnology " +
                "society in England, the young survivors lay the foundation " +
                "for a new society.");
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
        assertEquals(catalog.getBooks().size(), 2);
    }

    @Test
    public void saveCatalogToFile() throws JAXBException {
        Catalog catalog = catalogXmlParser.getCatalogFromFile();
        catalog.getBooks().add(book);
        catalogXmlParser.saveCatalogToFile(catalog);

    }
}