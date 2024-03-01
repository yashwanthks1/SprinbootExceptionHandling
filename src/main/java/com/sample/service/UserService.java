package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.Entity.User;
import com.sample.dto.UserRequest;
import com.sample.exception.UserNotFoundException;
import com.sample.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User saveUser(UserRequest userRequest)
	{
		User user=User.build(0,userRequest.getName(), userRequest.getMail(), userRequest.getMobile(),userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		return repository.save(user);
	}
	 
	public List<User> getAllUsers()
	{
		return repository.findAll();
	}
	
	
	/*
	 * The below method is used to find the data withrespect to one id or any one in cloumn
	 * if we want search any data by one column we do like this instead of writting 
	 *  @query 
	 *  IMP: findBy(UserId)--> First letter as to captial as your column name
	 * */
	public User getUserById(int id) throws UserNotFoundException
	{
		User user= repository.findByUserId(id);
		if(user !=null)
		return user;
		else 
			throw new UserNotFoundException("user not found in this id"+id);
	}
}
