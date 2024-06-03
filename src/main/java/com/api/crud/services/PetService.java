package com.api.crud.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.crud.models.PetModel;
import com.api.crud.repositories.IPet;

@Service
public class PetService {

   @Autowired
   IPet iPet;

   public ArrayList<PetModel> getAll() {
      return (ArrayList<PetModel>) iPet.findAll();
   }

   public PetModel getById(Long id) {
      return iPet.findById(id).get();
   }

   public PetModel savePet(PetModel request) {
      PetModel pet = new PetModel();

      System.out.println(request.getWeight());

      pet.setAnimal(request.getAnimal());
      pet.setGender(request.getGender());
      pet.setWeight(request.getWeight());
      pet.setName(request.getName());
      pet.setRace(request.getRace());

      return iPet.save(pet);
   }

   public PetModel update(PetModel request) {
      
      PetModel pet = iPet.findById(request.getId()).get();

      pet.setAnimal(request.getAnimal());
      pet.setGender(request.getGender());
      pet.setWeight(request.getWeight());
      pet.setName(request.getName());
      pet.setRace(request.getRace());

      iPet.save(pet);

      return pet;
   }

   public Boolean deletePet(Long id) {
      try {

         iPet.deleteById(id);
         return true;

      } catch (Exception e) {
         return false;
      }
   }

   public String uploadProfileImage(MultipartFile file, Long id) {

      Path userPath = Path.of("src/main/img/profileImage/" + id);
      PetModel pet = iPet.findById(id).get();

      Path existProfileImage = null;

      try {

         if (!Files.exists(userPath)) {
            Files.createDirectories(userPath);
         }

         if (pet.getProfileImage() != null) {
            existProfileImage = Path.of(pet.getProfileImage());
            Files.deleteIfExists(existProfileImage);
         }

         String pathComplete = "src/main/img/profileImage/" + id + "/" + file.getOriginalFilename();

         Path filePath = Path.of(pathComplete);

         Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

         pet.setProfileImage(pathComplete);
         iPet.save(pet);

         return "http://localhost/crud/" + pathComplete;

      } catch (Exception e) {
         return e.toString();
      }

   }
}
