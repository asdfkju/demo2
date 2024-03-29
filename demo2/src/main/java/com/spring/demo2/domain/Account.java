package com.spring.demo2.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @EqualsAndHashCode( of = "id" )
@Builder @AllArgsConstructor @NoArgsConstructor
public class Account {

	
	@Id @GeneratedValue
	private Long id;
	
	@Column( unique = true )
	private String email;
	
	@Column( unique = true ) 
	private String nickname;
	
	private String password;
	
	private boolean emailVerified;
	private String emailCheckToken;
	private LocalDateTime joinedAt;
	private String bio;
	private String url;
	private String occupation;
	private String location;
	
	@Lob @Basic( fetch = FetchType.EAGER ) // defalut LAZY
	private String profileImage;
	
	private boolean studyCreatedByEmail;
	
	private boolean studyCreatedByWeb;
	
	private boolean studyEnrollmentResultByEmail;
	
	private boolean studyEnrollmentResultByWeb;
	
	private boolean studyUpdatedByEmail;
	
	private boolean studyUpdatedByWeb;

	public void generateEmailCheckToken() {  
		this.emailCheckToken = UUID.randomUUID().toString();	
	}
	
}
