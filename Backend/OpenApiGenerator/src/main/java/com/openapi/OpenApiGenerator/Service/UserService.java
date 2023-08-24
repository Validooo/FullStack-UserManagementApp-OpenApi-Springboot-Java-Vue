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

   public User createUser(User user){
       UserEntity userEntity = new UserEntity(user.getId(),user.getName(),user.getEmail(),user.getAge());
       repository.save(userEntity);
       return user;
   }

   public List<User> getUsers() {
       List<User> answer = new ArrayList<>();
       List<UserEntity> userEntities = repository.findAll();
       for (int i=0; i< userEntities.size(); i++){
           answer.add(new User(userEntities.get(i).getId(),userEntities.get(i).getName(),userEntities.get(i).getAge(),userEntities.get(i).getEmail()));
       }
       return answer;
    }

    public User getUserById(Integer id){
        if(repository.existsById(id)) {
            UserEntity userEntity=  repository.findById(id).get();
            return new User(userEntity.getId(),userEntity.getName(),userEntity.getAge(),userEntity.getEmail());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<Void> deleteUser(Integer id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> updateUser(Integer id, User user){
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
