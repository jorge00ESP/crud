package com.api.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.crud.models.ProductCommentModel;

public interface IProductComment extends JpaRepository<ProductCommentModel, Long>{
   
   @Query(value = "SELECT pc FROM ProductCommentModel pc WHERE pc.product.id = ?1")
   List<ProductCommentModel> findAllProductCommentByProductId(Long id);

   @Query(value = "SELECT pc FROM ProductCommentModel pc WHERE pc.product.id = ?1 AND pc.user.id = ?2")
   ProductCommentModel findProductCommentByProductIdAndUserId(Long idProduct, Long idUser);
}
