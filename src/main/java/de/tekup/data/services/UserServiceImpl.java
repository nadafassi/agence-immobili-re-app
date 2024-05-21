package de.tekup.data.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.data.DTO.UserRequest;
import de.tekup.data.DTO.UserResponse;
import de.tekup.data.models.Message;
import de.tekup.data.models.User;
import de.tekup.data.repositories.MessageRepository;
import de.tekup.data.repositories.UserRepository;



@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	private MessageRepository messageRepository;
	private ModelMapper mapper;
	@Autowired
	public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, MessageRepository messageRepository) {
		super();
		this.userRepository = userRepository;
		this.messageRepository=messageRepository;
		this.mapper=mapper;
		}

	
	@Override
	public UserResponse save(UserRequest request) {
		// Mappage entre UserRequest -> User
				User entity = mapper.map(request, User.class);
		//saving User
		User newUser = userRepository.save(entity);
		//saving msgs
		if(entity.getMsgs()!=null) {
			for (Message msg : entity.getMsgs()) {
				msg.setUser(newUser);
				messageRepository.save(msg);
			}}
		return mapper.map(newUser, UserResponse.class);}
	
	
	
	
	
	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
  
	
	@Override
	public UserResponse getUserById(long id) {
		
		User entity;
		Optional<User> opt = userRepository.findById(id);
		if(opt.isPresent())
			entity = opt.get();
		else
			throw new NoSuchElementException("Person with this id is not found");
		
		
		UserResponse user = new UserResponse(entity.getNom(), entity.getPrenom(),entity.getEmail(),entity.getRole(),entity.getEtat(), null);
		return user;
	}
	
	
	
	//update User 
		@Override
		public User modifyUser(long id, User newUser) {
			// is there a better way ? 
			UserResponse oldUser = this.getUserById(id);
			if(newUser.getNom() != null)
				oldUser.setNom(newUser.getNom());
			
			if(newUser.getPrenom() != null)
				oldUser.setPrenom(newUser.getPrenom());
			return newUser;
	}
		@Override
		public User deleteUserById(long id) {
			userRepository.deleteById(id);
			return null;
		
			
		}
		}
