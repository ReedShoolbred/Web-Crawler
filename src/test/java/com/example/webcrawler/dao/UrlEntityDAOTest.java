package com.example.webcrawler.dao;

import com.example.webcrawler.urlentity.UrlEntity;
import com.example.webcrawler.urlentity.UrlEntityDAO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;



@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UrlEntityDAOTest {

    @Autowired
    UrlEntityDAO urlEntityDao;

    @Autowired
    EntityManager entityManager;


    //this don't work :)
    @Test
    public void saveSingleUrlEntity() throws URISyntaxException, MalformedURLException {
        //Arrange
        URL url = new URI("https://www.google.com").toURL();
        UrlEntity urlEntity = new UrlEntity(url);

        //Act
        urlEntityDao.save(urlEntity);

        //Assert
        int urlEntitiesFound = entityManager.createQuery("SELECT * FROM urlEntity", UrlEntity.class).executeUpdate();
        assertEquals(1, urlEntitiesFound);
    }
}
