package com.example.webcrawler.service;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WebCrawlerTest {

    @Test
    public void findSubURLsTestHTTPS() throws URISyntaxException, MalformedURLException {
        //https test
        String str = "https://www.google.com\"";
        ArrayList<URL> URLList = new ArrayList<>();
        WebCrawler.findSubURLs(str, URLList);
        if (URLList.isEmpty()) URLList.add(null);
        assertEquals(new URI("https://www.google.com").toURL(), URLList.getFirst());
    }


    @Test
    public void findSubURLsTestHTTP() throws URISyntaxException, MalformedURLException {
        //http test
        String str = "http://www.google.com\"";
        ArrayList<URL> URLList = new ArrayList<>();
        WebCrawler.findSubURLs(str, URLList);
        if (URLList.isEmpty()) URLList.add(null);
        assertEquals(new URI("http://www.google.com").toURL(), URLList.getFirst());
    }

    @Test
    public void findSubURLsTestNoURL() {
        //No url in String
        String str = " test=";
        ArrayList<URL> URLList = new ArrayList<>();
        WebCrawler.findSubURLs(str, URLList);
        if (URLList.isEmpty()) URLList.add(null);
        assertNull(URLList.getFirst());
    }

    @Test
    public void findSubURLsTestEmptyString() {
        //empty string
        String str = "";
        ArrayList<URL> URLList = new ArrayList<>();
        WebCrawler.findSubURLs(str, URLList);
        assertTrue(URLList.isEmpty());
    }

    @Test
    public void crawlTestInternalLinks(){
        ArrayList<URL> traversedURLs = WebCrawler.crawl("https://crawler-test.com/links/repeated_internal_links");
        System.out.println(traversedURLs);
        assertEquals(50, traversedURLs.size());
    }
}

