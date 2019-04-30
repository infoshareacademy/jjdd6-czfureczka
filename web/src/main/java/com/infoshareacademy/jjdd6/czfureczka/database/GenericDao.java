package com.infoshareacademy.jjdd6.czfureczka.database;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class GenericDao<K, T> {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(K k) {
        entityManager.persist(k);
    }

    public K update(K k) {
        return entityManager.merge(k);
    }

    public void delete(Class<K> c, T id) {
        final K k = entityManager.find(c, id);
        if (k != null) {
            entityManager.remove(k);
        }
    }

    public K findById(Class<K> c, T id) {
        return entityManager.find(c, id);
    }

    @SuppressWarnings("unchecked")
    public List<K> findAll(Class<K> c) {
        final Query query = entityManager.createQuery("SELECT t FROM " + c.getName() +" t");

        return query.getResultList();
    }
}