package com.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.models.PetModel;

@Repository
public interface IPet extends JpaRepository<PetModel, Long>{

}
