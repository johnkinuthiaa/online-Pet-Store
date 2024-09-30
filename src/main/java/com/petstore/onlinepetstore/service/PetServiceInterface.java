package com.petstore.onlinepetstore.service;

import com.petstore.onlinepetstore.model.Pet;

import java.util.List;

public interface PetServiceInterface {
    List<Pet> findAllPets();
    List<Pet> findPetByName(String name);
    List<Pet> findPetByBreed(String breed);
    List<Pet> findPetByCategory(String category);
    Pet createNewPet(Pet pet,Long id);
    Pet updateExistingPet(Pet pet,Long id);
    String deletePetById(Long id);
    String deleteAllPets();
}
