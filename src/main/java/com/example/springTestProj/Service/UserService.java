/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springTestProj.Service;

import com.example.springTestProj.Entities.User;
import com.example.springTestProj.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ginge
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public String createUser(User user){
        try {
            if (!userRepository.existsByUserID(user.getUserID())){
                user.setUserID(user.getUserID());
                user.setUsername(user.getUsername());
                user.setPassword(user.getPassword());
                userRepository.save(user);
                return "User record created successfully.";
            }else {
                return "User ID taken";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<User> readUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public String deleteUser(User user){
        if (userRepository.existsByUserID(user.getUserID())){
            try {
               User userDelete = userRepository.findByUserID(user.getUserID());
               userRepository.delete(userDelete);
                return "Student record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Student does not exist";
        }
    }

}
