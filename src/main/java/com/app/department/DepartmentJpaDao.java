
package com.app.department;

import com.app.commons.dao.JpaDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class DepartmentJpaDao implements JpaDao<Department> {
    
    private final EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

    @Override
    public EntityManager entityManager() {
        return entityManager;
    }

    @Override
    public Department get(long id) {
        return entityManager.find(Department.class, id);
    }

    @Override
    public List<Department> getAll() {
        Query query = entityManager.createNamedQuery("Department.findAll");
        return query.getResultList();
    }

    @Override
    public void save(Department e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Department e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Department e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
