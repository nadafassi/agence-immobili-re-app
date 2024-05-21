package de.tekup.data.services;

import java.util.List;


import de.tekup.data.DTO.UserRequest;
import de.tekup.data.DTO.UserResponse;
import de.tekup.data.models.User;

public interface UserService {
	UserResponse save(UserRequest entity);
	List<User> getAllUsers();
	UserResponse getUserById(long id);
	User modifyUser(long id, User entity);
	User deleteUserById(long id);
	
	
	
	 
	 
}
