package com.example.lap10.Service;

import com.example.lap10.Model.User;
import com.example.lap10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List findAll() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id ,User user) {
        User oldUser = userRepository.findById(id).get();

        if (oldUser != null) {
            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());
            oldUser.setPassword(user.getPassword());
            oldUser.setRole(user.getRole());
            oldUser.setAge(user.getAge());
            userRepository.save(oldUser);
            return true ;
        }
        return false ;
    }

    public Boolean deleteUser(Integer id) {
        User oldUser = userRepository.findById(id).get();
        if (oldUser != null) {
            userRepository.delete(oldUser);
            return true ;
        }
        return false ;
    }



}
