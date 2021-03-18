package com.example.demo.servise;

import com.example.demo.entity.User;
import com.example.demo.payload.Result;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Result addUser(User user){
        boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(user.getPhoneNumber());
        if (existsByPhoneNumber){
            return new Result("Bunday Nomer Bazada Mavjud",false);
        }
        userRepository.save(user);
        return new Result("User Bazaga Saqlandi",true);
    }
}
