package com.api.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.AppointmentModel;
import com.api.crud.services.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

   @Autowired
   private AppointmentService appointmentService;

   @GetMapping(path = "/{id}")
   public AppointmentModel getById(@PathVariable("id") Long id){
      return this.appointmentService.getById(id);
   }

   @GetMapping(path = "/pet/{id}")
   public List<AppointmentModel> getByPetId(@PathVariable("id") Long id){
      return this.appointmentService.getAppointmentsByPetId(id);
   }

   @PostMapping
   public AppointmentModel save(@RequestBody AppointmentModel appointment){
      return this.appointmentService.save(appointment);
   }

   @PutMapping(path = "/{id}")
   public AppointmentModel update(@RequestBody AppointmentModel appointment, @PathVariable("id") Long id){
      return this.appointmentService.update(appointment, id);
   }
   
}
