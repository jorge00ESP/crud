package com.api.crud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.ForumModel;
import com.api.crud.services.ForumService;

@RestController
@RequestMapping("/forum")
public class ForumController {

   @Autowired
   private ForumService forumService;

   @GetMapping
   public ArrayList<ForumModel> getAll(){
      return this.forumService.getAll();
   }

   @GetMapping(path = "/{id}")
   public Optional<ForumModel> getById(@PathVariable("id") Long id){
      return this.forumService.getById(id);
   }

   @PostMapping
   public ForumModel save(@RequestBody ForumModel forum){
      return this.forumService.save(forum);
   }
   
}
