package fr.aouissaoui.uniware;

import fr.aouissaoui.uniware.model.User;
import fr.aouissaoui.uniware.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringGestionUsersApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringGestionUsersApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        userService.saveUser(new User("login", "password", "Nizar", "Aouissaoui", "aouissaoui.nizar@gmail.com", "0603822458"));
        userService.saveUser(new User("login", "password", "Haroun", "Aouissaoui", "aouissaoui.haroun@gmail.com","0603822458"));
        userService.saveUser(new User("login", "password", "Isra", "Aouissaoui", "aouissaoui.isra@gmail.com","0603822458"));
    }
}
