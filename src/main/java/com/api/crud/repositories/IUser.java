package com.api.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crud.models.UserModel;

@Repository
public interface IUser extends JpaRepository<UserModel, Long> {

   @Query(value = "SELECT p FROM UserModel p WHERE p.email = ?1")
   List<UserModel> findByEmail(String email);
   
}
