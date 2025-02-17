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
import java.util.List;

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
    public int saveAll(ArrayList<URL> traversedUrls) {
        for (URL tempUrl: traversedUrls){
           save(tempUrl);
        }

        return traversedUrls.size();
    }

    /**
     * Save url to database by delegating to urlEntityDAO
     * @param url - UrlEntity object to be saved
     */
    @Override
    public boolean save(URL url) {
        urlEntityDAO.save(new UrlEntity(url));

        return true;
    }

    @Override
    public int deleteAll() {
        return urlEntityDAO.deleteAll();
    }

    @Override
    public boolean delete(String id) {
        int parsedId = Integer.parseInt(id);
        return urlEntityDAO.delete(parsedId);
    }

    @Override
    public List<UrlEntity> queryUrlEntitiesByDomain(String domain) {
        return urlEntityDAO.findByDomain(domain);
    }

    @Override
    public List<UrlEntity> queryUrlEntitiesByScheme(String scheme) {
        return urlEntityDAO.findByScheme(scheme);
    }

    @Override
    public List<UrlEntity> queryAll() {
        return urlEntityDAO.queryAll();
    }

}
