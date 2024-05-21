package com.api.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.ForumModel;
import com.api.crud.repositories.IForum;
import com.api.crud.repositories.IUser;

@Service
public class ForumService {

   @Autowired
   IForum iForum;

   @Autowired
   IUser iUser;

   public ArrayList<ForumModel> getAll(){
      return (ArrayList<ForumModel>) iForum.findAll();
   }

   public Optional<ForumModel> getById(Long id){
      return iForum.findById(id);
   }

   public ForumModel save(ForumModel request){
      ForumModel forum = new ForumModel();

      forum.setDescription(request.getDescription());
      forum.setName(request.getName());
      forum.setUser(iUser.findById(request.getUser().getId()).get());

      iForum.save(forum);

      return forum;
   }

   public Boolean delete(Long id){
      try{

         iForum.deleteById(id);
         return true;
         
      }catch(Exception e){
         return false;
      }
   }

}
