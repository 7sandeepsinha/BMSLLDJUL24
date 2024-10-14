package dev.sandeep.BMSJUL24.service;

import dev.sandeep.BMSJUL24.exception.UserNotFoundException;
import dev.sandeep.BMSJUL24.model.User;
import dev.sandeep.BMSJUL24.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " not found")
        );
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}