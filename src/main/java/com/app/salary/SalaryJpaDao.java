
package com.app.salary;

import com.app.commons.dao.JpaDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class SalaryJpaDao implements JpaDao<Salary> {

    private final EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

    @Override
    public EntityManager entityManager() {
        return entityManager;
    }

    @Override
    public Salary get(long id) {
        return entityManager.find(Salary.class, id);
    }

    @Override
    public List<Salary> getAll() {
        Query query = entityManager.createNamedQuery("Salary.findAll");
        return query.getResultList();
    }

    @Override
    public void save(Salary e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Salary e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Salary e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
