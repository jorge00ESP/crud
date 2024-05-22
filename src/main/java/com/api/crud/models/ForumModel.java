package com.api.crud.models;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

   @ManyToOne
   @JoinColumn(name = "user_id")
   private UserModel user;

   @OneToMany(mappedBy = "forum")
   private List<PostModel> post;


   public Long getId() {
      return id;
   }

   public UserModel getUser() {
      return user;
   }

   public void setUser(UserModel user) {
      this.user = user;
   }

   public List<PostModel> getPost() {
      return post;
   }

   public void setPost(List<PostModel> post) {
      this.post = post;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
