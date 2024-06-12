package com.api.crud.models;

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
@Table(name = "productComment")
public class ProductCommentModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String text;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "product_id")
   private ProductModel product;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "user_id")
   private UserModel user;

   @Column
   private double scoreUser;

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

   public ProductModel getProduct() {
      return product;
   }

   public void setProduct(ProductModel product) {
      this.product = product;
   }

   public UserModel getUser() {
      return user;
   }

   public void setUser(UserModel user) {
      this.user = user;
   }

   public double getScoreUser() {
      return scoreUser;
   }

   public void setScoreUser(double scoreUser) {
      this.scoreUser = Math.round(scoreUser * 2) / 2.0;
   }

   @Override
   public String toString() {
      return "ProductCommentModel [id=" + id + ", text=" + text + ", product=" + product + ", user=" + user
            + ", scoreUser=" + scoreUser + "]";
   }

   

}
