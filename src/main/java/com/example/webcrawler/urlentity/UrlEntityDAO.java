package com.example.webcrawler.urlentity;

import java.util.List;

public interface UrlEntityDAO {

    void save(UrlEntity theUrlEntity);

    UrlEntity findById(Integer id);

    int deleteAll();

    List<UrlEntity> findByDomain(String domain);

    List<UrlEntity> findByScheme(String domain);

}
