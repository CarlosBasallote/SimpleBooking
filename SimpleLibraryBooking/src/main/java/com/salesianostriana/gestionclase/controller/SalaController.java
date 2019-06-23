package com.salesianostriana.gestionclase.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.gestionclase.model.Sala;
import com.salesianostriana.gestionclase.services.SalaService;

@Controller
@RequestMapping("/admin")
public class SalaController {
	
	@Autowired
	SalaService saser;
	
	
	@GetMapping("/salas")
	public String ListaOngs(Model model) {
		List<Sala> result =saser.findAllSalas();
		model.addAttribute("listaSalas", result);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    model.addAttribute("usuarioActual",auth.getName());

		return "listadoSalas";
	}
	
	@GetMapping("/RegistroSala")
	public String formularioAdd(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    model.addAttribute("usuarioActual",auth.getName());
		model.addAttribute("nuevaSala", new Sala());
		model.addAttribute("listaSalas", saser.findAllSalas());
		return "RegistroSala";
	}

	@PostMapping("/verificarSala")
	public String submit(@Valid @ModelAttribute("nuevaSala") Sala sala, BindingResult bindingResult, 
			 Model model) {
		
		
		
		if (bindingResult.hasErrors()) {
			return "redirect:/admin/RegistroSala";
		}else if(sala.getAforo()<=0){
			return "redirect:/admin/RegistroSala";
		}else {

			saser.save(sala);

			return "redirect:/admin/salas";

		}

	}
	
	@GetMapping("/borrarSala/{id}")
	public String borrar(@PathVariable("id") Long id, Model model) {
		Sala sala = saser.findById(id);
		model.addAttribute("listaSalas", saser.findAllSalas());

		if (sala != null) {
			
			saser.remove(sala);
			return "redirect:/admin/salas";
		} else {
			return "error";
		}

	}
	

	
}
