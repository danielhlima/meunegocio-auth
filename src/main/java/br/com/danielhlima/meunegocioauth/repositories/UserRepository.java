package br.com.danielhlima.meunegocioauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielhlima.meunegocioauth.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
