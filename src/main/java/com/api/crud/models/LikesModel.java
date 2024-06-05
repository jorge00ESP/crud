package com.api.crud.models;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
@Table(name = "likes")
public class LikesModel {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "user_id")
   private UserModel user;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "post_id")
   private PostModel post;

   public Long getId() {
      return id;
   }

   @Override
   public String toString() {
      return "LikesModel [id=" + id + ", user=" + user + ", post=" + post + "]";
   }

   public void setId(Long id) {
      this.id = id;
   }

   public UserModel getUser() {
      return user;
   }

   public void setUser(UserModel user) {
      this.user = user;
   }

   public PostModel getPost() {
      return post;
   }

   public void setPost(PostModel post) {
      this.post = post;
   }

   

}
