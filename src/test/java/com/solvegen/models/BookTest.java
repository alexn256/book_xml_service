package com.solvegen.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.*;
import java.time.LocalDate;

/**
 * Test class for {@link Book} class.
 *
 * @author Alexander Naumov
 */


public class BookTest {

    private Book book;

    private File xml;

    @Before
    public void setUp() {
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


        xml = new File("mail.xml");
    }

    @After
    public void destroy() {
        book = null;
    }

    @Test
    public void objectToXmlTest() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.marshal(book, System.out);
    }

}