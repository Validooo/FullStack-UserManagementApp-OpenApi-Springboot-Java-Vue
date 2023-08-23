package com.openapi.OpenApiGenerator.Service;

import com.openapi.OpenApiGenerator.Entity.UserEntity;
import com.openapi.OpenApiGenerator.Repository.UserRepository;
import com.openapi.OpenApiGenerator.model.User;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository repository;

   UserService(UserRepository repository){
       this.repository = repository;
   }

   public UserEntity createUser(UserEntity entity){
       repository.save(entity);
       return entity;
   }

   public List<UserEntity> getUsers() {
   return repository.findAll();
    }

    public UserEntity getUserById(Integer id){
       return  repository.findById(id).get();
    }

    public void deleteUser(Integer id){
       repository.deleteById(id);
    }

    public UserEntity updateUser(Integer id, UserEntity userEntity){
    return  repository.save(userEntity);
    }


}
