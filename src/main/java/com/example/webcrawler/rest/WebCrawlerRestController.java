package com.example.webcrawler.rest;

import com.example.webcrawler.urlentity.UrlEntity;
import com.example.webcrawler.webcrawler.WebCrawlerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/url")
public class WebCrawlerRestController {

    WebCrawlerService webCrawlerService;

    //save a single URLEntitty
    @PostMapping("/save")
    public void save() {

    }

    //save a collection of URLEntity objects
    @PostMapping("/saveall")
    public void saveAll() {

    }

    //delete all elements from database and return number of items deleted
    @GetMapping("/deleteall")
    public int deleteAll() {
        return 0;
    }

    //query database and return all elements with the given domain
    @GetMapping("/querybydomain/{domain}")
    public ArrayList<UrlEntity> queryByDomain(@PathVariable String domain) {
        return null;
    }

    //query database and return all elements with the given scheme
    @GetMapping("/querybydomain/{scheme}")
    public ArrayList<UrlEntity> queryByScheme(@PathVariable String scheme) {
        return null;
    }


}
