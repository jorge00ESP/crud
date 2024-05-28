package com.api.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.crud.models.LikesModel;


public interface ILikes extends JpaRepository<LikesModel, Long>{

   @Query(value = "SELECT l FROM LikesModel l WHERE l.post.id = ?1 AND l.user.id = ?2")
   List<LikesModel> findLikeByIdPostAndIdUser(Long idPost, Long idUser);
   
}
