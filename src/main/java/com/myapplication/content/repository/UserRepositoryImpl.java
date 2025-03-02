package com.myapplication.content.repository;


import com.myapplication.content.domain.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements  UserRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(User user) {
        mongoTemplate.save(user);
//        mongoTemplate.insert(user);
    }

    @Override
    public User findOne(ObjectId id) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query();
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, User.class);
    }
}
