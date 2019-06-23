package com.salesianostriana.gestionclase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.gestionclase.model.Sala;
import com.salesianostriana.gestionclase.services.SalaService;

@Controller
public class ElegirSalaController {
	
	@Autowired
	SalaService salaService;
	
	static public Sala sala = null;

	@GetMapping("/elegirSala")
	public String showElegirSala(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    model.addAttribute("usuarioActual",auth.getName());
		model.addAttribute("listaSalas", salaService.findAllSalas());
		return "/elegirSala";
	}
	
	@GetMapping("/doChoose/{id}")
	public String doChoose(@PathVariable("id") Long id) {
		sala = salaService.findById(id);
		return "redirect:/reservar";
	}
}
