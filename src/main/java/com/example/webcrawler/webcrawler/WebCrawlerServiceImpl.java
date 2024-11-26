package com.example.webcrawler.webcrawler;

import com.example.webcrawler.urlentity.UrlEntityDAO;
import com.example.webcrawler.urlentity.UrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @param traversedUrlEntities - ArrayList of URL objects
     */
    @Override
    public void saveAll(ArrayList<UrlEntity> traversedUrlEntities) {
        for (UrlEntity tempUrl: traversedUrlEntities){
           save(tempUrl);
        }
    }

    /**
     * Save url to database by delegating to urlEntityDAO
     * @param urlEntity - UrlEntity object to be saved
     */
    @Override
    public void save(UrlEntity urlEntity) {
        urlEntityDAO.save(urlEntity);
    }

    @Override
    public int deleteAll() {
        return urlEntityDAO.deleteAll();
    }

    @Override
    public ArrayList<UrlEntity> queryUrlEntitiesByDomain(String domain) {
        return null;
    }

    @Override
    public ArrayList<UrlEntity> queryUrlEntitiesByScheme(String scheme) {
        return null;
    }

}
