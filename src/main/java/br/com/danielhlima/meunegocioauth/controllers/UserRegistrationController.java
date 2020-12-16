package br.com.danielhlima.meunegocioauth.controllers;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.danielhlima.meunegocioauth.domain.User;
import br.com.danielhlima.meunegocioauth.services.UserService;


@RestController
@RequestMapping("users")
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/test")
	public ResponseEntity<String> smokeHealthCheck() {
		return ResponseEntity.ok("Serviço Rodando");
	}
	
	@PostMapping()
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		
		User savedUser = userService.createUser(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/{id}")
	public User retrieveUser(@PathVariable int id) {
		return userService.findById(id);
	}
}
