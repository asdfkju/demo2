package com.spring.demo2.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.demo2.domain.Account;


@Transactional( readOnly = true )
interface AccountRepository extends JpaRepository< Account, Long > {

	boolean existsByEmail( String email );
	boolean existsByNickname( String nickname );
	
}
