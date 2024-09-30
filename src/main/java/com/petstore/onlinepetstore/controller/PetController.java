package com.petstore.onlinepetstore.controller;

import com.petstore.onlinepetstore.model.Pet;
import com.petstore.onlinepetstore.service.PetServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pets-store")
public class PetController {
    private final PetServiceInterface service;

    public PetController(PetServiceInterface service){
        this.service=service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Pet>> findAllPets(){
        return new ResponseEntity<>(service.findAllPets(), HttpStatus.OK);
    }
    @GetMapping("/get/by-name")
    public ResponseEntity<List<Pet>> findPetByName(@RequestParam String name){
        return new ResponseEntity<>(service.findPetByName(name),HttpStatus.OK);
    }
    @GetMapping("/get/by-breed")
    public ResponseEntity<List<Pet>> findPetByBreed(@RequestParam String breed){
        return new ResponseEntity<>(service.findPetByBreed(breed),HttpStatus.OK);
    }
    @GetMapping("/get/by-category")
    public ResponseEntity<List<Pet>> findPetByCategory(@RequestParam String category){
        return new ResponseEntity<>(service.findPetByCategory(category),HttpStatus.OK);
    }
    @PostMapping("/create/new-pet")
    public ResponseEntity<Pet> createNewPet(@RequestBody Pet pet,@RequestParam Long id){
        return new ResponseEntity<>(service.createNewPet(pet,id),HttpStatus.CREATED);
    }
    @PutMapping("/update/existing")
    public ResponseEntity<Pet> updateExistingPet(@RequestBody Pet pet,@RequestParam Long id){
        return new ResponseEntity<>(service.updateExistingPet(pet,id),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/by-id")
    public ResponseEntity<String> deletePetById(@RequestParam Long id){
        return new ResponseEntity<>(service.deletePetById(id),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllPets(){
        return new ResponseEntity<>(service.deleteAllPets(),HttpStatus.ACCEPTED);
    }
}
