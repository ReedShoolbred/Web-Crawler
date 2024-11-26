package com.example.webcrawler.urlentity;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UrlEntityDAOImpl implements UrlEntityDAO {

    private EntityManager entityManager;

    //inject the Entity Manager
    @Autowired
    public UrlEntityDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    /**
     * Save a UrlEntity object to the database.
     * @param theUrlEntity - UrlEntity object to be saved
     */
    @Override
    @Transactional
    public void save(UrlEntity theUrlEntity) {
        entityManager.persist(theUrlEntity);
    }

    /**
     * Find UrlEntity object with primary key id
     * @param id - primary key of object
     * @return object w/ primary key id if found, otherwise null
     */
    @Override
    public UrlEntity findById(Integer id) {
        return entityManager.find(UrlEntity.class, id);
    }

    @Transactional
    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM UrlEntity").executeUpdate();
    }

    @Override
    public UrlEntity findByDomain() {
        //todo
        return null;
    }

    @Override
    public UrlEntity findByScheme() {
        //todo
        return null;
    }
}
