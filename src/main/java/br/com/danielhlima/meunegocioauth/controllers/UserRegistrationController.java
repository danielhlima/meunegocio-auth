package br.com.danielhlima.meunegocioauth.controllers;

import java.net.URI;
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
	
	//TODO: modificar este método apenas para criação e criar outro método para update, protegidos por role
	@PostMapping()
	public ResponseEntity<User> create(@Valid @RequestBody User user){
		
		User savedUser = userService.createOrUpdateUser(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> retrieveUser(@PathVariable int id) {
		User user =  userService.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
