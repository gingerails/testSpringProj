/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springTestProj.Service;

import com.example.springTestProj.Entities.User;
import com.example.springTestProj.Repository.UserRepository;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ginge
 */
@Service
@Scope("prototype")
public class UserService {

    @Autowired
    public UserRepository userRepository;

//    @Transactional
//    public String createUser(User user){
//        try {
//            if (!userRepository.existsByUserID(user.getUserID())){
//                user.setUserID(user.getUserID());
//                user.setUsername(user.getUsername());
//                user.setPassword(user.getPassword());
//                userRepository.save(user);
//                return "User record created successfully.";
//            }else {
//                return "User ID taken";
//            }
//        }catch (Exception e){
//            throw e;
//        }
//    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public User createUser(String username, String password){
        String userID = String.valueOf(UUID.randomUUID());
        User newUser = new User(userID, username, password);

        return newUser;
    }

    /**
     *
     * @param user
     */
    public void saveUserToRepository(User user){
        userRepository.save(user);
        System.out.println("User saved?");

    }

    /**
     *
     * @return
     */
    public List<User> readUsers(){
        return userRepository.findAll();
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public User returnUser(String username, String password){
        return userRepository.findUsersByUsernameAndPassword(username, password);
    }

    /**
     *
     * @param username
     * @return
     */
    public User returnUserByUsername(String username){
        return userRepository.findUsersByUsername(username);
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
