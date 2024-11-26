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

public class WebCrawlerServiceImplTest {

    @Test
    public void save_shouldCallDaoSaveMethod() throws URISyntaxException, MalformedURLException {
        //arrange
        UrlEntityDAO theUrlEntityDAO = mock(UrlEntityDAO.class);
        WebCrawlerServiceImpl theWebCrawlerServiceImpl = new WebCrawlerServiceImpl(theUrlEntityDAO);
        URL theUrl = new URI("https://www.google.com").toURL();
        UrlEntity theUrlEntity = new UrlEntity(theUrl);

        //act
        theWebCrawlerServiceImpl.save(theUrlEntity);

        //assert
        verify(theUrlEntityDAO, times(1)).save(theUrlEntity);
    }

    @Test
    public void saveAll_shouldCallDaoSaveMethodCorrectAmountOfTimes() throws URISyntaxException, MalformedURLException{
        //arrange
        UrlEntityDAO theUrlEntityDAO = mock(UrlEntityDAO.class);
        WebCrawlerServiceImpl theWebCrawlerServiceImpl = new WebCrawlerServiceImpl(theUrlEntityDAO);
        URL theUrl = new URI("https://www.google.com").toURL();
        UrlEntity theUrlEntity = new UrlEntity(theUrl);
        ArrayList<UrlEntity> urlEntities = new ArrayList<UrlEntity>(10);
        for (int i = 0; i < 10; i++){
            urlEntities.add(theUrlEntity);
        }

        //act
        theWebCrawlerServiceImpl.saveAll(urlEntities);

        //assert
        verify(theUrlEntityDAO, times(10)).save(theUrlEntity);
    }
}
