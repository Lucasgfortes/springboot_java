package com.Lucas.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Lucas.course.entities.User;
import com.Lucas.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> lista =  service.FindAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{ID}")
	public ResponseEntity<User> findById( @PathVariable Long ID){
	    User obj = service.FindById(ID);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> Insert(@RequestBody User obj ){
	    obj = service.Insert(obj);
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	    return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{ID}")
	public ResponseEntity<Void> delete( @PathVariable Long ID){
		service.delete(ID);
		return ResponseEntity.noContent().build();
	}

	@PostMapping(value = "/{ID}")
	public ResponseEntity<User> Update(@PathVariable Long ID, @RequestBody User obj ){
		obj = service.Update(ID, obj);
		return ResponseEntity.ok().body(obj);
	}

}
