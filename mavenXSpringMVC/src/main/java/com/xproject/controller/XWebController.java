package com.xproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class XWebController {

    @RequestMapping(value = "/a", method = GET)
    public String index() {

        return "index";
    }
}
