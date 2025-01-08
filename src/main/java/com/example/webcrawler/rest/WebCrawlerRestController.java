package com.example.webcrawler.rest;

import com.example.webcrawler.urlentity.UrlEntity;
import com.example.webcrawler.webcrawler.WebCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5500/")
@RequestMapping("/api")
public class WebCrawlerRestController {

    @Autowired
    WebCrawlerService webCrawlerService;

    //save a single URLEntitty
    @PostMapping("/crawl")
    public ArrayList<URL> crawl(@RequestBody String url) {
        return webCrawlerService.crawl(url);
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
