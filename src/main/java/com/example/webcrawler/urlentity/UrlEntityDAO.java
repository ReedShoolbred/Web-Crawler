package com.example.webcrawler.urlentity;

public interface UrlEntityDAO {

    void save(UrlEntity theUrlEntity);

    UrlEntity findById(Integer id);

    int deleteAll();

    UrlEntity findByDomain(String domain);

    UrlEntity findByScheme(String domain);

}
