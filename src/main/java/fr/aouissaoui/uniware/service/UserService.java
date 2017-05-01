package fr.aouissaoui.uniware.service;

import fr.aouissaoui.uniware.model.User;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 * Created by nizaraouissaoui on 01/05/2017.
 */
public interface UserService {

    User findUserById(int id) throws DataAccessException;

    Collection<User> findAllUsers() throws DataAccessException;

    void saveUser(User user) throws DataAccessException;

    void deleteUser(User user) throws DataAccessException;

    Collection<User> findUserByLastName(String lastName) throws DataAccessException;
}
