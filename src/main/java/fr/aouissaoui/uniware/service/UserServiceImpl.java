package fr.aouissaoui.uniware.service;

import fr.aouissaoui.uniware.model.User;
import fr.aouissaoui.uniware.repository.springdatajpa.SpringDataUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Mostly used as a facade for all Users managements controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 * Created by nizaraouissaoui on 01/05/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private SpringDataUserRepository userRepository;

    @Autowired
    public UserServiceImpl(SpringDataUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(int id) throws DataAccessException {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "users")
    public Collection<User> findAllUsers() throws DataAccessException {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) throws DataAccessException {

        if (userRepository.findOneByLogin(user.getEmail()) == null) {
            userRepository.save(user);
        }

    }

    @Override
    @Transactional
    public void deleteUser(User user) throws DataAccessException {
        userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<User> findUserByLastName(String lastName) throws DataAccessException {
        return userRepository.findUserByLastName(lastName);
    }
}
