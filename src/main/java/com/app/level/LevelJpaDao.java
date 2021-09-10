
package com.app.level;

import com.app.commons.dao.JpaDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class LevelJpaDao implements JpaDao<Level> {
    
    private final EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

    @Override
    public EntityManager entityManager() {
        return entityManager;
    }

    @Override
    public Level get(long id) {
        return entityManager().find(Level.class, id);
    }

    @Override
    public List<Level> getAll() {
        Query query = entityManager().createNamedQuery("Level.findAll");
        return query.getResultList();
    }

    @Override
    public void save(Level l) {
        executeInsideTransaction(it -> it.persist(l));
    }

    @Override
    public void update(Level l) {
        executeInsideTransaction(it -> it.merge(l));
    }

    @Override
    public void delete(Level l) {
        executeInsideTransaction(it -> it.remove(l));
    }
    
}
