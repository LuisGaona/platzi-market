package com.platzi.market.domain.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.platzi.market.persistence.crud.UsuarioRepository;
import com.platzi.market.persistence.entity.Usuario;

@Service
public class PlatziUserDetailService implements UserDetailsService {
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Usuario user=userRepository.findByUsername(username);
		 
		 if (user == null) {
	            throw new UsernameNotFoundException(username);
	        }
		return new User(user.getUsername(),"{noop}".concat(user.getPassword()), new ArrayList<>());
	}

}
