package com.f3pro.jpamongo.repository;


import com.f3pro.jpamongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, Long> {

	
	User findByEmail(String email);
	
	User findByNameIgnoreCase(String name);
	
	
}
