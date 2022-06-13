package com.Lucas.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.Lucas.course.entities.User;
import com.Lucas.course.repositories.UserRepository;
import com.Lucas.course.services.exception.DatabaseException;
import com.Lucas.course.services.exception.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> FindAll() {
		List<User> listaUsers = repository.findAll();
		return listaUsers;
	}
	
	public User FindById( Long ID) {
		Optional<User> obj = repository.findById(ID);
		return obj.orElseThrow(() -> new ResourceNotFoundException(ID));
	}
	
	public User Insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long ID) {
		try {
			repository.deleteById(ID);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(ID);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public User Update(Long id, User obj) {
		try {
			User entity = repository.getOne(id);
			UpdateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void UpdateData(User entity, User obj) {
		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		entity.setPhone(obj.getPhone());
		
	}
	
}
