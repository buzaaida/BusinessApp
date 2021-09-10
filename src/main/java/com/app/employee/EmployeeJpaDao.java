
package com.app.employee;

import com.app.commons.dao.JpaDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class EmployeeJpaDao implements JpaDao<Employee> {
    
    private final EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

    @Override
    public EntityManager entityManager() {
        return entityManager;
    }

    @Override
    public Employee get(long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> getAll() {
        Query query = entityManager.createNamedQuery("Employee.findAll");
        return query.getResultList();
    }

    @Override
    public void save(Employee e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Employee e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Employee e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
