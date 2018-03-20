package com.f3pro.jpamongo.config;

import com.f3pro.jpamongo.entity.User;
import com.f3pro.jpamongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {

			createUser("francivaldo", "francivaldo.sza@hotmail.com");
			createUser("João","joao@gmail.com");
			createUser("Maria", "maria@gmail.com");
			
		}
		
		User user = userRepository.findByNameIgnoreCase("maria");

		System.out.println(user.getName());


		User user2 = userRepository.findByName("francivaldo");

		System.out.println(user2.getName() + user2.getEmail() +  user2.getId());


	}
	
	
	public void createUser(String name, String email) {
		
		User user = new User(name, email);
		
		userRepository.save(user);
		
		
	}

}
