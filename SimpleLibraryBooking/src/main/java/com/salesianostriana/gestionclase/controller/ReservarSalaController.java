package com.salesianostriana.gestionclase.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.gestionclase.formbean.Reserva2FormBean;
import com.salesianostriana.gestionclase.formbean.ReservarForm;
import com.salesianostriana.gestionclase.services.ReservaService;

@Controller
public class ReservarSalaController {

	@Autowired
	private HttpSession session;

	@Autowired
	ReservaService reservaService;

	@GetMapping("/reservar")
	public String showReservar(Model model) {
		model.addAttribute("fechaReserva", new ReservarForm());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    model.addAttribute("usuarioActual",auth.getName());
		return "calendario";
	}

	@PostMapping("/doReserve")
	public String doReserve(@ModelAttribute("fechaReserva") ReservarForm reservarForm) {
		System.out.println(reservarForm.getFechaInicio());
		session.setAttribute("fechaInicio", reservarForm.getFechaInicio());
		return "redirect:/horas";
	}

	@GetMapping("/horas")
	public String showHoras(Model model) {
		String hora1 = "08:00:00", hora2 = "09:00:00", hora3 = "10:00:00", hora4 = "11:30:00", hora5 = "12:30:00", hora6 = "13:30:00";
		String fechaInicio = (String) session.getAttribute("fechaInicio");
		LocalDateTime primeraHora = reservaService.formatearFechas(fechaInicio, hora1);
		LocalDateTime segundaHora = reservaService.formatearFechas(fechaInicio, hora2);
		LocalDateTime terceraHora = reservaService.formatearFechas(fechaInicio, hora3);
		LocalDateTime cuartaHora = reservaService.formatearFechas(fechaInicio, hora4);
		LocalDateTime quintaHora = reservaService.formatearFechas(fechaInicio, hora5);
		LocalDateTime sextaHora = reservaService.formatearFechas(fechaInicio, hora6);
		if (reservaService.comprobarSiEstaOcupada(primeraHora) != null) {
			model.addAttribute("primeraOcupada", true);
		}
		if (reservaService.comprobarSiEstaOcupada(segundaHora) != null) {
			model.addAttribute("segundaOcupada", true);
		}
		if (reservaService.comprobarSiEstaOcupada(terceraHora) != null) {
			model.addAttribute("terceraOcupada", true);
		}
		if (reservaService.comprobarSiEstaOcupada(cuartaHora) != null) {
			model.addAttribute("cuartaOcupada", true);
		}
		if (reservaService.comprobarSiEstaOcupada(quintaHora) != null) {
			model.addAttribute("quintaOcupada", true);
		}
		if (reservaService.comprobarSiEstaOcupada(sextaHora) != null) {
			model.addAttribute("sextaOcupada", true);
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    model.addAttribute("usuarioActual",auth.getName());
		model.addAttribute("horaReserva", new Reserva2FormBean());
		return "horas";
	}

	@PostMapping("/doReserveWithHours")
	public String doReserveWithHours(HttpSession session,
			@ModelAttribute("horaReserva") Reserva2FormBean reserva2FormBean, Model model) {

		String fechaInicio = (String) session.getAttribute("fechaInicio");

		reservaService.reservarSala(ElegirSalaController.sala.getId(),
				reservaService.formatearFechas(fechaInicio, reserva2FormBean.getHoraInicio()),
				IndexController.usuario.getIdUsuario());

		return "redirect:/reservar";
	}

}
