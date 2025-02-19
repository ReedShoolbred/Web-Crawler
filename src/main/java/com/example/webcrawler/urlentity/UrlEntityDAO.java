package com.example.webcrawler.urlentity;

import java.util.List;

public interface UrlEntityDAO {

    void save(UrlEntity theUrlEntity);

    UrlEntity findById(Integer id);

    int deleteAll();

    boolean delete(int id);

    List<UrlEntity> findByDomain(String domain);

    List<UrlEntity> findByScheme(String domain);

    List<UrlEntity> queryAll();

}
