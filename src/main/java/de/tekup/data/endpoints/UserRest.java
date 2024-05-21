package de.tekup.data.endpoints;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.data.DTO.UserRequest;
import de.tekup.data.DTO.UserResponse;
import de.tekup.data.models.User;
import de.tekup.data.services.UserService;

@RestController
@RequestMapping("/User")

public class UserRest {
	@Autowired
	private UserService service;

	@Autowired
	public UserRest(UserService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	public List<User> getAll() {
		return service.getAllUsers();
	}
	@PostMapping
	public UserResponse save(@Valid @RequestBody UserRequest user) {
		return service.save(user);
	}
	
	@GetMapping("/{id}")
	public UserResponse getUserById(@PathVariable("id") long id) {
		return service.getUserById(id);
	}
	@DeleteMapping("/{id}")
	public User deletePersonById(@PathVariable("id") long id) {
		return service.deleteUserById(id);
	}
	
	@PutMapping("/{id}")
	public User updatePerson(@PathVariable("id") long id, @RequestBody User newUser) {
		return service.modifyUser(id, newUser);
	}
}
