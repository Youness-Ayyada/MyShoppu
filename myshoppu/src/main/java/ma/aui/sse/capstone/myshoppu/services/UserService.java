package ma.aui.sse.capstone.myshoppu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.aui.sse.capstone.myshoppu.data.entities.User;
import ma.aui.sse.capstone.myshoppu.data.entities.UserType;
import ma.aui.sse.capstone.myshoppu.data.repositeries.UserRepository;
import ma.aui.sse.capstone.myshoppu.data.repositeries.UserTypeRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTypeRepository userTypeRepository;

    public boolean createSuperAdmin(String username, String password, String firstName, String lastName,
            String emailAddress, String address) {

        if (!userTypeRepository.findByUserType("ROLE_SUPERADMIN").isEmpty())
            return false;

        String[] authorities = { "ROLE_SUPERADMIN" };
        create(username, password, firstName, lastName, emailAddress, address, authorities);
        return true;
    }

    public void createAdmin(String username, String password, String firstName, String lastName, String emailAddress,
            String address) {

        String[] authorities = { "ROLE_ADMIN", "ROLE_USER" };
        create(username, password, firstName, lastName, emailAddress, address, authorities);
    }

    public void createUser(String username, String password, String firstName, String lastName, String emailAddress,
            String address) {

        String[] authorities = { "ROLE_USER" };
        create(username, password, firstName, lastName, emailAddress, address, authorities);
    }

    private void create(String username, String password, String firstName, String lastName, String emailAddress,
            String address, String[] authorities) {

        User user = new User(username, password, firstName, lastName, emailAddress, address);
        userRepository.save(user);
        for (String auth : authorities) {
            UserType userType = new UserType(username, auth);
            userTypeRepository.save(userType);
        }
    }

    public void update(long userId, String password, String newPassword, String firstName, String lastName,
            String emailAddress, String address) {
        User user = userRepository.findById(userId).get();
        if (password != null && (newPassword == null
                || !(new BCryptPasswordEncoder().encode(password).equals(user.getPassword())))) {
            return;
        }

        if (newPassword != null)
            user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        if (firstName != null)
            user.setFirstName(firstName);
        if (lastName != null)
            user.setLastName(lastName);
        if (emailAddress != null)
            user.setEmailAddress(emailAddress);
        if (address != null)
            user.setAddress(address);

        userRepository.save(user);
    }
}