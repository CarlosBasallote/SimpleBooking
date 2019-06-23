package com.salesianostriana.gestionclase.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.gestionclase.formbean.LoginDeUsuario;

@Controller
public class LogInController {

	@GetMapping("/login")
	public String showLogIn(Model model) {
		model.addAttribute("loginUsuario", new LoginDeUsuario());
		return "login";
	}
	
	@GetMapping("/logout")
	public String doLogout(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    auth.setAuthenticated(false);
		return "redirect:/";
	}


}
