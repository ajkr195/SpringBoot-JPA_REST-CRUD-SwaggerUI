package spring.boot.restful.crud.swagger.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ch.qos.logback.classic.Logger;
import spring.boot.restful.crud.swagger.model.AppUser;
import spring.boot.restful.crud.swagger.repository.AppUserRepository;

@RestController
@RequestMapping("/api/AppUser")
public class AppUserControllerREST {
	
	Logger logger = (Logger) LoggerFactory.getLogger(AppUserControllerREST.class);
	
	@Autowired
	AppUserRepository appUserRepository;
	
	@JsonIgnore
	@GetMapping(value = "/all", produces = "application/json")
	public List<AppUser> getResource() {
		return appUserRepository.findAll();
	}
	
	@JsonIgnore
	@GetMapping(value = "/getactiveusers", produces = "application/json")
	public List<AppUser> getActiveUsers() {
		return appUserRepository.findByUserenabledTrue();
	}
	
	@JsonIgnore
	@GetMapping(value = "/getinactiveusers", produces = "application/json")
	public List<AppUser> getInActiveUsers() {
		return appUserRepository.findByUserenabledFalse();
	}
	
	@PostMapping(value = "/deactivateUser/{id}")
	public String deactivateUser(@PathVariable Long id) {
		System.out.println("De-Activating User :: " + id);
		appUserRepository.setAppUserAsInActiveById(id);
		return "OK!";
	}

	@PostMapping(value = "/activateUser/{id}")
	public String activateUser(@PathVariable Long id) {
		System.out.println("Activating User :: " + id);
		appUserRepository.setAppUserAsActiveById(id);
		return "OK!";
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteAppUser(@PathVariable Long id) {
		System.out.println("Deleting User :: " + id);
		appUserRepository.deleteById(id);
		return "OK!";
	}
	



}