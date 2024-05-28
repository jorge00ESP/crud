package com.api.crud.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "forum")
public class ForumModel {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String name;

   @Column
   private String description;

   @Column
   private Date date;

   @Column
   private Long likes;

   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinColumn(name = "user_id")
   private UserModel user;

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

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public Long getLikes() {
      return likes;
   }

   public void setLikes(Long likes) {
      this.likes = likes;
   }

   public UserModel getUser() {
      return user;
   }

   public void setUser(UserModel user) {
      this.user = user;
   }


   
}
