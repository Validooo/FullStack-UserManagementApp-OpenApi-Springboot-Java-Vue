package com.openapi.OpenApiGenerator.Repository;

import com.openapi.OpenApiGenerator.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
