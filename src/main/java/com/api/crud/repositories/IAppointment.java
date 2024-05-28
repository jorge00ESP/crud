package com.api.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.crud.models.AppointmentModel;

public interface IAppointment extends JpaRepository<AppointmentModel, Long>{

   @Query(value = "SELECT a FROM AppointmentModel a WHERE a.pet.id = ?1")
   List<AppointmentModel> findByPetId(Long id);

}
