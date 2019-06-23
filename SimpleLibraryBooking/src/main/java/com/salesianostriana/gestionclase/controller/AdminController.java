package com.salesianostriana.gestionclase.controller;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.gestionclase.model.Authorities;
import com.salesianostriana.gestionclase.model.Usuario;
import com.salesianostriana.gestionclase.services.UsuarioService;

@Controller
public class AdminController {

	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/verificarUsuarios")
	public String showAdmin(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    model.addAttribute("usuarioActual",auth.getName());
		
		model.addAttribute("usuarios", usuarioService.findUsuariosNoHablitados());
		return "listadoUsuarios";
	}

	@GetMapping("/usuarioSi/{id}")
	public String validarUsuario(@PathVariable("id") Long id, Model model) {

		Usuario u = new Usuario();
		u = usuarioService.findOne(id);

		if (u != null) {
			u.setEnabled(true);
			Authorities a = new Authorities();
			a.setAuthority("9001");
			a.setUser(u);
			Set<Authorities> lista = new HashSet<>();
			lista.add(a);
			u.setAuthorities(lista);
			usuarioService.save(u);
			return "redirect:/verificarUsuarios";
		} else {
			// tratamiento del error
			return "redirect:/verificarUsuarios";

		}
	}

	@GetMapping("/usuarioNo/{id}")
	public String rechazarUsuario(@PathVariable("id") Long id, Model model) {

		Usuario u = new Usuario();
		u.setIdUsuario(id);
		u = usuarioService.findOne(id);

		if (u != null) {
			usuarioService.remove(u);
			return "redirect:/verificarUsuarios";
		} else {
			// tratamiento del error
			return "Error";

		}
	}
}
