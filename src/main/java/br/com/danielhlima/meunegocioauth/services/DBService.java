package br.com.danielhlima.meunegocioauth.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielhlima.meunegocioauth.domain.User;
import br.com.danielhlima.meunegocioauth.domain.enums.UserProfile;
import br.com.danielhlima.meunegocioauth.repositories.UserRepository;

@Service
public class DBService {

	@Autowired
	private UserRepository repository;
	
	public void instantiateTestDataBase() throws ParseException{
		//clienteRepository.save(Arrays.asList(cli1, cli2));
		User us1 = new User(null, "João Aminadabe", "joao@joao.com.br", "2360873", UserProfile.ADMIN);
		us1.getPhones().addAll(Arrays.asList("111111111", "222222222"));
		User us2 = new User(null, "Débora Rosana", "debora@debora.com.br", "1360873", UserProfile.CLIENTE);
		us2.getPhones().addAll(Arrays.asList("333333333", "444444444"));
		User us3 = new User(null, "Pedro Alcântara", "pedro@pedro.com.br", "0360873", UserProfile.SHOPKEEPER_FREE);
		us3.getPhones().addAll(Arrays.asList("555555555", "666666666"));
		User us4 = new User(null, "Ana Andrade", "ana@ana.com.br", "3360873", UserProfile.SHOPKEEPER_PRO);
		us4.getPhones().addAll(Arrays.asList("777777777", "888888888"));
		User us5 = new User(null, "André Souza", "andre@andre.com.br", "4360873", UserProfile.ADMIN);
		us5.getPhones().addAll(Arrays.asList("999999999", "1212121212"));
		User us6 = new User(null, "Flavia Machado", "flavia@flavia.com.br", "5360873", UserProfile.CLIENTE);
		us6.getPhones().addAll(Arrays.asList("3232323232", "4545454545"));
		User us7 = new User(null, "Roberto Clementino", "beto@beto.com.br", "6360873", UserProfile.SHOPKEEPER_FREE);
		us7.getPhones().addAll(Arrays.asList("7878787878", "8989898989"));
		
		repository.saveAll(Arrays.asList(us1, us2, us3, us4, us5, us6, us7));
	}
}
