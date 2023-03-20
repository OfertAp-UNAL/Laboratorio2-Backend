package co.edu.unal.software_engineering.labs.service;

import co.edu.unal.software_engineering.labs.model.Role;
import co.edu.unal.software_engineering.labs.model.User;
import co.edu.unal.software_engineering.labs.pojo.RolePOJO;
import co.edu.unal.software_engineering.labs.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class UserRolesService {

    private final UserRepository userRepository;

    public UserRolesService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<RolePOJO> findRolesByUsername(String username) {
        User user = userRepository.findByUsername(username);
        List<RolePOJO> roles = new ArrayList<>();

        for (Role role : user.getRoles()) {
            roles.add(new RolePOJO(role));
        }
        return roles;
    }
}