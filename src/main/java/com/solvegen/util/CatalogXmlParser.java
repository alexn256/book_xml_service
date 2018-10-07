package com.solvegen.util;

import com.solvegen.models.Catalog;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


/**
 * Helper class, for read/write main.xml file.
 *
 * @author Alexander Naumov
 */


public class CatalogXmlParser {

    private static final String PATH = "/WEB-INF/xml/main.xml";

    private static Logger log = Logger.getLogger(CatalogXmlParser.class);

    @Autowired
    private WebApplicationContext applicationContext;

    /**
     * Returns catalog of books from main.xml file.
     *
     * @return {@link Catalog} catalog of books.
     */

    public Catalog getCatalogFromFile() {
        Catalog catalog = null;
        try{
            JAXBContext context = JAXBContext.newInstance(Catalog.class);
            Unmarshaller catalogUnmarshaller = context.createUnmarshaller();
            catalog = (Catalog) catalogUnmarshaller.unmarshal(new File(applicationContext.getServletContext().getRealPath(PATH)));
            log.info("books catalog successfully loaded from main.xml file.");
        } catch (JAXBException e) {
            log.error("an error occurred while reading the book catalog from the main.xml file!");
        }
        return catalog;
    }

    /**
     * Write {@link Catalog} catalog of books in main.xml file.
     *
     * @param catalog that will be written to main.xml file.
     */

    public void saveCatalogToFile(Catalog catalog) {
        try{
            JAXBContext context = JAXBContext.newInstance(Catalog.class);
            Marshaller catalogMarshaller = context.createMarshaller();
            catalogMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            catalogMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            catalogMarshaller.marshal(catalog, new File(applicationContext.getServletContext().getRealPath(PATH)));
            log.info("book catalog successfully written to main.xml file.");
        } catch (JAXBException e) {
            log.error("an error occurred while writing the book catalog to the file.xml file.");
        }
    }
}
