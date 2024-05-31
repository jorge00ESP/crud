package com.api.crud.services;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.CategoryModel;
import com.api.crud.models.ProductModel;
import com.api.crud.repositories.ICategory;
import com.api.crud.repositories.IPet;
import com.api.crud.repositories.IProduct;


@Service
public class ProductService {

    @Autowired
    IProduct iProduct;

    @Autowired
    ICategory iCategory;

    @Autowired
    IPet iPet;

    public ArrayList<ProductModel> getAllProducts(){
      return (ArrayList<ProductModel>) iProduct.findAll();
    }

    public ArrayList<CategoryModel> getCategories(){
      return (ArrayList<CategoryModel>) iCategory.findAll();
    }

    public ProductModel getProductById(Long id){
      return  iProduct.findById(id).get();
    }

    public List<ProductModel> getProductByCategoryId(Long id){
      return  iProduct.findByCategoryId(id);
    }

    public ProductModel save(ProductModel request){

        ProductModel product = new ProductModel();
        CategoryModel category = iCategory.findById(request.getCategory().getId()).get();

        product.setLink(request.getLink());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setType(request.getType());
        product.setCategory(category);

        iProduct.save(product);

        return product;
    }

    public ProductModel update(ProductModel request){

      ProductModel product = iProduct.findById(request.getId()).get();
      CategoryModel category = iCategory.findById(request.getCategory().getId()).get();

      product.setLink(request.getLink());
      product.setName(request.getName());
      product.setPrice(request.getPrice());
      product.setType(request.getType());
      product.setCategory(category);

      iProduct.save(product);

      return product;
    }

    public Boolean delete(Long id){
      try{

        iProduct.deleteById(id);
        return true;
         
      }catch(Exception e){
        return false;
      }
   }



}