package com.platzi.market.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.market.domain.dto.AuthenticationRequest;
import com.platzi.market.domain.dto.AuthenticationRespose;
import com.platzi.market.domain.service.PlatziUserDetailService;
import com.platzi.market.web.security.JWTUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
	public static final String BEARER="Bearer";
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PlatziUserDetailService platiziDetailService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationRespose> createToken(@RequestBody AuthenticationRequest request) {
	 
	try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
		 UserDetails userdetails=platiziDetailService.loadUserByUsername(request.getUsername());
		String jwt=jwtUtil.generateToken(userdetails);
		return new ResponseEntity<>(new AuthenticationRespose(BEARER.concat(" ").concat(jwt)),HttpStatus.OK);
	}catch (BadCredentialsException e) {
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
		
	
	}
}
