package com.spring.demo2.account; 


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.Length;

import lombok.Data;

@Data
public class SignUpForm {


	@NotBlank
	@Length( min = 3, max = 20 )
	@Pattern( regexp = "^[ㄱ-ㅎ가-힣a-z0-9]{3,20}$" )
    private String nickname;

	@Email
	@NotBlank
    private String email;

	@NotBlank
	@Length( min = 8, max = 50 )
    private String password;

}
