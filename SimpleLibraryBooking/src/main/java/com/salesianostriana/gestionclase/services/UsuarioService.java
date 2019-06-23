package com.salesianostriana.gestionclase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.gestionclase.model.Usuario;
import com.salesianostriana.gestionclase.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repositorio;

	public Iterable<Usuario> findAll() {
		return repositorio.findAll();
	}

	public Usuario findOne(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	public Usuario save(Usuario u) {
		return repositorio.save(u);
	}

	public Usuario edit(Usuario u) {
		return repositorio.save(u);
	}

	public void remove(Usuario u) {
		Usuario usuarioABorrar = repositorio.findFirstByEmail(u.getEmail());

		if (usuarioABorrar != null) {
			repositorio.delete(usuarioABorrar);
		}
	}

	public Usuario login(String email, String contrasenia) {
		return repositorio.findFirstByEmailAndContrasenia(email, contrasenia);
	}

	public Usuario buscarPorEmail(String email) {
		return repositorio.findFirstByEmail(email);
	}
	
	public Iterable<Usuario> findUsuariosNoHablitados() {
		return repositorio.findUsuariosNoHablitados();
	}

}
