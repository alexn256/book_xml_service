package com.solvegen.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


/**
 * Simple POJO class that represents catalog of books {@link Book}.
 *
 * @author Alexander Naumov
 */


@XmlRootElement(name = "catalog")
public class Catalog {

    @XmlElement(name = "book")
    private List<Book> books = new ArrayList<>();

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
        books.forEach((book) -> builder.append(book.toString()));
        return builder.toString();
    }
}
