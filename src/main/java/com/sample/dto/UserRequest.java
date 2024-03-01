package com.sample.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * This class for mapping the that coming from frontend and postend 
 * */
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

	
	@NotBlank(message = "user name shouldn't be null")
	private String name;
	@Email(message = "you have entered invaild mail id")
	private String mail;
	@NotNull(message = "you entered Invaild mobile number")
	private String mobile;
	private String gender;
	@Min(18)
	@Max(60)
	private int age;
	@NotBlank(message = "Kindly Enter the your nationality...")
	private String nationality;
}
