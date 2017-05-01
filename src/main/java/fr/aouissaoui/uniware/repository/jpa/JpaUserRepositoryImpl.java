package fr.aouissaoui.uniware.repository.jpa;

import fr.aouissaoui.uniware.model.User;
import fr.aouissaoui.uniware.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

/**
 * JPA implementation of the {@link UserRepository} interface.
 * <p>
 * Created by nizaraouissaoui on 01/05/2017.
 */
@Repository
@Profile("jpa")
public class JpaUserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<User> findByLastName(String lastName) throws DataAccessException {
        Query query = this.em.createQuery("SELECT user FROM User user WHERE user.lastName LIKE :lastName");
        query.setParameter("lastName", lastName + "%");
        return query.getResultList();
    }

    @Override
    public User findById(int id) throws DataAccessException {
        Query query = this.em.createQuery("SELECT user FROM User user WHERE user.id =:id");
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }

    @Override
    public void save(User user) throws DataAccessException {
        if (user.getId() == null) {
            this.em.persist(user);
        } else {
            this.em.merge(user);
        }
    }

    @Override
    public Collection<User> findAll() throws DataAccessException {
        Query query = this.em.createQuery("SELECT user FROM User user");
        return query.getResultList();
    }

    @Override
    public void delete(User user) throws DataAccessException {
        this.em.remove(this.em.contains(user) ? user : this.em.merge(user));

    }
}
