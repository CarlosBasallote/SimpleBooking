package com.salesianostriana.gestionclase.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.gestionclase.model.Sala;
import com.salesianostriana.gestionclase.repository.SalaRepository;

@Service
public class SalaService {

	@Autowired
	SalaRepository repositorio;

	public Sala save(Sala s) {
		return repositorio.save(s);
	}

	public Sala edit(Sala s) {
		return repositorio.save(s);
	}

	public Iterable<Sala> findAll() {
		return repositorio.findAll();
	}

	public Sala findOne(Sala s) {
		return repositorio.findById(s.getId()).orElse(null);
	}
	
	public Sala findById(long id) {
		return repositorio.findById(id).orElse(null);
	}

	public void remove(Sala s) {
		Sala salaABorrar = repositorio.findById(s.getId()).orElse(null);

		if (salaABorrar != null) {
			repositorio.delete(salaABorrar);
		}
	}
	
	public List<Sala> findAllSalas() {
		return repositorio.findAll();
	}
	
}
