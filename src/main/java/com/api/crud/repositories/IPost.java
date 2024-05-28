package com.api.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crud.models.PostModel;

@Repository
public interface IPost extends JpaRepository<PostModel, Long>{

   @Query(value = "SELECT p FROM PostModel p WHERE p.forum.id = ?1")
   List<PostModel> findByForumId(Long idForum);
}
