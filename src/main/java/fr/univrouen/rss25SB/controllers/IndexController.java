package fr.univrouen.rss25SB.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import fr.univrouen.rss25SB.model.Item;

@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "Hello rss25SB !";
    }

    @RequestMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody Item getXML() {
        return new Item("12345678", "Test item", "2022-05-01T11:22:33");
    }
}