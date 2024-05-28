package com.api.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.AppointmentModel;
import com.api.crud.models.PetModel;
import com.api.crud.repositories.IAppointment;
import com.api.crud.repositories.IPet;

@Service
public class AppointmentService {

   @Autowired
   IAppointment iAppointment;

   @Autowired
   IPet iPet;

   public AppointmentModel getById(Long id){
      return iAppointment.findById(id).get();
   }

   public List<AppointmentModel> getAppointmentsByPetId(Long petId){
       return iAppointment.findByPetId(petId);
   }

   public AppointmentModel save(AppointmentModel request){

      AppointmentModel appointment = new AppointmentModel();

      appointment.setIsChecked(request.getIsChecked());
      appointment.setDate(request.getDate());
      appointment.setDescription(request.getDescription());
      appointment.setName(request.getName());

      PetModel pet = iPet.findById(request.getPet().getId()).get();
      
      appointment.setPet(pet);

      iAppointment.save(appointment);

      return appointment;
   }

   public AppointmentModel update(AppointmentModel request, Long id){

      AppointmentModel appointment = iAppointment.findById(id).get();

      appointment.setIsChecked(request.getIsChecked());
      appointment.setDate(request.getDate());
      appointment.setDescription(request.getDescription());
      appointment.setName(request.getName());

      PetModel pet = iPet.findById(request.getPet().getId()).get();
      
      appointment.setPet(pet);

      iAppointment.save(appointment);

      return appointment;
   }
}
