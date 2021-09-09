
package com.app.user;

import com.app.commons.dao.JpaDao;
import com.app.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;


public class UserJpaDao implements JpaDao<User> {
    
    private final EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

    @Override
    public EntityManager entityManager() {
        return entityManager;
    }

    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        Query query = entityManager.createNamedQuery("User.findAll");
        return query.getResultList();
    }

    @Override
    public void save(User u) {
        executeInsideTransaction(it -> it.persist(u));
    }

    @Override
    public void update(User u) {
        executeInsideTransaction(it -> it.merge(u));
    }

    @Override
    public void delete(User u) {
        executeInsideTransaction(it -> it.remove(it.contains(u)?u:it.merge(u)));
    }
    
    public User login(String username, String password) {
        
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return null;
        }
        Query query = entityManager.createNamedQuery("User.findByUsernameAndPassword");
        query.setParameter("username", username);
        query.setParameter("password", password);
        
        try {
            User user = (User) query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            System.err.format("User '%s' does not exist.%n", username);
            return null;
        } catch (NonUniqueResultException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public User findByUsername(String username) {
        
        if (username == null || username.isEmpty()) {
            return null;
        }
        Query query = entityManager.createNamedQuery("User.findByUsername");
        query.setParameter("username", username);
        
        try {
            User user = (User) query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            System.err.format("User '%s' does not exist.%n", username);
            return null;
        } catch (NonUniqueResultException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
}
