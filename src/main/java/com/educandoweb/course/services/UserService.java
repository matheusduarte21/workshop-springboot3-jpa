package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service // pq a class é uma camada de serviço
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){ // para retorna todos em uma lista
		return repository.findAll();
	}
	
	public User findById(Long id) {
	Optional<User> obj =repository.findById(id);
	return obj.get();
	}
	
	public User insert(User obj) { // insere um novo user  no bd
		return repository.save(obj);
	}
}
