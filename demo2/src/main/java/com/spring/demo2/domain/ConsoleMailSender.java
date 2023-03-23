package com.spring.demo2.domain;

import java.io.InputStream;

import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Profile( "local" )
@Component
public class ConsoleMailSender implements JavaMailSender {

	@Override
	public void send(SimpleMailMessage simpleMessage) throws MailException {
		
		log.info( simpleMessage.getText() + " :: 심플메세지" );
		// TODO Auto-generated method stub
		
	}

	@Override
	public void send(SimpleMailMessage... simpleMessages) throws MailException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MimeMessage createMimeMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void send(MimeMessage mimeMessage) throws MailException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void send(MimeMessage... mimeMessages) throws MailException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {
		// TODO Auto-generated method stub
		
	}

	
}
