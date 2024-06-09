package com.del.tomeejsf.server;


import com.del.tomeejsf.db.City;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import java.util.List;

@Stateless(name = "CityManager")
@Transactional
public class CityManagerBean implements CityManager {

    @PersistenceContext(unitName = "tee", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public City add(String name) {
        City c = new City();
        c.setName(name);
        em.persist(c);
        return c;
    }

    @Override
    public List<City> getList() {
        List<City> list = em.createQuery("from City").getResultList();
        return list;
    }

    @Override
    public void delete(Long id) {
        City c = em.find(City.class, id);
        if (c != null) {
            em.remove(c);
        }
    }
}
