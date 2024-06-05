package com.api.crud.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet")
public class PetModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String name;

   @Column
   private String animal;

   @Column
   private String race;

   @Column
   private Double weight;

   @Column
   private int gender;

   @Column
   private int chip;

   @Column
   private String profileImage;

   @JsonIgnore
   @ManyToMany(mappedBy = "pets")
   private List<UserModel> users;

   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
   @JoinTable(
      name = "product_pet", 
      joinColumns = @JoinColumn(name = "pet_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id")
   )
   private List<ProductModel> products;

   // Getters and Setters
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAnimal() {
      return animal;
   }

   public void setAnimal(String animal) {
      this.animal = animal;
   }

   public String getRace() {
      return race;
   }

   public void setRace(String race) {
      this.race = race;
   }

   public Double getWeight() {
      return weight;
   }

   public void setWeight(Double weight) {
      this.weight = weight;
   }

   public int getGender() {
      return gender;
   }

   public void setGender(int gender) {
      this.gender = gender;
   }

   public int isChip() {
      return chip;
   }

   public void setChip(int chip) {
      this.chip = chip;
   }

   public List<UserModel> getUsers() {
      return users;
   }

   public void setUsers(List<UserModel> users) {
      this.users = users;
   }

   public int getChip() {
      return chip;
   }

   public String getProfileImage() {
      return profileImage;
   }

   public void setProfileImage(String profileImage) {
      this.profileImage = profileImage;
   }

   public List<ProductModel> getProducts() {
      return products;
   }

   public void setProducts(List<ProductModel> products) {
      this.products = products;
   }
}
