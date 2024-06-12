package com.api.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.PostModel;
import com.api.crud.models.ProductCommentModel;
import com.api.crud.models.ProductModel;
import com.api.crud.models.ResponseHandler;
import com.api.crud.services.PostService;
import com.api.crud.services.ProductCommentService;
import com.api.crud.services.ProductService;


@RestController
@RequestMapping("/productComment")
public class ProductCommentController {

   @Autowired
   private ProductCommentService productCommentService;

   @PostMapping
   public ProductCommentModel save(@RequestBody ProductCommentModel productComment){
      return this.productCommentService.save(productComment);
   }

   @GetMapping(path = "/product/{id}")
   public List<ProductCommentModel> getAllCommentsByProduct(@PathVariable("id") Long id){
      return productCommentService.getAllCommentsByProduct(id);
   }

}