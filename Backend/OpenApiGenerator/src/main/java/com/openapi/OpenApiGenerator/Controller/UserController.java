package com.openapi.OpenApiGenerator.Controller;

import com.openapi.OpenApiGenerator.Service.UserService;
import com.openapi.OpenApiGeneratorr.api.AddressbookApi;

import com.openapi.OpenApiGeneratorr.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements AddressbookApi {


    UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }

    @Override
    public ResponseEntity<User> getUser(Long id) {
        return userService.getUserById(id);
    }
    @Override
    public ResponseEntity<Void> createUser(User user) {
        return  userService.createUser(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
     return    userService.deleteUser(id);
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        return userService.getUsers();
    }

    @Override
    public ResponseEntity<Void> updateUser(Long id, User user) {
        return userService.updateUser(id,user);
    }
}
