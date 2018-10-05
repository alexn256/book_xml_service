package com.solvegen.controllers;

import com.solvegen.models.Book;
import com.solvegen.services.BookService;
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

    @Autowired
    private BookService service;


    @RequestMapping(value = "/books", method = RequestMethod.GET, produces = "application/xml")
    public @ResponseBody Book changeBook(@RequestBody Book book) {

        return book;
    }

}
