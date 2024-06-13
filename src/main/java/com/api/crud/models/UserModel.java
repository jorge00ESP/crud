package com.api.crud.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserModel {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String name;

   @Column
   private String lastName;

   @Column
   private String email;

   @Column
   private String password;

   @Column
   private String address;

   @Column
   private String postalCode;

   @Column
   private String birthday;

   @Column
   private String imgUser;

   @JsonIgnore
   @OneToMany(mappedBy = "user")
   private List<ForumModel> foro;
   
   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
   @JoinTable(
      name = "user_pet", 
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "pet_id")
   )
   private List<PetModel> pets;

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

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email.toLowerCase();
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getPostalCode() {
      return postalCode;
   }

   public void setPostalCode(String postalCode) {
      this.postalCode = postalCode;
   }

   public String getBirthday() {
      return birthday;
   }

   public void setBirthday(String birthday) {
      this.birthday = birthday;
   }

   public String getImgUser() {
      return imgUser;
   }

   public void setImgUser(String imgUser) {
      this.imgUser = imgUser;
   }

   public List<ForumModel> getForo() {
      return foro;
   }

   public void setForo(List<ForumModel> foro) {
      this.foro = foro;
   }

   public List<PetModel> getPets() {
      return pets;
   }

   public void setPets(List<PetModel> pets) {
      this.pets = pets;
   }

}
