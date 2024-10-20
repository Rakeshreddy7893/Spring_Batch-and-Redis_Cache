package com.recykal.Specifications.service;
import com.recykal.Specifications.entity.User;
import com.recykal.Specifications.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.recykal.Specifications.specification.UserSpecifications;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> searchUser(String name, String email, String role) {
        Specification<User> spec = Specification.where(null);

        if (name != null && !name.isEmpty()) {
            spec = spec.and(UserSpecifications.hasName(name));
        }
        if (email != null && !email.isEmpty()) {
            spec = spec.and(UserSpecifications.hasEmail(email));
        }
        if (role != null && !role.isEmpty()) {
            spec = spec.and(UserSpecifications.hasRole(role));
        }

        return userRepository.findAll(spec);
    }

    public User saveUser(User user) {
        User Saveduser=userRepository.save(user);
        return  Saveduser;
    }
}
