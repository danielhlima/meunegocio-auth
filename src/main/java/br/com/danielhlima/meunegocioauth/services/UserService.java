package br.com.danielhlima.meunegocioauth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielhlima.meunegocioauth.domain.User;
import br.com.danielhlima.meunegocioauth.exceptions.UserNotFoundException;
import br.com.danielhlima.meunegocioauth.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User findById(int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent())
			throw new UserNotFoundException("id-"+id);
		
		return user.get();
	}
}
