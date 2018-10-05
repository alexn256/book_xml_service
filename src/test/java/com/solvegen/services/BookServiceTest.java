package com.solvegen.services;

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
import java.util.List;

import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.*;

/**
 * Test class for {@link BookService} class.
 *
 * @author Alexander Naumov
 */


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class BookServiceTest {

    @Autowired
    private BookService service;

    private Book book;

    @Before
    public void setup() {
        book = new Book();
        book.setId("bk103");
    }

    @After
    public void destroy() {
        book =null;
    }

    @Test
    public void getBooksTest() throws JAXBException {
        Catalog mainCatalog = service.getBooks();
        assertNotNull(mainCatalog);
        assertTrue(mainCatalog.getBooks().size() > 0);
    }

    @Test
    public void saveOrUpdateTest() throws JAXBException {
        service.saveOrUpdate(book);
        Catalog mainCatalog = service.getBooks();
        System.out.println(mainCatalog.toString());
    }

    @Test
    public void deleteBookTest() throws JAXBException {
        Catalog mainCatalog = service.getBooks();
        assertEquals(3, mainCatalog.getBooks().size());
        service.deleteBook(book);
        mainCatalog = service.getBooks();
        assertEquals(2, mainCatalog.getBooks().size());

    }
}