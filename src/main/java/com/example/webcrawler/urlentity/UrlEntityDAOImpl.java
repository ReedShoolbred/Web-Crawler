package com.example.webcrawler.urlentity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

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
    public List<UrlEntity> findByDomain(String domain) {
        TypedQuery<UrlEntity> query = entityManager.createQuery("FROM UrlEntity WHERE domain=:theDomain", UrlEntity.class);

        query.setParameter("theDomain", domain);

        return query.getResultList();
    }

    @Override
    public List<UrlEntity> findByScheme(String scheme) {
        TypedQuery<UrlEntity> query = entityManager.createQuery("FROM UrlEntity WHERE scheme=:theScheme", UrlEntity.class);

        query.setParameter("theScheme", scheme);

        return query.getResultList();
    }
}
