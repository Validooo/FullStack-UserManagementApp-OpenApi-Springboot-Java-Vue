package com.openapi.OpenApiGenerator.Controller;

import com.openapi.OpenApiGenerator.Service.UserService;
import com.openapi.OpenApiGeneratorr.api.AddressbookApi;

import com.openapi.OpenApiGeneratorr.model.CheckConnection200Response;
import com.openapi.OpenApiGeneratorr.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController implements AddressbookApi {

    @Override
    public ResponseEntity<CheckConnection200Response> checkConnection() {
        CheckConnection200Response checkconnectionresponse = new CheckConnection200Response();
        checkconnectionresponse.setMessage("Connected to the Server");
        return new ResponseEntity<>(checkconnectionresponse, HttpStatus.OK);
    }

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
