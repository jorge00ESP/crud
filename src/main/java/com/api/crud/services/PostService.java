package com.api.crud.services;

import java.time.LocalDateTime;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.LikesModel;
import com.api.crud.models.PostModel;
import com.api.crud.models.UserModel;
import com.api.crud.repositories.IForum;
import com.api.crud.repositories.ILikes;
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

   @Autowired
   ILikes iLike;

   public List<PostModel> findByForumId(Long idForum){
      return iPost.findByForumId(idForum);
   }

   public PostModel save(PostModel request){
      
      PostModel post = new PostModel();

      System.out.println(request.getForum());

      LocalDateTime currentTime = LocalDateTime.now();

      post.setForum(iForum.findById(request.getForum().getId()).get());
      post.setText(request.getText());
      post.setUser(iUser.findById(request.getUser().getId()).get());
      post.setDate(currentTime.getYear() + "/" + currentTime.getMonthValue() + "/" + currentTime.getDayOfMonth() + " " + currentTime.getHour() + ":" + currentTime.getMinute());

      iPost.save(post);

      post.setForum(null);

      return post;
   }

   public String likePost(Long id, Long idUser){

      try{
         @SuppressWarnings("unused")
         LikesModel like = iLike.findLikeByIdPostAndIdUser(id, idUser).getFirst();

         return "post was liked already";

      }catch(NoSuchElementException e){
         
         PostModel post = iPost.findById(id).get();
         UserModel user = iUser.findById(idUser).get();

         LikesModel like2 = new LikesModel();

         like2.setPost(post);
         like2.setUser(user);

         iLike.save(like2);

         return "post liked";
      }
            
      
   }

   public String dislikePost(Long idPost, Long idUser){

      LikesModel like = iLike.findLikeByIdPostAndIdUser(idPost, idUser).getFirst();

      System.out.println(like.toString());

      iLike.delete(like);

      return "the post is disliked";
   }

   public PostModel update(PostModel request, Long id){
      
      PostModel post = iPost.findById(id).get();

      post.setText(request.getText());

      iPost.save(post);

      post.setForum(null);

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
