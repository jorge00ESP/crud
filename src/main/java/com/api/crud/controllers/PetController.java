package com.api.crud.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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
   public PetModel save(@RequestBody PetModel pet){
      return this.petService.savePet(pet);
   }

   @PutMapping
   public PetModel updateById(@RequestBody PetModel pet){
      return this.petService.update(pet);
   }

   @DeleteMapping(path = "/{id}")
   public String deleteById(@PathVariable("id") Long id){
      boolean status = this.petService.deletePet(id);

      if(status){
         return "Pet with id " + id + " is deleted";
      }else{
         return "ERROR deleting the Pet with id " + id;
      }
   }

   @PostMapping(path = "/upload")
   public String uploadFile(@RequestBody MultipartFile file, @RequestParam("id") Long id){
      return this.petService.uploadProfileImage(file, id);
   }
}