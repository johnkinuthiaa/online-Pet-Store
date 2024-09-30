package com.petstore.onlinepetstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pet {
    @Id
    private Long petId;
    private String petName;
    private String petPicture;
    private String category;
    private String breed;
    private String description;
    private Double price;

    public Pet(){}
    public Pet(Long petId,String petName,String petPicture,String category,String breed,String description,Double price){
        this.petId=petId;
        this.petName=petName;
        this.petPicture=petPicture;
        this.category=category;
        this.breed=breed;
        this.description=description;
    }
    public void setPetId(Long petId){
        this.petId=petId;
    }
    public Long getPetId(){
        return petId;
    }
    public void setPetName(String petName){
        this.petName=petName;
    }
    public String getPetName(){
        return petName;
    }
    public void setPetPicture(String petPicture){
        this.petPicture=petPicture;
    }
    public String getPetPicture(){
        return petPicture;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public String getCategory(){
        return category;
    }
    public void setBreed(String breed){
        this.breed=breed;
    }
    public String getBreed(){
        return breed;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
