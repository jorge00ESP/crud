package com.api.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.PostModel;
import com.api.crud.repositories.IForum;
import com.api.crud.repositories.IPost;
import com.api.crud.repositories.IUser;

@Service
public class PostService {

   @Autowired
   IPost iPost;

   @Autowired
   IForum iForum;

   @Autowired
   IUser iUser;

   public PostModel save(PostModel request){
      
      PostModel post = new PostModel();

      post.setForum(iForum.findById(request.getForum().getId()).get());
      post.setLikes(0);
      post.setMessage(request.getMessage());

      iPost.save(post);

      return post;
   }

   public PostModel likePost(Long id){
      
      PostModel post = iPost.findById(id).get();

      post.setLikes(post.getLikes() + 1);

      iPost.save(post);

      return post;
   }

   public PostModel dislikePost(Long id){
      
      PostModel post = iPost.findById(id).get();

      post.setLikes(post.getLikes() - 1);

      iPost.save(post);

      return post;
   }

   public PostModel update(PostModel request){
      
      PostModel post = iPost.findById(request.getId()).get();

      post.setMessage(request.getMessage());

      iPost.save(post);

      return post;
   }

   public Boolean delete(Long id){
      
      try{

         iPost.deleteById(id);
         return true;
         
      }catch(Exception e){
         return false;
      }
   }

}
