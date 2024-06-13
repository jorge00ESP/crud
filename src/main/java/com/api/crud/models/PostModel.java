package com.api.crud.models;

import java.util.List;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "post")
public class PostModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String text;

   @Column
   private String date;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "user_id")
   private UserModel user;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "forum_id")
   private ForumModel forum;

   @OneToMany(mappedBy = "post")
   private List<LikesModel> likes;
   
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

   public UserModel getUser() {
      return user;
   }

   public void setUser(UserModel user) {
      this.user = user;
   }

   public ForumModel getForum() {
      return forum;
   }

   public void setForum(ForumModel forum) {
      this.forum = forum;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }
}
