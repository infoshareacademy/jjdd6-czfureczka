package com.infoshareacademy.jjdd6.czfureczka.database;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, String> findPopular(Class<K> c){
        final Query query = entityManager.createQuery("select name, count (*) from " + c.getName() + " k group by name");
        List<Object[]> listObjects = query.getResultList();
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < listObjects.size(); i++) {
            result.put(listObjects.get(i)[0].toString(), listObjects.get(i)[1].toString());
        }
        return result;
    }

    public List<K> findByEmail(Class<K> c, String email){
        final Query query = entityManager.createQuery("select t from " + c.getName() + " t where email = " + "'" + email +"'");
        return query.getResultList();
    }
}