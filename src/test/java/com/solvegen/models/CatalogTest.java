package com.solvegen.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Test class for {@link Catalog} class.
 *
 * @author Alexander Naumov
 */


public class CatalogTest {

    private Catalog catalog;

    private File xml;

    @Before
    public void setup() {
        catalog = new Catalog();

        Book got = new Book();
        got.setId("bk101");
        got.setAuthor("Martin, George");
        got.setTitle("The game of thrones");
        got.setGenre("Fantasy");
        got.setPrice(9.99);
        got.setPublishDate(LocalDate.of(2000, 11, 17));
        got.setDescription("All heroes  will die...");

        Book ktm = new Book();
        ktm.setId("bk102");
        ktm.setAuthor("Harper, Lee");
        ktm.setTitle("Kill the Mockingbird");
        ktm.setGenre("Southern Gothic");
        ktm.setPrice(5.25);
        ktm.setPublishDate(LocalDate.of(1960, 7, 11));
        ktm.setDescription("Some description...");

//        catalog.addBook(got);
//        catalog.addBook(ktm);

        xml = new File("main.xml");
    }

    @After
    public void destroy() {
        catalog = null;
    }


    @Test
    public void xmlToObjectTest() throws JAXBException {
        File file = new File("main.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        catalog = (Catalog) unmarshaller.unmarshal(file);
        System.out.println(catalog.toString());
    }
}