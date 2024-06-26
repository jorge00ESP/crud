package com.api.crud.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.PetModel;
import com.api.crud.repositories.IPet;

@Service
public class PetService {

   @Autowired
   IPet iPet;

   public ArrayList<PetModel> getAll(){
      return (ArrayList<PetModel>) iPet.findAll();
   }

   public PetModel getById(Long id){
      return iPet.findById(id).get();
   }

   public PetModel savePet(PetModel request){
      PetModel pet = new PetModel();

      System.out.println(request.getHeigth());

      pet.setAnimal(request.getAnimal());
      pet.setGender(request.getGender());
      pet.setHeigth(request.getHeigth());
      pet.setName(request.getName());
      pet.setRace(request.getRace());

      return iPet.save(pet);
   }

   public PetModel update(PetModel request){
      PetModel pet = new PetModel();

      pet.setAnimal(request.getAnimal());
      pet.setGender(request.getGender());
      pet.setHeigth(request.getHeigth());
      pet.setName(request.getName());
      pet.setRace(request.getRace());

      iPet.save(pet);

      return pet; 
   }

   public Boolean deletePet(Long id){
      try{

         iPet.deleteById(id);
         return true;
         
      }catch(Exception e){
         return false;
      }
   }
}
