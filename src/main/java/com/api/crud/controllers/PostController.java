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
import com.api.crud.models.ResponseHandler;
import com.api.crud.services.PostService;


@RestController
@RequestMapping("/post")
public class PostController {

   @Autowired
   private PostService postService;

   @GetMapping(path = "/forum/{id}")
   public List<PostModel> findByForumId(@PathVariable("id") Long idForum){
      return this.postService.findByForumId(idForum);
   }

   @PostMapping
   public PostModel save(@RequestBody PostModel post){
      return this.postService.save(post);
   }

   @PutMapping(path = "/{id}/like/{idUser}")
   public ResponseEntity<Object> like(@PathVariable("id") Long id, @PathVariable("idUser") Long idUser){
      return ResponseHandler.generateResponse("good", HttpStatus.OK, this.postService.likePost(id, idUser), 0);
   }

   @PutMapping(path = "/{id}/dislike/{idUser}")
   public ResponseEntity<Object> dislike(@PathVariable("id") Long id, @PathVariable("idUser") Long idUser){
      return ResponseHandler.generateResponse("good", HttpStatus.OK, this.postService.dislikePost(id, idUser), 0);
   }

   @PutMapping(path = "/{id}")
   public PostModel updateById(@PathVariable("id") Long id, @RequestBody PostModel post){
      return this.postService.update(post, id);
   }

   @DeleteMapping(path = "/{id}")
   public ResponseEntity<Object> deleteById(@PathVariable("id") Long id){
      boolean status = this.postService.delete(id);

      if(status){
         return ResponseHandler.generateResponse("good", HttpStatus.OK, true, 0);

      }else{
         return ResponseHandler.generateResponse("good", HttpStatus.OK, false, 0);
      }
   }

}
