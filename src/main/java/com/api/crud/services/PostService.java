package com.api.crud.services;

import java.time.LocalDateTime;

import java.util.List;

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

   public List<PostModel> findByUserId(Long idUser){
      return iPost.findByUserId(idUser);
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

      LikesModel like = iLike.findLikeByIdPostAndIdUser(id, idUser);

      if(like == null){
         PostModel post = iPost.findById(id).get();
         UserModel user = iUser.findById(idUser).get();

         like = new LikesModel();

         like.setPost(post);
         like.setUser(user);

         iLike.save(like);

         return "post liked";

      }else{
         return "post was liked already";

      }
      
   }

   public String dislikePost(Long idPost, Long idUser){

      LikesModel like = iLike.findLikeByIdPostAndIdUser(idPost, idUser);

      System.out.println(like.toString());

      iLike.delete(like);

      return "the post is disliked";
   }

   public int getLikesByPostId(Long idPost){
      return iLike.findLikesByIdPost(idPost).size();
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

   public LikesModel isUserLikePost(Long idPost, Long idUser){
      return iLike.findLikeByIdPostAndIdUser(idPost, idUser);
   }

}
