package com.api.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.ProductCommentModel;
import com.api.crud.models.ProductModel;
import com.api.crud.models.UserModel;
import com.api.crud.repositories.IProduct;
import com.api.crud.repositories.IProductComment;
import com.api.crud.repositories.IUser;


@Service
public class ProductCommentService {

   @Autowired
   IProductComment iProductComment;

   @Autowired
   IProduct iProduct;

   @Autowired
   IUser iUser;

   public ProductCommentModel save(ProductCommentModel request){

      ProductCommentModel productComment = new ProductCommentModel();

      System.out.println(request.toString());

      try {
         ProductCommentModel oldComment = iProductComment.findProductCommentByProductIdAndUserId(request.getProduct().getId(), request.getUser().getId());
         iProductComment.delete(oldComment);
      } catch (Exception e) {
         System.err.println("Error -> " + e);
      }

      ProductModel product = iProduct.findById(request.getProduct().getId()).get();
      UserModel user = iUser.findById(request.getUser().getId()).get();

      productComment.setProduct(product);
      productComment.setText(request.getText());
      productComment.setUser(user);
      productComment.setScoreUser(request.getScoreUser());

      iProductComment.save(productComment);

      List<ProductCommentModel> allComments = iProductComment.findAllProductCommentByProductId(request.getProduct().getId());

      double averageScore = 0;
      
      for(int i = 0; i < allComments.size(); i++){
         averageScore += allComments.get(i).getScoreUser();
      }

      averageScore = averageScore / allComments.size();

      product.setAverageScore(averageScore);

      iProduct.save(product);

      return productComment;

   }

   public List<ProductCommentModel> getAllCommentsByProduct(Long id){
      return iProductComment.findAllProductCommentByProductId(id);
   }

}