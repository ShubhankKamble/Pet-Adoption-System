package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pet;



@Service
public interface PetRepo extends JpaRepository<Pet,Long>
{

}