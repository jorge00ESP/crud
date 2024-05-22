package com.api.crud.models;

import jakarta.persistence.*;

@Entity
@Table(name = "medicine")
public class MedicineModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String name;

   @Column
   private String type;

   @Column
   private String treatment;

   @Column(name = "is_checked")
   private boolean isChecked;

   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name = "pet_id")
   private PetModel pet;

   // Getters y Setters

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getTreatment() {
      return treatment;
   }

   public void setTreatment(String treatment) {
      this.treatment = treatment;
   }

   public boolean isChecked() {
      return isChecked;
   }

   public void setChecked(boolean isChecked) {
      this.isChecked = isChecked;
   }

   public PetModel getPet() {
      return pet;
   }

   public void setPet(PetModel pet) {
      this.pet = pet;
   }
}
