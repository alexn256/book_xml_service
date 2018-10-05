package com.solvegen.services;

import com.solvegen.models.Book;
import com.solvegen.models.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author Alexander Naumov
 */


public class BookService {

    private Catalog catalog;

    private static final File file = new File("main.xml");

    /**
     * Returns all books {@link Book} from the main.xml.
     *
     * @return {@link Catalog} catalog of books.
     */

    public Catalog getBooks() {
        return null;
    }

    /**
     * Adds or updates book {@link Book} to the catalog.
     *
     * @param book to be added to main.xml.
     */

    public void saveOrUpdate(Book book) {

    }

    /**
     * Deletes book {@link Book} from catalog by id.
     *
     * @param book to be removed from the main.xml.
     */

    public void deleteBook(Book book) {

    }


    private Catalog getCatalogFromFile() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        catalog = (Catalog) unmarshaller.unmarshal(file);
        return catalog;
    }

    private void saveCatalogToFile(Catalog catalog) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.marshal(catalog, file);
    }
}
