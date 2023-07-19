package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service // pq a class é uma camada de serviço
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){ // para retorna todos em uma lista
		return repository.findAll();
	}
	
	public Order findById(Long id) {
	Optional<Order> obj =repository.findById(id);
	return obj.get();
	}
}
