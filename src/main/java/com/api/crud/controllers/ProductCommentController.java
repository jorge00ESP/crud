package com.api.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.ProductCommentModel;
import com.api.crud.services.ProductCommentService;


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