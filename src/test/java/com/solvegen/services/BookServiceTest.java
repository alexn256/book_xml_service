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
        int size = service.getBooks().getBooks().size();
        service.saveOrUpdate(book);
        Catalog mainCatalog = service.getBooks();
        assertTrue(mainCatalog.getBooks().size() != size);
    }

    @Test
    public void deleteBookTest() throws JAXBException {
        int size = service.getBooks().getBooks().size();
        service.deleteBook(book);
        Catalog mainCatalog = service.getBooks();
        assertTrue(size != mainCatalog.getBooks().size());
    }
}