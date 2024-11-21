package com.example.webcrawler.service;

import java.net.URL;
import java.util.ArrayList;

public interface WebCrawlerService {

    //crawl from a starting URL
    ArrayList<URL> crawl(String urlString);

    //save URLs to DB
    void saveAll(ArrayList<URL> traversedUrls);

    void save(URL url);

    //delete all entities from DB
    int deleteAll();

    //Query URL by id

    //other queries (domain, scheme, etc.)
}
