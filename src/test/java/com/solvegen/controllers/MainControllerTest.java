package com.solvegen.controllers;

import com.solvegen.config.ApplicationConfiguration;
import com.solvegen.models.Book;
import com.solvegen.models.Catalog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.time.LocalDate;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Test class for {@link MainController} main controller.
 *
 * @author Alexander Naumov
 */


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class MainControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        Catalog catalog = new Catalog();

        Book book1 = new Book();
        book1.setId("bk101");
        book1.setAuthor("Ralls, Kim");
        book1.setTitle("Midnight Rain");
        book1.setGenre("Fantasy");
        book1.setPrice(5.95);
        book1.setPublishDate(LocalDate.of(2000, 12, 16));
        book1.setDescription("A former architect battles corporate zombies, an" +
                "evil sorceress, and her own childhood to become queen of the world.");

        Book book2 = new Book();
        book2.setId("bk102");
        book2.setAuthor("Gambardella Matthew");
        book2.setTitle("XML Developer's Guide");
        book2.setGenre("Computer");
        book2.setPrice(44.95);
        book2.setPublishDate(LocalDate.of(2000, 10, 1));
        book2.setDescription("An in-depth look at creating applications with XML.");

        Book book3 = new Book();
        book3.setId("bk103");
        book3.setAuthor("Corets, Eva");
        book3.setTitle("Maeve Ascendant");
        book3.setGenre("Fantasy");
        book3.setPrice(5.95);
        book3.setPublishDate(LocalDate.of(2000, 11, 17));
        book3.setDescription("After thr collapse  of nanotechnology society in England, the young" +
                "survivors lay the foundation for a new  society.");

        catalog.getBooks().add(book1);
        catalog.getBooks().add(book2);
        catalog.getBooks().add(book3);

        String xmlContent = objectToXml(catalog);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .content(xmlContent);

        mockMvc.perform(request).andDo(print()).andExpect(status().isOk());
    }


    @Test
    public void getAllBooksTest() throws Exception {
        MockHttpServletRequestBuilder emptyXmlRequest = MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_XML_VALUE);

        mockMvc.perform(emptyXmlRequest).andExpect(status().isOk());
    }

    @Test
    public void saveBookTest() throws Exception {
        Catalog catalog = new Catalog();
        Book book = new Book();
        book.setId("bk117");
        book.setAuthor("God");
        book.setTitle("Holly Bible");
        book.setGenre("Drama");
        book.setPrice(0.00);
        book.setPublishDate(LocalDate.of(2000, 1, 1));
        book.setDescription("...");
        catalog.getBooks().add(book);

        String xmlContent = objectToXml(catalog);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .content(xmlContent);

        mockMvc.perform(request).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void updateBookTest() throws Exception {
        Catalog catalog = new Catalog();
        Book book = new Book();
        book.setId("bk101");
        book.setAuthor("J. K. Rowling");
        book.setTitle("Harry Potter");
        book.setGenre("Fantasy");
        book.setPrice(11.99);
        book.setPublishDate(LocalDate.of(1977, 6, 26));
        book.setDescription("...");
        catalog.getBooks().add(book);

        String xmlContent = objectToXml(catalog);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .content(xmlContent);

        mockMvc.perform(request).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteBooksTest() throws Exception {
        Catalog catalog = new Catalog();
        Book book = new Book();
        book.setId("bk117");
        catalog.getBooks().add(book);

        String xmlContent = objectToXml(catalog);

        MockHttpServletRequestBuilder xmlRequest = MockMvcRequestBuilders.
                post("/books").content(xmlContent)
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .content(xmlContent);

        mockMvc.perform(xmlRequest).andExpect(status().isOk()).andReturn();
    }

    private String objectToXml(Catalog catalog) throws JAXBException {
        StringWriter sw = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        Marshaller catalogMarshaller = context.createMarshaller();
        catalogMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        catalogMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        catalogMarshaller.marshal(catalog, sw);
        return sw.toString();
    }
}