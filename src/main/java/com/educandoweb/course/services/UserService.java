package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DataBaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundExcepetion;

import jakarta.persistence.EntityNotFoundException;

@Service // pq a class é uma camada de serviço
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){ // para retorna todos em uma lista
		return repository.findAll();
	}
	
	public User findById(Long id) {
	Optional<User> obj =repository.findById(id);
	return obj.orElseThrow(() -> new ResourceNotFoundExcepetion(id)); // usar orElseThrow quando for usar uma expection personalizada
	}
	
	public User insert(User obj) { // insere um novo user  no bd
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		try {
		repository.deleteById(id); // deletar por ID
		} 
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExcepetion(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundExcepetion(id);
		}
	}
	
	public void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
