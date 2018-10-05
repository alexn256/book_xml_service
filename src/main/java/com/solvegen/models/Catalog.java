package com.solvegen.models;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple POJO class that represents catalog of books {@link Book}.
 *
 * @author Alexander Naumov
 */


@XmlRootElement(name = "catalog")
public class Catalog {

    @XmlElement(name = "book")
    private List<Book> books;


    /**
     * Returns all books {@link Book} from catalog.
     *
     * @return books {@link Book} catalog.
     */

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        books.forEach((book) -> builder.append(book.toString()).append("\n\n"));
        return builder.toString();
    }
}
