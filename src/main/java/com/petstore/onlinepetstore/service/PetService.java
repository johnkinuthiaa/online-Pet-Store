package com.petstore.onlinepetstore.service;

import com.petstore.onlinepetstore.model.Pet;
import com.petstore.onlinepetstore.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService implements PetServiceInterface{
    private final PetRepository repository;
    public PetService(PetRepository repository){
        this.repository=repository;
    }
    @Override
    public List<Pet> findAllPets() throws RuntimeException{
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("pet list is empty");
        }
        return repository.findAll();
    }
    @Override
    public List<Pet> findPetByName(String name){
        return repository.findAll().stream()
                .filter(pet->pet.getPetName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public List<Pet> findPetByBreed(String breed){
        return repository.findAll().stream()
                .filter(pet ->pet.getBreed().toLowerCase().contains(breed.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public List<Pet> findPetByCategory(String category){
        return repository.findAll().stream()
                .filter(pet->pet.getCategory().toLowerCase().toLowerCase().contains(category.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public Pet createNewPet(Pet pet,Long id) throws RuntimeException{
        if(repository.findById(id).isPresent()){
            throw new RuntimeException("pet already exists");
        }
        return repository.save(pet);
    }
    @Override
    public Pet updateExistingPet(Pet pet,Long id) throws RuntimeException{
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("pet does not exist");
        }else {
            repository.deleteById(id);
        }
        return repository.save(pet);
    }
    @Override
    public String deletePetById(Long id)  throws RuntimeException{
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("pet does not exist");
        }else{
            repository.deleteById(id);
        }
        return "pet deleted";
    }
    @Override
    public String deleteAllPets()  throws RuntimeException{
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("list is already empty");
        }else{
            repository.deleteAll();
        }
        return "all records cleared";
    }

}
