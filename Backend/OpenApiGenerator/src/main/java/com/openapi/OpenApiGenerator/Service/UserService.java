package com.openapi.OpenApiGenerator.Service;

import com.openapi.OpenApiGenerator.Entity.UserEntity;
import com.openapi.OpenApiGenerator.Repository.UserRepository;
import com.openapi.OpenApiGenerator.model.User;
import io.swagger.models.auth.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    UserRepository repository;

   UserService(UserRepository repository){
       this.repository = repository;
   }

   public ResponseEntity<Void> createUser(User user){
       UserEntity userEntity = new UserEntity(user.getId(),user.getName(),user.getEmail(),user.getAge());
       repository.save(userEntity);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

   public ResponseEntity<List<User>> getUsers() {
       List<User> answer = new ArrayList<>();
       List<UserEntity> userEntities = repository.findAll();
       for (int i=0; i< userEntities.size(); i++){
           answer.add(new User(userEntities.get(i).getId(),userEntities.get(i).getName(),userEntities.get(i).getAge(),userEntities.get(i).getEmail()));
       }
       return new ResponseEntity<>(answer, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<User> getUserById(Long id){
        if(repository.existsById(id)) {
            UserEntity userEntity=  repository.findById(id).get();
            User user = new User(userEntity.getId(),userEntity.getName(),userEntity.getAge(),userEntity.getEmail());
            return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<Void> deleteUser(Long id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> updateUser(Long id, User user){
       if(repository.existsById(id)){
           UserEntity userEntity= repository.findById(id).get();
           userEntity.setName(user.getName());
           userEntity.setEmail(user.getEmail());
           userEntity.setAge(user.getAge());
           repository.save(userEntity);
       return new ResponseEntity<>(HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }





}
