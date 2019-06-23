package com.salesianostriana.gestionclase.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.gestionclase.model.Usuario;
import com.salesianostriana.gestionclase.services.ReservaService;
import com.salesianostriana.gestionclase.services.SalaService;
import com.salesianostriana.gestionclase.services.UsuarioService;

@Controller
public class IndexController {
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ReservaService reservaService;
	
	public static Usuario usuario;
	
	@Autowired
	SalaService salaService;
	
	
	@Autowired
	HttpSession session;
	
	
	@GetMapping("/")
	public String showIndex2(Model model) {
		return "redirect:/index";
	}
	@GetMapping("/index")
	public String showIndex(Model model) {
		Usuario usu;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    model.addAttribute("usuarioActual",auth.getName());
	    session.setAttribute("usuarioLogueado", auth.getName());
	    usu=usuarioService.buscarPorEmail(auth.getName());
		model.addAttribute("misReservas", reservaService.buscarReservasPorUsuario(usu.getIdUsuario()));

	    usuario = usuarioService.buscarPorEmail(auth.getName());
		System.out.println(IndexController.usuario.getEmail());
		
		return "/index";
	}
	
	
	@GetMapping("/delete/{idReserva}")
	public String deleteReserva(@PathVariable("idReserva") Long id) {
		reservaService.remove(reservaService.findOne(id));
		return "redirect:/index";
	}

}

