package com.dogadjaji.dogadjaji_188.services;

import com.dogadjaji.dogadjaji_188.models.User;
import com.dogadjaji.dogadjaji_188.repositories.UserRepository;
import com.dogadjaji.dogadjaji_188.requests.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void registerUser(UserRequest userRequest){
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setAge(userRequest.getAge());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());

        userRepository.save(user);
    }
}
