package com.api.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.crud.models.CategoryModel;
import com.api.crud.models.ProductModel;
import com.api.crud.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

   @Autowired
   private ProductService productService;

   @GetMapping
   public List<ProductModel> getAll(){
      return this.productService.getAllProducts();
   }

   @GetMapping(path = "/category")
   public List<CategoryModel> getCategory(){
      return this.productService.getCategories();
   }

   @GetMapping(path = "/category/{id}")
   public List<ProductModel> getProductByCategoryId(@PathVariable("id") Long id){
      return this.productService.getProductByCategoryId(id);
   }

   @GetMapping(path = "/{id}")
   public ProductModel getById(@PathVariable("id") Long id){
      return this.productService.getProductById(id);
   }

   @PostMapping
   public ProductModel save(@RequestBody ProductModel product){
      return this.productService.save(product);
   }

   @PutMapping
   public ProductModel update(@RequestBody ProductModel product){
      return this.productService.update(product);
   }

   @DeleteMapping(path = "/{id}")
   public String deleteById(@PathVariable("id") Long id){
      boolean status = this.productService.delete(id);

      if(status){
         return "Product with id " + id + " is deleted";
      }else{
         return "ERROR deleting the product with id " + id;
      }
   }

   @PostMapping(path = "/upload")
   public String uploadFile(@RequestBody MultipartFile file, @RequestParam("id") Long id){
      return this.productService.updateImage(file, id);
   }
}
