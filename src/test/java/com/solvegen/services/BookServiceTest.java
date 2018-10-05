package com.solvegen.services;

import com.solvegen.config.ApplicationConfiguration;
import com.solvegen.models.Book;
import com.solvegen.models.Catalog;
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

import static org.junit.Assert.*;

/**
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
        book.setId("bk101");
        book.setAuthor("Martin, George");
        book.setTitle("The game of thrones");
        book.setGenre("Fantasy");
        book.setPrice(9.99);
        book.setPublishDate(LocalDate.of(2000, 11, 17));
        book.setDescription("All heroes  will die...");
    }

    @Test
    public void getBooksTest() throws JAXBException {
        Catalog catalog = service.getBooks();
        assertNotNull(catalog);
        System.out.println(catalog.toString());
    }

    @Test
    public void saveOrUpdateTest() throws JAXBException {
        Book got = new Book();
        got.setId("bk101");

        service.deleteBook(got);

        Catalog catalog = service.getBooks();
        System.out.println(catalog.toString());
    }

    @Test
    public void deleteBookTest() throws JAXBException {
        service.deleteBook(book);
        System.out.println(service.getBooks().toString());
    }

    @Test
    public void getBookByIdTest() {
    }
}