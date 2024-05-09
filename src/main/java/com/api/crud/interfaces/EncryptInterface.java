package com.api.crud.interfaces;

public interface EncryptInterface {

   String encryptPassword(String password);
   boolean verifyPassword(String originalPasssword, String hashPassword);
   
}
