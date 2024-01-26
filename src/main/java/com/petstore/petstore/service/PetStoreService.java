package com.petstore.petstore.service;

import java.util.HashMap;
import java.util.List;

import com.petstore.petstore.entity.PetDetails;
import com.petstore.petstore.entity.PetExtraDetails;

public interface PetStoreService {
	

	PetDetails addpetDetails(PetDetails petDetails);

	PetDetails updatePetDetails(long id, PetDetails petDetails);

	PetDetails getPetDetails(long petId);

	String deletePetDetails(long petId);

	PetExtraDetails addpetExtraDetails(long petId, PetExtraDetails extraDetails);

	List<PetDetails> getAllPetDetails();

	List<Object> getPetAllDetails(long petId);

}
