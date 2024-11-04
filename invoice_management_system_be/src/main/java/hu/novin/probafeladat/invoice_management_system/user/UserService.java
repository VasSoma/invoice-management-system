package hu.novin.probafeladat.invoice_management_system.user;

import hu.novin.probafeladat.invoice_management_system.exceptions.UserNotFoundException;
import hu.novin.probafeladat.invoice_management_system.exceptions.UsernameAlreadyTakenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            return userRepository.getUserByUsername(username);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public User getUser(Long id) {
        return userRepository.getUser(id);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void removeUserById(Long id) {
        userRepository.removeUserById(id);
    }

    public User createUser(User user) {

        if (getUserByUsername(user.getUsername()) != null) {
            throw new UsernameAlreadyTakenException("Username already taken.");
        } else {
            String encryptedPass = encoder.encode(user.getPassword());
            user.setPassword(encryptedPass);
            return userRepository.createUser(user);
        }
    }

    private User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
