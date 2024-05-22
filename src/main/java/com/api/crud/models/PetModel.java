package com.api.crud.models;

import java.sql.Blob;
import java.util.List;

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
   private boolean chip;

   @Column
   private Long id_user;

   @Column
   private Blob petImg;

   @ManyToMany(mappedBy = "pets")
   private List<UserModel> users;

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

   public boolean isChip() {
      return chip;
   }

   public void setChip(boolean chip) {
      this.chip = chip;
   }

   public Long getId_user() {
      return id_user;
   }

   public void setId_user(Long id_user) {
      this.id_user = id_user;
   }

   public Blob getPetImg() {
      return petImg;
   }

   public void setPetImg(Blob petImg) {
      this.petImg = petImg;
   }

   public List<UserModel> getUsers() {
      return users;
   }

   public void setUsers(List<UserModel> users) {
      this.users = users;
   }
}
