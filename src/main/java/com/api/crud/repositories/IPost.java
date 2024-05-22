package com.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.models.PostModel;

@Repository
public interface IPost extends JpaRepository<PostModel, Long>{

   
}
