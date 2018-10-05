package com.solvegen.util;

import com.solvegen.models.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Paths;

/**
 * @author Alexander Naumov
 */

public class CatalogXmlParser {

    private static File main = new File("main.xml");

    public Catalog getCatalogFromFile() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        Unmarshaller catalogUnmarshaller = context.createUnmarshaller();
        Catalog catalog = (Catalog) catalogUnmarshaller.unmarshal(main);
        return catalog;
    }

    public void saveCatalogToFile(Catalog catalog) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        Marshaller catalogMarshaller = context.createMarshaller();
        catalogMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        catalogMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        catalogMarshaller.marshal(catalog, main);
    }

}
