package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.PetRepo;
import com.example.demo.model.Pet;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepo petRepository;

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public void savePet(Pet pet) {
        this.petRepository.save(pet);
    }

    @Override
    public Pet getPetById(long id) {
        Optional<Pet> optional = petRepository.findById(id);
        Pet pet = null;
        if (optional.isPresent()) {
            pet = optional.get();
        } else {
            throw new RuntimeException("Pet not found for id: " + id);
        }
        return pet;
    }

    @Override
    public void deletePetById(long id) {
        this.petRepository.deleteById(id);
    }

    // Properly implemented methods

    @Override
    public List<Pet> getAllEmployee() {
        return petRepository.findAll();
    }

    @Override
    public Pet getEmployeeById(long id) {
        Optional<Pet> optional = petRepository.findById(id);
        Pet pet = null;
        if (optional.isPresent()) {
            pet = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id: " + id);
        }
        return pet;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.petRepository.deleteById(id);
    }

    @Override
    public void updatePet(Pet pet) {
        this.petRepository.save(pet);
    }

	@Override
	public void saveEmployee(Pet employee) {
		// TODO Auto-generated method stub
		
	}
}
