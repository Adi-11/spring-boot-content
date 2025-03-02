package com.myapplication.content.controller;

import com.myapplication.content.domain.User;
import com.myapplication.content.service.UserCommandService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
public class UserCommandController {
    @Autowired
    private UserCommandService userCommandService;

    @PostMapping("/")
    public String saveUser(@RequestBody User user) {
        userCommandService.saveUser(user);
        return "User saved successfully";
    }

    @PatchMapping("/")
    public String updateUser(
            @RequestParam("id") ObjectId id,
            @RequestBody User user
    ) {
        userCommandService.updateUser(user, id);
        return "User updated successfully";
    }


}
