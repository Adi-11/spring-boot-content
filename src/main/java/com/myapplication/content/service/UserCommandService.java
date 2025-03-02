package com.myapplication.content.service;

import com.myapplication.content.domain.User;
import com.myapplication.content.repository.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommandService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user, ObjectId id) {
        User user1 = userRepository.findOne(id);
        if (user1 != null) {
            user1.setUsername(user.getUsername());
        }
        logger.info("user => {}", user1);
        userRepository.save(user1);
    }
}
