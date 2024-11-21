package com.example.webcrawler.dao;

import com.example.webcrawler.entity.UrlEntity;

public interface UrlEntityDAO {

    void save(UrlEntity theUrlEntity);

    UrlEntity findById(Integer id);

    int deleteAll();

}
