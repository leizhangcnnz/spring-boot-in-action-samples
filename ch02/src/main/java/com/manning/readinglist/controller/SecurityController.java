package com.manning.readinglist.controller;

import com.manning.readinglist.entity.Reader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/security")
public class SecurityController {
    @RequestMapping(method = RequestMethod.POST)
    public String security(Reader reader) {
        return "redirect:/readingList/" + reader.getUsername();
    }
}
