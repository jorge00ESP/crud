package com.api.crud.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.PetModel;
import com.api.crud.services.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {
   
   @Autowired
   private PetService petService;

   @GetMapping
   public ArrayList<PetModel> getAll(){
      return this.petService.getAll();
   }

   @GetMapping(path = "/{id}")
   public PetModel getById(@PathVariable("id") Long id){
      return this.petService.getById(id);
   }

   @PostMapping
   public PetModel savePet(@RequestBody PetModel pet){
      return this.petService.savePet(pet);
   }

   /*@GetMapping(path = "/{id}")
   public Optional<PetModel> getUserById(@PathVariable("id") Long id){
      return this.petService.getById(id);
   }*/

   /*@PutMapping(path = "/{id}")
   public PetModel updateById(@RequestBody PetModel PetModel, @PathVariable("id") Long id){
      return this.petService.updateById(PetModel, id);
   }*/

   /*@DeleteMapping(path = "/{id}")
   public String deleteById(@PathVariable("id") Long id){
      boolean status = this.petService.deleteUser(id);

      if(status){
         return "user with id " + id + " is deleted";
      }else{
         return "ERROR deleting the user with id " + id;
      }
   }*/
}