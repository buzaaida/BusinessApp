
package com.app.job;

import com.app.commons.dao.JpaDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class JobJpaDao implements JpaDao<Job>{

    private final EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

    @Override
    public EntityManager entityManager() {
        return entityManager;
    }

    @Override
    public Job get(long id) {
        return entityManager.find(Job.class, id);
    }

    @Override
    public List<Job> getAll() {
        Query query = entityManager.createNamedQuery("Job.findAll");
        return query.getResultList();
    }

    @Override
    public void save(Job e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Job e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Job e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
