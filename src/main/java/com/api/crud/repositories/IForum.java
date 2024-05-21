package com.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.models.ForumModel;

@Repository
public interface IForum extends JpaRepository<ForumModel, Long>{
   
}
