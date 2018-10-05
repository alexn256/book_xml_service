package com.solvegen.controllers;

import com.solvegen.models.Catalog;
import com.solvegen.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;


/**
 * Main controller class.
 *
 * @author Alexander Naumov
 */


@Controller
public class MainController {

    @Autowired
    private BookService service;

    @RequestMapping(value = "/books", produces = "application/xml", consumes = "application/xml", method = RequestMethod.POST)
    public @ResponseBody Catalog changeBook(@RequestBody Catalog catalog) throws JAXBException {

        // todo

        return catalog;
    }

}
