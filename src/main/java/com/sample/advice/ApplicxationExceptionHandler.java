package com.sample.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sample.exception.UserNotFoundException;

@RestControllerAdvice
public class ApplicxationExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
       
		Map<String, String> map=new HashMap();
		ex.getBindingResult().getFieldErrors().forEach(error-> {map.put(error.getField(), error.getDefaultMessage());});
		return map;
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> handleBusinessException(UserNotFoundException ex) {
       
		Map<String, String> map=new HashMap();
		 map.put("Error message", ex.getMessage());
		 return map;
	}
	

}
