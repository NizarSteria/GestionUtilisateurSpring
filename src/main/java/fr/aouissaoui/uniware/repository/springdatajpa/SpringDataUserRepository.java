package fr.aouissaoui.uniware.repository.springdatajpa;

import fr.aouissaoui.uniware.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


/**
 * Spring Data JPA repository for the User entity.
 * Created by nizaraouissaoui on 01/05/2017.
 */
@Profile("spring-data-jpa")
public interface SpringDataUserRepository extends JpaRepository<User, Integer> {

    List<User> findUserByLastName(String lastName);

    User findOneByEmail(String email);

    Optional<User> findOneByLogin(String login);

    User findById(int id);
}
