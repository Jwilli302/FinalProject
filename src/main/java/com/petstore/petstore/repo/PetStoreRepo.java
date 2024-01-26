package com.petstore.petstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petstore.petstore.entity.PetDetails;

@Repository
public interface PetStoreRepo extends JpaRepository<PetDetails, Long> {

	PetDetails getByPetId(long petId);

}
