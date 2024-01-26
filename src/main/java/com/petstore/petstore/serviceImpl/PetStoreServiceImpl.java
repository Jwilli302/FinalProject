package com.petstore.petstore.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petstore.petstore.entity.PetDetails;
import com.petstore.petstore.entity.PetExtraDetails;
import com.petstore.petstore.repo.PetExtraDetailsRepo;
import com.petstore.petstore.repo.PetStoreRepo;
import com.petstore.petstore.service.PetStoreService;

@Service
public class PetStoreServiceImpl implements PetStoreService {
	
	Logger log= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PetStoreRepo petStoreRepo;
	
	@Autowired
	private PetExtraDetailsRepo petExtraDetailsRepo;

	@Override
	public PetDetails addpetDetails(PetDetails petDetails) {
		
		return petStoreRepo.save(petDetails);
	}
	
	@Override
	public PetDetails updatePetDetails(long id, PetDetails petDetails)
	{
		PetDetails oldPet=petStoreRepo.getByPetId(id);
		if(Objects.isNull(oldPet))
		{
			log.error("Pet Details not found");
		}
		else
		{
			oldPet.setPetCatgory(petDetails.getPetCatgory());
			oldPet.setPrize(petDetails.getPrize());
			petStoreRepo.save(oldPet);
		}
		
		return oldPet;
	}

	@Override
	public PetDetails getPetDetails(long petId) {
		return petStoreRepo.getByPetId(petId);
	}

	@Override
	public String deletePetDetails(long petId) {
		String msg="";
		PetDetails oldPet=petStoreRepo.getByPetId(petId);
		if(Objects.isNull(oldPet))
		{
			msg="Pet Details not found";
		}
		else
		{
			petStoreRepo.deleteById(petId);
			msg="Pet Details Deleted";
		}
		
		return msg;
		
	}

	@Override
	public PetExtraDetails addpetExtraDetails(long petId, PetExtraDetails extraDetails) {
		
		extraDetails.setPetId(petId);
		return petExtraDetailsRepo.save(extraDetails);
		
	}

	@Override
	public List<PetDetails> getAllPetDetails() {
		
		return petStoreRepo.findAll();
	}
	
	@Override
	public List<Object>  getPetAllDetails(long petId) {
		
		List<Object> hm=new ArrayList<Object>();
		PetDetails byPetId = petStoreRepo.getByPetId(petId);
		 PetExtraDetails byPetIdExtraDetails = petExtraDetailsRepo.getByPetId(petId);
		 
		 hm.add(byPetId);
		 hm.add(byPetIdExtraDetails);
		  
		  return hm;
	}

}
