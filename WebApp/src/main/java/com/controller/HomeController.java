package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Index() {
        return "index"; // view resolver responsible to check the page inside folder.
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String About() {
        return "about";
    }
}
