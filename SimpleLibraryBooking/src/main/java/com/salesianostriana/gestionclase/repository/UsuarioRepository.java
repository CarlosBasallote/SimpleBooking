package com.salesianostriana.gestionclase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.gestionclase.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findFirstByEmailAndContrasenia(String nombre, String contrasenia);
	
	public Usuario findFirstByEmail(String email);
	
	@Query(nativeQuery=true, value="SELECT * FROM USUARIO WHERE ENABLED IS FALSE")
	Iterable<Usuario> findUsuariosNoHablitados();
	
	@Query("select u from Usuario u JOIN FETCH u.authorities WHERE u.email = ?1")
	public Usuario findUserWithAuthorities(String email);
	
	
}
