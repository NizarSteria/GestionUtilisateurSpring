package fr.aouissaoui.uniware.repository;

import fr.aouissaoui.uniware.model.User;
import fr.aouissaoui.uniware.model.BaseEntity;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Repository class for <code>User</code> domain objects All method names are compliant with Spring Data naming
 * Created by nizaraouissaoui on 01/05/2017.
 */
public interface UserRepository {

    /**
     * Retrieve <code>User</code>s from the data store by last name, returning all users whose last name <i>starts</i>
     * with the given name.
     *
     * @param lastName Value to search for
     * @return a <code>Collection</code> of matching <code>User</code>s (or an empty <code>Collection</code> if none
     * found)
     */
    Collection<User> findByLastName(String lastName) throws DataAccessException;

    /**
     * Retrieve an <code>User</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>User</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    User findById(int id) throws DataAccessException;


    /**
     * Save an <code>User</code> to the data store, either inserting or updating it.
     *
     * @param user the <code>User</code> to save
     * @see BaseEntity#isNew
     */
    void save(User user) throws DataAccessException;

    /**
     * Retrieve <code>User</code>s from the data store, returning all users
     *
     * @return a <code>Collection</code> of <code>User</code>s (or an empty <code>Collection</code> if none
     * found)
     */
    Collection<User> findAll() throws DataAccessException;

    /**
     * Delete an <code>User</code> to the data store by <code>User</code>.
     *
     * @param user the <code>User</code> to delete
     */
    void delete(User user) throws DataAccessException;
}
