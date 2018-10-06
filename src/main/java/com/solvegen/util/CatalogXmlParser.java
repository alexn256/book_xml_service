package com.solvegen.util;

import com.solvegen.models.Catalog;
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

    @Autowired
    private WebApplicationContext applicationContext;

    /**
     * Returns catalog of books from main.xml file.
     *
     * @return {@link Catalog} catalog of books.
     * @throws JAXBException
     */

    public Catalog getCatalogFromFile() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        Unmarshaller catalogUnmarshaller = context.createUnmarshaller();
        return (Catalog) catalogUnmarshaller.unmarshal(new File(applicationContext.getServletContext().getRealPath(PATH)));
    }

    /**
     * Write {@link Catalog} catalog of books in main.xml file.
     *
     * @param catalog that will be written to main.xml file.
     * @throws JAXBException
     */

    public void saveCatalogToFile(Catalog catalog) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        Marshaller catalogMarshaller = context.createMarshaller();
        catalogMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        catalogMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        catalogMarshaller.marshal(catalog, new File(applicationContext.getServletContext().getRealPath(PATH)));
    }
}
