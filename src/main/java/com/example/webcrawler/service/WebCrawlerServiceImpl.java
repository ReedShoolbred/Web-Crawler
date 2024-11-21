package com.example.webcrawler.service;

import com.example.webcrawler.dao.UrlEntityDAO;
import com.example.webcrawler.entity.UrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

@Service
public class WebCrawlerServiceImpl implements WebCrawlerService{
    private UrlEntityDAO urlEntityDAO;

    @Autowired
    public WebCrawlerServiceImpl(UrlEntityDAO theUrlEntityDAO){
        urlEntityDAO = theUrlEntityDAO;
    }


    /**
     * Delegates crawl() to WebCrawler class
     * @param urlString - String object representing a URL
     * @return ArrayList<URL> of all URL objects that WebCrawler returns
     */
    @Override
    public ArrayList<URL> crawl(String urlString) {
         return WebCrawler.crawl(urlString);
    }

    /**
     * Saves all URL object in traversedUrls to the database
     * @param traversedUrls - ArrayList of URL objects
     */
    @Override
    public void saveAll(ArrayList<URL> traversedUrls) {
        for (URL tempUrl: traversedUrls){
           save(tempUrl);
        }
    }

    /**
     * Save url to database by delegating to urlEntityDAO
     * @param url - URL object to be saved
     */
    @Override
    public void save(URL url) {
        urlEntityDAO.save(new UrlEntity(url));
    }

    @Override
    public int deleteAll() {
        return urlEntityDAO.deleteAll();
    }

}
