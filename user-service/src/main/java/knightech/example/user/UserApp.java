package knightech.example.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class UserApp {

    public static void main(String[] args) {

        SpringApplication.run(UserApp.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner (UserService userService, RoleRepository roleRepository) {

        return args -> {

            Role adminRole = Optional.ofNullable(roleRepository.findByRole("ADMIN")).orElseGet(() -> {
                Role newAdminRole = new Role();
                newAdminRole.setRole("ADMIN");
                roleRepository.save(newAdminRole);
                return newAdminRole;
            });

            Role userRole = Optional.ofNullable(roleRepository.findByRole("USER")).orElseGet(() -> {
                Role newUserRole = new Role();
                newUserRole.setRole("USER");
                roleRepository.save(newUserRole);
                return newUserRole;
            });

            User admin = new User();
            admin.setEmail("admin@knightech.net");
            admin.setFullname("Administrator");
            admin.setPassword("password");
            admin.setRoles(Stream.of(userRole, adminRole).collect(Collectors.toSet()));

            userService.saveUser(admin);
        };

    }
}
