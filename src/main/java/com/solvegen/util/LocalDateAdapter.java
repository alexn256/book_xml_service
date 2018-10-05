package com.solvegen.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * Adapter class for serializing {@link LocalDate} to XML.
 *
 * @author Alexander Naumov
 */


public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {


    /**
     * Deserialize xml object to LocalDate object.
     *
     * @param v string of xml, that need deserialized to {@link LocalDate}
     * @return {@link LocalDate} object.
     */

    public LocalDate unmarshal(String v) {
        return LocalDate.parse(v);
    }

    /**
     * Serialize LocalDate object to xml.
     *
     * @param v {@link LocalDate} object, that need serialize to xml.
     * @return {@link LocalDate} object
     */

    public String marshal(LocalDate v) {
        return v.toString();
    }
}
