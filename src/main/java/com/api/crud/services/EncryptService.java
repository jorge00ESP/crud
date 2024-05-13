package com.api.crud.services;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.api.crud.interfaces.EncryptInterface;

@Service
public class EncryptService implements EncryptInterface{

   @Override
   public String encryptPassword(String password) {
      return BCrypt.hashpw(password, BCrypt.gensalt());
   }

   @Override
   public boolean verifyPassword(String dbPass, String plainPass) {
      return BCrypt.checkpw(plainPass, dbPass);
   }


}
