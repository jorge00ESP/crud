package com.api.crud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.ResponseHandler;
import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
   
   @Autowired
   private UserService userService;

   @GetMapping
   public ArrayList<UserModel> getUsers(){
      return this.userService.getUsers();
   }

   @PostMapping
   public UserModel saveUser(@RequestBody UserModel user){

      UserModel returnModel = this.userService.saveUser(user); 

      return returnModel;

   }

   @GetMapping(path = "/{id}")
   public Optional<UserModel> getUserById(@PathVariable("id") Long id){
      return this.userService.getById(id);
   }

   @PutMapping(path = "/{id}")
   public UserModel updateById(@RequestBody UserModel userModel, @PathVariable("id") Long id){
      return this.userService.updateById(userModel, id);
   }

   @DeleteMapping(path = "/{id}")
   public String deleteById(@PathVariable("id") Long id){
      boolean status = this.userService.deleteUser(id);

      if(status){
         return "user with id " + id + " is deleted";
      }else{
         return "ERROR deleting the user with id " + id;
      }
   }

   @GetMapping(path = "/{id}/pet")
   public UserModel getUsersPets(@PathVariable("id") Long id){
      return this.userService.getUserPets(id);
   }

   @PostMapping(path = "/login")
   public UserModel login(@RequestBody UserModel user){

      System.out.println(user.getEmail());
      System.out.println(user.getPassword());

      return this.userService.login(user.getEmail(), user.getPassword());
   }

   @GetMapping(path = "/{idUser}/{idPet}")
   public ResponseEntity<Object> addPetToTuser(@PathVariable("idUser") Long idUser, @PathVariable("idPet") Long idPet){

      UserModel user = this.userService.addPetToUser(idUser, idPet);
      
      return ResponseHandler.generateResponse("good", HttpStatus.OK, user, 0);
   }

   @DeleteMapping(path = "/{idUser}/{idPet}")
   public ResponseEntity<Object> deletePetToUser(@PathVariable("idUser") Long idUser, @PathVariable("idPet") Long idPet){

      UserModel user = this.userService.deletePetToUser(idUser, idPet);
      
      return ResponseHandler.generateResponse("good", HttpStatus.OK, user, 0);
   }
}
