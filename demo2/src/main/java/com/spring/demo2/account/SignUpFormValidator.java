package com.spring.demo2.account;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class SignUpFormValidator implements Validator {	
	
	// 얘도 빈으로 등록되어 있기 때문에 
	// 얘를 인자로 하는 생성자가 만들어지는 거에요.
	private final AccountRepository accountRepository;
	private String name;
	
	@Override
	public boolean supports( Class<?> aClass ) {
		return aClass.isAssignableFrom( SignUpForm.class );
	}

	@Override
	public void validate( Object target, Errors errors ) {
		SignUpForm signUpForm = ( SignUpForm ) target;
		
		if( accountRepository.existsByEmail( signUpForm.getEmail() ) ) {
			errors.rejectValue( "email", "invalid.email"
				, new Object[]{ signUpForm.getEmail() }
				, "이미 사용중인 이메일입니다." );
		}
		
		if( accountRepository.existsByNickname( signUpForm.getNickname() ) ) {
			errors.rejectValue( "nickname", "invalid.nickname"
				, new Object[]{ signUpForm.getNickname() }
				, "이미 사용중인 닉네임입니다." );
		}	
	}
}
