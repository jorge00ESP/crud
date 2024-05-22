package com.api.crud.models;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "post")
public class PostModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String message;

   @Column
   private int likes;

   @ManyToOne
   @JoinColumn(name = "forum_id")
   private ForumModel forum;

   @ManyToOne
   @JoinColumn(name = "id_user")
   private UserModel user;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public int getLikes() {
      return likes;
   }

   public void setLikes(int likes) {
      this.likes = likes;
   }

   public ForumModel getForum() {
      return forum;
   }

   public void setForum(ForumModel forum) {
      this.forum = forum;
   }

   
}
