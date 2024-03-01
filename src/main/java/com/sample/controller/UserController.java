package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.Entity.User;
import com.sample.dto.UserRequest;
import com.sample.exception.UserNotFoundException;
import com.sample.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
		return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
/*
 * if the user entered the worng details then this exception will caught then this will call/infrom to 
 * @RestcontrollerAdvice or @ControllerAdvice in that will check the exception with name, if it's is their
 * then it will handle and display the error message to the user/client */
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
		return ResponseEntity.ok(userService.getUserById(id));
	}
}
