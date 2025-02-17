package com.example.webcrawler.webcrawler;

import com.example.webcrawler.urlentity.UrlEntityDAO;
import com.example.webcrawler.urlentity.UrlEntity;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class WebCrawlerServiceImplTest {

    @Test
    public void save_shouldCallDaoSaveMethod() throws URISyntaxException, MalformedURLException {
        //arrange
        UrlEntityDAO theUrlEntityDAO = mock(UrlEntityDAO.class);
        WebCrawlerServiceImpl theWebCrawlerServiceImpl = new WebCrawlerServiceImpl(theUrlEntityDAO);
        URL theUrl = new URI("https://www.google.com").toURL();
        UrlEntity theUrlEntity = new UrlEntity(theUrl);

        //act
        theWebCrawlerServiceImpl.save(theUrl);

        //assert
        verify(theUrlEntityDAO, times(1)).save(any());
    }

    @Test
    public void saveAll_shouldCallDaoSaveMethodCorrectAmountOfTimes() throws URISyntaxException, MalformedURLException{
        //arrange
        UrlEntityDAO theUrlEntityDAO = mock(UrlEntityDAO.class);
        WebCrawlerService theWebCrawlerService = new WebCrawlerServiceImpl(theUrlEntityDAO);
        URL theUrl = new URI("https://www.google.com").toURL();
        ArrayList<URL> urls = new ArrayList<URL>(10);

        UrlEntity theUrlEntity = new UrlEntity(theUrl);

        for (int i = 0; i < 10; i++){
            urls.add(theUrl);
        }

        //act
        theWebCrawlerService.saveAll(urls);

        //assert
        verify(theUrlEntityDAO, times(10)).save(any());
    }

    @Test
    public void deleteAll_shouldReturnCorrectAmountOfDeletions() {
        //arrange
        UrlEntityDAO theUrlEntityDao = mock(UrlEntityDAO.class);
        WebCrawlerService theWebCrawlerService = new WebCrawlerServiceImpl(theUrlEntityDao);
        when(theUrlEntityDao.deleteAll()).thenReturn(1);

        //act
        int valuesDeleted = theWebCrawlerService.deleteAll();

        //assert
        assertEquals(1, valuesDeleted);
    }
}
