/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.login.repository;

import com.service.login.model.User;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 *
 * @author Kim Askebris
 */
@Component
public class UserRepository {
    
     private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void users() {
       User user1 = new User();
       user1.setUsername("Per");
       user1.setPassword("Per");
       users.put(user1.getUsername(), user1);
       
       User user2 = new User();
       user2.setUsername("Kim");
       user2.setPassword("Kim");
       users.put(user2.getUsername(), user2);
       
       User user3 = new User();
       user3.setUsername("Simon");
       user3.setPassword("Simon");
       users.put(user3.getUsername(), user3);
       
       User user4 = new User();
       user4.setUsername("Johanna");
       user4.setPassword("Johanna");
       users.put(user4.getUsername(), user4);
       
       User user5 = new User();
       user5.setUsername("Anders");
       user5.setPassword("Anders");
       users.put(user5.getUsername(), user5);
       
    }
    
    public User findByName(String username) {
        if (users.get(username) != null) 
            return users.get(username);
        return null;
    }
    
    
}
