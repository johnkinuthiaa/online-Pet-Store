package com.petstore.onlinepetstore.repository;

import com.petstore.onlinepetstore.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long>{
}
