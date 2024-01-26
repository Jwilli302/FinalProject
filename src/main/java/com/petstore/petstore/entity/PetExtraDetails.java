package com.petstore.petstore.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PETEXTRADETAILS")
public class PetExtraDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long detailsId;
	private String petColor;
	private int age;
	private int weight;
	private long petId;
	public long getDetailsId() {
		return detailsId;
	}
	public void setDetailsId(long detailsId) {
		this.detailsId = detailsId;
	}
	public String getPetColor() {
		return petColor;
	}
	public void setPetColor(String petColor) {
		this.petColor = petColor;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public long getPetId() {
		return petId;
	}
	public void setPetId(long petId) {
		this.petId = petId;
	}
	
	
	

}
