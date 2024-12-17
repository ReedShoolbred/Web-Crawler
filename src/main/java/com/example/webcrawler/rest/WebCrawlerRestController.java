package com.example.webcrawler.rest;

import com.example.webcrawler.urlentity.UrlEntity;
import com.example.webcrawler.webcrawler.WebCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/url")
public class WebCrawlerRestController {

    @Autowired
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
        return webCrawlerService.deleteAll();
    }

    //query database and return all elements with the given domain
    @GetMapping("/querybydomain/{domain}")
    public List<UrlEntity> queryByDomain(@PathVariable String domain) {
        return webCrawlerService.queryUrlEntitiesByDomain(domain);
    }

    //query database and return all elements with the given scheme
    @GetMapping("/querybyscheme/{scheme}")
    public List<UrlEntity> queryByScheme(@PathVariable String scheme) {
        return webCrawlerService.queryUrlEntitiesByScheme(scheme);
    }


}
