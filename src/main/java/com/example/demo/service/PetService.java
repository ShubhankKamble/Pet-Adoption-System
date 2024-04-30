package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Pet;



public interface PetService
{
	List<Pet>getAllEmployee();
	void saveEmployee(Pet employee);
	Pet getEmployeeById(long id);
	//void deleteEmployee();
	void deleteEmployeeById(long id);
	List<Pet> getAllPets();
	Pet getPetById(long id);
	void deletePetById(long id);
	void updatePet(Pet pet);
	void savePet(Pet pet);
}
