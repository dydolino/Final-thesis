package pwr.thesis.thesis.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pwr.thesis.thesis.Model.User;
import pwr.thesis.thesis.Model.UserRole;
import pwr.thesis.thesis.Repository.UserRepository;
import pwr.thesis.thesis.Repository.UserRoleRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(String username, String password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(true);
        userRepository.save(user);

        UserRole userRole=new UserRole();
        userRole.setUsername(username);
        userRole.setRole("ROLE_USER");
        userRoleRepository.save(userRole);
    }
}
