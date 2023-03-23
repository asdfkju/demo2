package com.spring.demo2.account;


import javax.validation.Valid;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.demo2.domain.Account;
import com.spring.demo2.domain.ConsoleMailSender;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class AccountController {

	
	private final SignUpFormValidator signUpFormValidator;
	private final AccountRepository accountRepository;
	private final ConsoleMailSender consoleMailSender;
	

	@InitBinder( "signUpForm" )
	public void initBinder( WebDataBinder webDataBinder ) {
		webDataBinder.addValidators( signUpFormValidator );
	}
	
	@GetMapping( "/" )
	public String home() {
		return "home";
	}
	
	
	@GetMapping( "/sign-up" )
	public String signUpForm( Model model ) {
		model.addAttribute( "signUpForm", new SignUpForm() );
		return "account/sign-up";
	}
	

    @PostMapping( "/sign-up" )
    public String signUpSubmit( @Valid @ModelAttribute SignUpForm signUpForm, Errors errors ) {
        
    	if( errors.hasErrors() ) {
            return "account/sign-up";
        }
        
    	Account account = Account.builder()
    						.email( signUpForm.getEmail() )
    						.password( signUpForm.getPassword() )
    						.nickname( signUpForm.getNickname() )
    						.studyCreatedByEmail( true )
    						.studyEnrollmentResultByWeb( true )
    						.studyUpdatedByWeb( true )
    						.build();
    	
    	Account newAccount = accountRepository.save( account );
    	
    	
    	newAccount.generateEmailCheckToken();
    	SimpleMailMessage mailMessage = new SimpleMailMessage();
    	mailMessage.setSubject( "스터디올래, 회원 가입 인증" );
    	mailMessage.setTo( newAccount.getEmail() );
    	mailMessage.setText( "/check-email-token?token=" + newAccount.getEmailCheckToken()
    							+ "&email=" + newAccount.getEmail() );
    	
    	consoleMailSender.send( mailMessage );
    	
   
    	 
        return "redirect:/";
    }	
}
