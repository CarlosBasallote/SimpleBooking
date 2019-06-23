package com.salesianostriana.gestionclase.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.gestionclase.model.Reserva;
import com.salesianostriana.gestionclase.repository.ReservaRepository;

@Service
public class ReservaService {

	@Autowired
	ReservaRepository repositorio;
	
	@Autowired
	HttpSession session;

	
	@Autowired
	SalaService salaService;
	
	@Autowired
	UsuarioService usuarioService;

	public Reserva findOne(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	public Iterable<Reserva> findAll() {
		return repositorio.findAll();
	}

	public void remove(Reserva r) {
		Reserva reservaABorrar = repositorio.findById(r.getIdReserva()).orElse(null);
		if (reservaABorrar != null) {
			repositorio.delete(reservaABorrar);
		}
	}

	public Reserva save(Reserva r) {
		return repositorio.save(r);
	}

	public Reserva edit(Reserva r) {
		return repositorio.save(r);
	}
	
	public void reservarSala(Long idSala, LocalDateTime fechaInicio, Long idUsuario) {
		LocalDateTime fechaFin;
		fechaFin = fechaInicio.plusHours(1);
		
		Reserva nuevaReserva = new Reserva();
		nuevaReserva.setFechaInicio(fechaInicio);
		nuevaReserva.setFechaFin(fechaFin);
		nuevaReserva.setSala(salaService.findById(idSala));
		nuevaReserva.setUsuario(usuarioService.findOne(idUsuario));
		
		if(repositorio.comprobarSiEstaOcupada(fechaInicio, fechaFin) == null && fechaInicio.isAfter(LocalDateTime.now())) {
			salaService.findById(idSala).addReserva(nuevaReserva);
			usuarioService.findOne(idUsuario).addReserva(nuevaReserva);
			
			
			repositorio.save(nuevaReserva);
		}else {
			System.out.println("Que va loco!");
		}
		
		
	}
	
	public LocalDateTime formatearFechas(String dia, String hora) {
		String nuevo = dia+" "+hora;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(nuevo, formatter);
		return dateTime;
	}
	
	public Reserva comprobarSiEstaOcupada(LocalDateTime fechaInicio) {
		LocalDateTime fechaFin = fechaInicio.plusHours(1);
		return repositorio.comprobarSiEstaOcupada(fechaInicio, fechaFin);
	}
	
	public Iterable<Reserva> buscarReservasPorUsuario(Long id){
		return repositorio.buscarReservasDeUsuario(id);
	}
}
