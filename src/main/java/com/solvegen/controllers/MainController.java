package com.solvegen.controllers;

import com.solvegen.models.Book;
import com.solvegen.models.Catalog;
import com.solvegen.services.BookService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Main controller class.
 *
 * @author Alexander Naumov
 */


@Controller
public class MainController {

    private static Logger log = Logger.getLogger(MainController.class);

    @Autowired
    private BookService service;

    /**
     * Returns XML Request that results from the book service {@link BookService} work.
     * If server gets empty XML Request, than it simple return all books from main.xml file.
     * Another if server gets empty book only with id, it delete its from main.xml file,
     * if that book contains in main.xml file.  If server gets not empty book, it adds or
     * updates its depends if main.xml contains book with same id or not.
     *
     * @param catalog XML Request that, from client that represents catalog {@link Catalog}
     *                with single book {@link Book}.
     * @return XML response that represents catalog of books from main.xml file.
     */

    @RequestMapping(value = "/books", produces = "application/xml", consumes = "application/xml", method = RequestMethod.POST)
    public @ResponseBody
    Catalog changeBook(@RequestBody(required = false) Catalog catalog) {
        if (catalog == null) {
            log.info("an empty request came to the server");
            return service.getBooks();
        }
        catalog.getBooks().forEach(book -> {
            if (book.isEmpty()) {
                log.info("a request come to the server for deleting a book.");
                service.deleteBook(book);
            } else {
                log.info("a request come to the server for saving or updating a book.");
                service.saveOrUpdate(book);
            }
        });
        return service.getBooks();
    }
}
