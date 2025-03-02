package com.myapplication.content.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("users")
public class User {
    @Id
    @Field("_id")
    private ObjectId id; // Unique identifier for the user

    @Field("firstName")
    private String firstName; // User's first name

    @Field("lastName")
    private String lastName;  // User's last name

    @Field("email")
    private String email;     // User's email for contact

    @Field("username")
    private String username;  // Unique username for login

    @Field("password")
    private String password;  // Hashed password for security

    @Field("active")
    private boolean active;   // Is the user active

    @Field("role")
    private String role;      // Role (e.g., ADMIN, USER)

    @Field("userId")
    private Long userId;


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
