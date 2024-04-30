package com.example.demo.model;

import jakarta.persistence.*;


@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String species;
    private String breeds;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getBreeds() {
		return breeds;
	}
	public void setBreeds(String breeds) {
		this.breeds = breeds;
	}
	public Pet(Long id, String name, String species, String breeds) {
		super();
		this.id = id;
		this.name = name;
		this.species = species;
		this.breeds = breeds;
	}
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
