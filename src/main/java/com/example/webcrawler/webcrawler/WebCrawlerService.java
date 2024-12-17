package com.example.webcrawler.webcrawler;

import com.example.webcrawler.urlentity.UrlEntity;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * WebCrawlerService provides access to web crawling functionality and to database functionality for
 * any sites found through web crawling.
 */
public interface WebCrawlerService {

    /**
     * Initiate a web crawling attempt from the URL represented by urlString.
     * @param urlString - String representation of a URL from which the webcrawler will begin crawling
     * @return an ArrayList of all URL objects found by web crawling
     */
    ArrayList<URL> crawl(String urlString);

    /**
     * Save the given UrlEntity to a database or other data persistence module.
     * @param urlEntity - UrlEntity object to be saved
     */
    void save(UrlEntity urlEntity);

    /**
     * Save all UrlEntities in the given ArrayList to a database or other data storage implementation.
     * @param traversedUrlEntities - ArrayList of UrlEntity objects to be saved
     */
    void saveAll(ArrayList<UrlEntity> traversedUrlEntities);


    /**
     * Remove all elements from the database/other data storage implementation.
     * @return the number of elements deleted
     */
    int deleteAll();

    /**
     * Query the database/other data storage implementation and return all elements that contain the domain parameter
     * as an exact match or a substring of their domain.
     * For example: The URL "https://www.example.com" would be returned for an input domain of "example.com", but
     * also for an input domain of "x"
     * @param domain - String to compare against the domain attribute of each database element.
     * @return an ArrayList of all elements that contain the domain parameter as an exact match or a substring of their domain attribute.
     */
    List<UrlEntity> queryUrlEntitiesByDomain(String domain);

    /**
     * Query the database/other data storage implementation and return all elements that
     * contain the scheme parameter as an exact match or a substring of their scheme.
     * @param scheme - String to compare against the scheme attribute of each database element.
     * @return an ArrayList of all elements that contain the scheme parameter as an exact match or a substring of their scheme attribute.
     */
    List<UrlEntity> queryUrlEntitiesByScheme(String scheme);
}
