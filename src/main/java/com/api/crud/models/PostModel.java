package com.api.crud.models;

import jakarta.persistence.Table;
import java.sql.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
   private String text;

   @Column
   private Date date;

   @Column
   private int likes;

   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name = "user_id")
   private UserModel user;

   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name = "forum_id")
   private ForumModel forum;
   
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

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public int getLikes() {
      return likes;
   }

   public void setLikes(int likes) {
      this.likes = likes;
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
}
