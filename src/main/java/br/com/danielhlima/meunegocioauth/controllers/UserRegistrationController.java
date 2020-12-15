package br.com.danielhlima.meunegocioauth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserRegistrationController {

	@GetMapping("/test")
	public ResponseEntity<String> smokeHealthCheck() {
		return ResponseEntity.ok("Serviço Rodando");
	}
}
