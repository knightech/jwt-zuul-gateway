package knightech.example.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void saveUser(User user) {

        if(Optional.ofNullable(userRepository.findByEmail(user.getEmail())).isPresent()) {
            throw new UserAlreadyExistsException(user.getEmail());
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        Set<Role> roles = user.getRoles().stream()
                .map(role -> Optional.ofNullable(roleRepository.findByRole(role.getRole()))
                        .orElseThrow(()-> new RoleNotFoundException(role.getRole())))
                .collect(Collectors.toSet());

        user.setRoles(roles);
        userRepository.save(user);
    }

}
