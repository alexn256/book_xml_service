package com.solvegen.services;

import com.solvegen.models.Book;
import com.solvegen.models.Catalog;
import com.solvegen.util.CatalogXmlParser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBException;
import java.util.List;


/**
 * CRUD service class for {@link Catalog} class.
 *
 * @author Alexander Naumov
 */


public class BookService {

    @Autowired
    private CatalogXmlParser parser;

    /**
     * Returns all books {@link Book} from the main.xml.
     *
     * @return {@link Catalog} catalog of books.
     */

    public Catalog getBooks() throws JAXBException {
        return parser.getCatalogFromFile();
    }

    /**
     * Adds book {@link Book} if it not exist in main.xml.
     * Or update it by id, if book not exist in main.xml
     *
     * @param book that be added or updated in main.xml.
     */

    public void saveOrUpdate(Book book) throws JAXBException {
        Catalog mainCatalog = parser.getCatalogFromFile();
        List<Book> books = mainCatalog.getBooks();
        int index = 0;
        for (Book b : books) {
            if (book.getId().equals(b.getId())) {
                index = books.indexOf(b);
            }
        }
        if (index == 0) {
            mainCatalog.getBooks().add(book);
        } else {
            mainCatalog.getBooks().set(index, book);
        }
        parser.saveCatalogToFile(mainCatalog);
    }

    /**
     * Remove book {@link Book} from main.xml by id.
     *
     * @param book that be removed from the main.xml.
     */

    public void deleteBook(Book book) throws JAXBException {
        Catalog mainCatalog = parser.getCatalogFromFile();
        if (book.getId() != null && book.getAuthor() == null && book.getPrice() == null &&
                book.getGenre() == null && book.getTitle() == null && book.getPublishDate() == null &&
                book.getDescription() == null) {
            mainCatalog.getBooks().removeIf(book1 -> book1.getId().equals(book.getId()));
            parser.saveCatalogToFile(mainCatalog);
        }
    }
}
