package ma.aui.sse.capstone.myshoppu.security;

// import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import ma.aui.sse.capstone.myshoppu.data.entities.User;
import ma.aui.sse.capstone.myshoppu.data.repositeries.UserRepository;



public class UserAuditor implements AuditorAware<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            System.out.println("Null authentication");
            return null;
        }

        String username = (String)authentication.getPrincipal();
        System.out.println("username: " + username);
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
}