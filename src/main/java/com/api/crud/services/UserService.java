package com.api.crud.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.PetModel;
import com.api.crud.models.UserModel;
import com.api.crud.repositories.IPet;
import com.api.crud.repositories.IUser;

@Service
public class UserService {

   @Autowired
   IUser iUser;

   @Autowired
   PetService petService;
   
   @Autowired
   IPet iPet;

   EncryptService encryptService = new EncryptService();

   public ArrayList<UserModel> getUsers(){
      return (ArrayList<UserModel>) iUser.findAll();
   }

   public UserModel saveUser(UserModel request){

      UserModel user = new UserModel();

      String newPass = encryptService.encryptPassword(request.getPassword());
      System.out.println("new pass ->"  + newPass);
      System.out.println("old pass ->"  + request.getPassword());

      user.setEmail(request.getEmail());
      user.setLastName(request.getLastName());
      user.setName(request.getName());
      user.setPassword(newPass);
      user.setAddress(request.getAddress());
      user.setBirthday(request.getBirthday());
      user.setPostalCode(request.getPostalCode());
      //user.setMainimage(request.);

      
      //user.getPets().add(pet);

      return iUser.save(user);
   }

   public Optional<UserModel> getById(Long id){
      return iUser.findById(id);
   }

   public UserModel updateById(UserModel request, Long id){
      UserModel user = iUser.findById(id).get();

      String newPass;

      if(request.getPassword() != null){
         newPass = encryptService.encryptPassword(request.getPassword());
         System.out.println("new pass ->"  + newPass);
      }

      System.out.println("old pass ->"  + request.getPassword());

      user.setName(request.getName());
      user.setLastName(request.getLastName());
      user.setEmail(request.getEmail());
      user.setAddress(request.getAddress());
      user.setBirthday(request.getBirthday());
      user.setPostalCode(request.getPostalCode());

      //PetModel pet = iPet.findById(1l).get();

      //System.out.println(pet);

      //user.getPets().add(pet);

      iUser.save(user);
      
      return user;
   }

   public Boolean deleteUser(Long id){
      try{

         iUser.deleteById(id);
         return true;
         
      }catch(Exception e){
         return false;
      }
   }

   public UserModel getUserPets(Long id){
      UserModel user = iUser.findById(id).get();

      ArrayList<PetModel> pets = petService.getAll();

      //user.setPets(null);

      
      System.out.println(pets);
      

      //user.setPets(pets);

      return user;
   }

   public UserModel login(String email, String password){


      UserModel userNull = new UserModel();
      UserModel user;

      try{

         user = iUser.findByEmail(email).getFirst();

         System.out.println(user.getPassword());
         System.out.println(password);

         

      }catch(NoSuchElementException error){
         return userNull;

      }

      if(encryptService.verifyPassword(user.getPassword(), password)){
         return user;
      }else{
         return userNull;
      }

      
   }

   public UserModel addPetToUser(Long userId, Long petId){

      UserModel user = iUser.findById(userId).get();

      PetModel pet = iPet.findById(petId).get();

      user.getPets().add(pet);

      iUser.save(user);

      return user;
   } 
}
