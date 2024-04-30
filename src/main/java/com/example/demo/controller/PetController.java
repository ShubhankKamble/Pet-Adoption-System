package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.model.Pet;
import com.example.demo.service.PetService;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/pets.html")
    public String getAllPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "pets";
    }

    @GetMapping("/login.html")
    public String showLoginForm(Model model) {
        // You can add any additional model attributes needed for your login form
        // For example, if you want to pass a custom message to the login form
        model.addAttribute("message", "Welcome! Please log in.");
        return "login";
    }

    @PostMapping("/login.html")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        // Add your authentication logic here
        // For simplicity, let's assume the login is unsuccessful
        boolean loginSuccessful = false;

        if (loginSuccessful) {
            model.addAttribute("username", username);
            return "welcome"; // Thymeleaf template for the welcome page
        } else {
            model.addAttribute("message", "Invalid credentials. Please try again.");
            return "login";
        }
    }
    @GetMapping("/register.html")
    public String showRegistrationForm(Model model) {
        // You can add any additional model attributes needed for your registration form
        return "register";
    }

    @PostMapping("/register")
    public String handleRegistration(Model model) {
        // Add your registration logic here
        // For simplicity, let's assume the registration is successful
        boolean registrationSuccessful = true;

        if (registrationSuccessful) {
            model.addAttribute("message", "Registration successful! Please log in.");
            return "login";
        } else {
            model.addAttribute("message", "Registration failed. Please try again.");
            return "register";
        }
    }
    @GetMapping("/about.html")
    public String aboutUs() {
        // This method handles GET requests to /about-us and returns the name of the Thymeleaf template (HTML) to render
        return "about"; // Thymeleaf template file name (about-us.html)
    }
    
   
    @GetMapping("/adopt.html")
    public String adopt() {
        // This method handles GET requests to /about-us and returns the name of the Thymeleaf template (HTML) to render
        return "adopt"; // Thymeleaf template file name (about-us.html)
    }
    
    @GetMapping("/review.html")
    public String review() {
        // This method handles GET requests to /about-us and returns the name of the Thymeleaf template (HTML) to render
        return "review"; // Thymeleaf template file name (about-us.html)
    }
   
    
    @GetMapping("/payment.html")
    public String payment() {
        // This method handles GET requests to /about-us and returns the name of the Thymeleaf template (HTML) to render
        return "payment"; // Thymeleaf template file name (about-us.html)
    }
    @GetMapping("/adminlogin.html")
    public String adminlogin() {
        // This method handles GET requests to /about-us and returns the name of the Thymeleaf template (HTML) to render
        return "adminlogin"; // Thymeleaf template file name (about-us.html)
    }
    @GetMapping("/admin.html")
    public String admin() {
        // This method handles GET requests to /about-us and returns the name of the Thymeleaf template (HTML) to render
        return "admin"; // Thymeleaf template file name (about-us.html)
    }
    @GetMapping("/manage.html")
    public String getAllPets1(Model model) {
    	List<Pet> listPet=petService.getAllPets();
        model.addAttribute("listPet", listPet );
        return "manage";
    }

    @GetMapping("/add.html")
    public String showNewPetForm(Model model) {
        Pet pet = new Pet();
        model.addAttribute("pet", pet);
        return "add";
    }

    @PostMapping("/savePet")
    public String savePet(@ModelAttribute("pet") Pet pet, Model model) {
        petService.savePet(pet);
        return "redirect:/manage.html";
    }

    @GetMapping("/update.html/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Pet pet = petService.getPetById(id);
        model.addAttribute("pet", pet);
        return "update";
    }
    
    @PostMapping("/updatePet")
    public String updatePet(@ModelAttribute("pet") Pet pet) {
        // Logic to update the pet in the database
        petService.updatePet(pet);
        return "redirect:/manage.html";  // Redirect to the pet list page
    }


    @GetMapping("/deletePet/{id}")
    public String deletePet(@PathVariable(value = "id") long id) {
        this.petService.deletePetById(id);
        return "redirect:/manage.html";
    }
}
