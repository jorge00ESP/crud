package com.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.models.CategoryModel;

@Repository
public interface ICategory extends JpaRepository<CategoryModel, Long> {
   
}