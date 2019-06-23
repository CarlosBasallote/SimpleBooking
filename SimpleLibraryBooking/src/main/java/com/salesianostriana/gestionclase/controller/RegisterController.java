package com.salesianostriana.gestionclase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.gestionclase.formbean.RegistroDeUsuario;
import com.salesianostriana.gestionclase.model.Usuario;
import com.salesianostriana.gestionclase.services.UserDetailsServiceImpl;
import com.salesianostriana.gestionclase.services.UsuarioService;

@Controller
public class RegisterController {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/Register")
	public String showRegister(Model model) {
		model.addAttribute("RegistroUsuario", new RegistroDeUsuario());
		return "Register";
	}

	@PostMapping("/checkRegister")
	public String doRegister(@ModelAttribute("registroDeUsuario") RegistroDeUsuario registroDeUsuario) {
		if (registroDeUsuario.getContrasenia1().equals(registroDeUsuario.getContrasenia2())) {
			Usuario u = new Usuario();
			u = usuarioService.buscarPorEmail(registroDeUsuario.getEmail());
			if (u == null) {
				String pass = bCryptPasswordEncoder.encode(registroDeUsuario.getContrasenia1());
				u = new Usuario(registroDeUsuario.getEmail(), pass, false);
				usuarioService.save(u);
			} else {
				// Aquí poner un error que diga que el usuario ya existe.
			}

		} else {
			// Aquí poner un error que diga que las contraseñas no coinciden.
		}
		return "redirect:/login";
	}
}
