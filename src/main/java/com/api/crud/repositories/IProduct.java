package com.api.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crud.models.ProductModel;

@Repository
public interface IProduct extends JpaRepository<ProductModel, Long> {

   @Query(value = "SELECT p FROM ProductModel p WHERE p.category.id = ?1")
   List<ProductModel> findByCategoryId(Long id);
   
}