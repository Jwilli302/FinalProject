package com.petstore.petstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="PETDETAILS")
public class PetDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petId;
	
	@NotBlank(message="pet name should not be blank")
	private String petName;
	
	@NotBlank(message="pet Category should not be blank")
	private String petCatgory;
	private int prize;
	public long getPetId() {
		return petId;
	}
	public void setPetId(long petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetCatgory() {
		return petCatgory;
	}
	public void setPetCatgory(String petCatgory) {
		this.petCatgory = petCatgory;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	
	

}
