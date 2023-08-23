package com.openapi.OpenApiGenerator.Controller;

import com.openapi.OpenApiGenerator.Service.UserService;
import com.openapi.OpenApiGenerator.api.UserApi;
import com.openapi.OpenApiGenerator.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {


    UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Void> createUser(User user) {
        return UserApi.super.createUser(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        return UserApi.super.deleteUser(id);
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        return UserApi.super.getUsers();
    }

    @Override
    public ResponseEntity<Void> updateUser(Long id, User user) {
        return UserApi.super.updateUser(id, user);
    }
}
