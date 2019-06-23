package com.salesianostriana.gestionclase.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Long idUsuario;
	private String email;
	private String contrasenia;
	private boolean enabled;

	@OneToMany(mappedBy = "usuario")
	Set<Reserva> listaReservasDeUsuario = new HashSet<Reserva>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Authorities> authorities = new HashSet<>();

	public Usuario(Long idUsuario, String email, String contrasenia, boolean enabled,
			Set<Reserva> listaReservasDeUsuario, Set<Authorities> authorities) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.contrasenia = contrasenia;
		this.enabled = enabled;
		this.listaReservasDeUsuario = listaReservasDeUsuario;
		this.authorities = authorities;
	}

	public Usuario(String email, String contrasenia, boolean enabled, Set<Reserva> listaReservasDeUsuario,
			Set<Authorities> authorities) {
		super();
		this.email = email;
		this.contrasenia = contrasenia;
		this.enabled = enabled;
		this.listaReservasDeUsuario = listaReservasDeUsuario;
		this.authorities = authorities;
	}

	public Usuario(String email, String contrasenia, boolean enabled) {
		super();
		this.email = email;
		this.contrasenia = contrasenia;
		this.enabled = enabled;
	}

	public Usuario() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Reserva> getListaReservasDeUsuario() {
		return listaReservasDeUsuario;
	}

	public void setListaReservasDeUsuario(Set<Reserva> listaReservasDeUsuario) {
		this.listaReservasDeUsuario = listaReservasDeUsuario;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}

	// Helper

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", email=" + email + ", contrasenia=" + contrasenia + ", enabled="
				+ enabled + ", listaReservasDeUsuario=" + listaReservasDeUsuario + ", authorities=" + authorities + "]";
	}

	public void addReserva(Reserva r) {
		if (r != null) {
			r.setUsuario(this);
			this.listaReservasDeUsuario.add(r);
		}
	}

	public void removeReserva(Reserva r) {
		if (r != null) {
			r.setUsuario(this);
			this.listaReservasDeUsuario.remove(r);
		}
	}

}
