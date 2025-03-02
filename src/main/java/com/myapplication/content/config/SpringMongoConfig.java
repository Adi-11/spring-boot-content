package com.myapplication.content.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class SpringMongoConfig {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.data.mongodb.uri}")
    private String mongoUrl;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Bean
    public MongoClient mongoClient() {
        MongoClient mongoClient = MongoClients.create(mongoUrl);
        logger.info("Connected to MongoDB successfully.");
        return mongoClient;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), dbName);
    }
}
