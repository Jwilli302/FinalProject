package com.petstore.petstore.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petstore.petstore.entity.PetDetails;
import com.petstore.petstore.entity.PetExtraDetails;
import com.petstore.petstore.service.PetStoreService;

import jakarta.validation.Valid;

@RestController
public class PetStoreController {
	
	@Autowired
	private PetStoreService petStoreService;

		
	@PostMapping("/addPet")
	public ResponseEntity<PetDetails>  addPetDetails(@Valid @RequestBody PetDetails petDetails)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(petStoreService.addpetDetails(petDetails));
	}
	
	@PutMapping("/updatePet/{petId}")
	public ResponseEntity<PetDetails>  updatePetDetails(@PathVariable long petId, @RequestBody PetDetails petDetails)
	{
		PetDetails updatedPetDetails = petStoreService.updatePetDetails(petId,petDetails);
		return ResponseEntity.ok(updatedPetDetails);
	}
	
	@GetMapping("/getPet/{petId}")
	public ResponseEntity<PetDetails>  getPetDetails(@PathVariable long petId)
	{
		PetDetails getPetinfo = petStoreService.getPetDetails(petId);
		return ResponseEntity.ok(getPetinfo);
	}
	
	@GetMapping("/getPetExtraDetails/{petId}")
	public ResponseEntity<List<Object>>  getPetExtraDetails(@PathVariable long petId)
	{
		List<Object> petAllDetails = petStoreService.getPetAllDetails(petId);
		return ResponseEntity.ok(petAllDetails);
	}
	
	
	@DeleteMapping("/deletePet/{petId}")
	public ResponseEntity<String>  deletePetDetails(@PathVariable long petId)
	{
		String getPetinfo = petStoreService.deletePetDetails(petId);
		return ResponseEntity.ok(getPetinfo);
	}
	
	@GetMapping("/getAllPetDetails")
	public ResponseEntity<List<PetDetails>>  getAllPetDetails()
	{
		List<PetDetails> getPetinfo = petStoreService.getAllPetDetails();
		return ResponseEntity.ok(getPetinfo);
	}
	
	
	@PostMapping("/addPetExtraDetails/{petId}")
	public ResponseEntity<PetExtraDetails>  addPetExtraDetails(@PathVariable long petId, @RequestBody PetExtraDetails extraDetails)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(petStoreService.addpetExtraDetails(petId,extraDetails));
	}
}
