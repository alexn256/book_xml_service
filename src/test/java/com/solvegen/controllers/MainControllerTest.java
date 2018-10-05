package com.solvegen.controllers;

import com.solvegen.config.ApplicationConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * Test class for {@link MainController} main controller.
 *
 * @author Alexander Naumov
 */


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class MainControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void changeBookTest () throws Exception {

        // todo

    }


    private String xmlRequestBookExample() {
        return  "<?xml version=\"1.0\"?" +
                "<catalog>" +
                "<book id=\"bk101\">" +
                "<author>" + "Corets, Eva" + "</author>" +
                "<title>" + "Maeve Ascendant" + "</title>" +
                "<genre>" + "Fantasy" + "</genre>" +
                "<price>" + "5.95" + "</price>" +
                "<publish_date>" + "2000-11-17" + "</publish_date>" +
                "<description>" + "..." + "</description>" +
                "</book>" +
                "</catalog>";
    }

    private String xmlRequestEmptyBookExample() {
        return  "<?xml version=\"1.0\"?" +
                "<catalog>" +
                "<book id=\"bk101\">" +
                "</book>" +
                "</catalog>";
    }

}