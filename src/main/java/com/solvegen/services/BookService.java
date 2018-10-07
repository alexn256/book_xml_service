package com.solvegen.services;

import com.solvegen.models.Book;
import com.solvegen.models.Catalog;
import com.solvegen.util.CatalogXmlParser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * CRUD service class for {@link Catalog} class.
 *
 * @author Alexander Naumov
 */


public class BookService {

    private static Logger log = Logger.getLogger(BookService.class);


    @Autowired
    private CatalogXmlParser parser;

    /**
     * Returns all books {@link Book} from the main.xml.
     *
     * @return {@link Catalog} catalog of books.
     */

    public Catalog getBooks() {
        return parser.getCatalogFromFile();
    }

    /**
     * Adds book {@link Book} if it not exist in main.xml.
     * Or update it by id, if book not exist in main.xml
     *
     * @param book that be added or updated in main.xml.
     */

    public void saveOrUpdate(Book book) {
        Catalog mainCatalog = parser.getCatalogFromFile();
        List<Book> books = mainCatalog.getBooks();
        boolean exist = false;
        int index = 0;
        for (Book b : books) {
            if (book.getId().equals(b.getId())) {
                index = books.indexOf(b);
                exist = true;
                log.info("catalog from main.xml file contains book \n\n" + b + "\n\n with same id like \n\n" + book + "\n\n");
            }
        }
        if (!exist) {
            mainCatalog.getBooks().add(book);
            log.info("save book with id = " + book.getId() + " in main.xml file.");
        } else {
            mainCatalog.getBooks().set(index, book);
            log.info("update book with id = " + book.getId() + " in main.xml file.");
        }
        parser.saveCatalogToFile(mainCatalog);
    }

    /**
     * Remove book {@link Book} from main.xml by id.
     *
     * @param book that be removed from the main.xml.
     */

    public void deleteBook(Book book) {
        Catalog mainCatalog = parser.getCatalogFromFile();
        mainCatalog.getBooks().removeIf( b -> b.getId().equals(book.getId()));
        parser.saveCatalogToFile(mainCatalog);
    }
}
