package com.abetterplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RestController
public class Controller {

    int add(int x, int y){
        return x+y;
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    String healthCheck() {
        return "ping";
    }
}
