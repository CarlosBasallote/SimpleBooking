package com.salesianostriana.gestionclase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianostriana.gestionclase.model.Usuario;
import com.salesianostriana.gestionclase.repository.UsuarioRepository;
/**
 * Este servicio es importante, ya que es el que va a ser capaz
 * de "unir" nuestro modelo (y repositorio) con el esquema de
 * autenticación de Spring Security.
 * 
 * Implementa a UserDetailsService, lo que nos implica sobrescribir
 * el método loadUserByUsername, que será el que utilice nuestro 
 * AuthenticationManagerBuilder.
 * 
 * A través de este método, localizamos a nuestro usuario con sus roles
 * para construir y devolver una instancia de UserDetails. Esta es la que
 * se utiliza más adelante como Principal. 
 * 
 * @author Luismi
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// Buscamos el usuario por su nombe de usuario
		Usuario user = repository.findUserWithAuthorities(email);

		UserBuilder builder = null;

		// Si lo localizamos, procedemos a construirlo.
		if (user != null) {
			// Iniciamos la construcción con su nombre
			builder = org.springframework.security.core.userdetails.User.withUsername(email);
			// Indicamos si está habilitado o no
			builder.disabled(!user.isEnabled());
			// Establecemos su contraseña
			builder.password(user.getContrasenia());
			// Indicamos sus roles
			String[] authorities = user.getAuthorities().stream().map(a -> a.getAuthority()).toArray(String[]::new);
			builder.authorities(authorities);
		} else {
			// En caso de no localizarlo, lanzamos una excepción
			throw new UsernameNotFoundException("User not found");
		}

		// Devolvemos la instancia de UserDetails.
		return builder.build();

	}

}
