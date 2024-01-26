package com.petstore.petstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petstore.petstore.entity.PetDetails;
import com.petstore.petstore.entity.PetExtraDetails;

public interface PetExtraDetailsRepo extends JpaRepository<PetExtraDetails, Long>{

	PetExtraDetails getByPetId(long petId);

}
