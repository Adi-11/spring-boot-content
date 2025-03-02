package com.myapplication.content.repository;

import com.myapplication.content.domain.User;
import org.bson.types.ObjectId;

public interface UserRepository {
    public void save(User user);

    public User findOne(ObjectId id);
}
