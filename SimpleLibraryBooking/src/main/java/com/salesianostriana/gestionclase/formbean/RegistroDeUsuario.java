package com.salesianostriana.gestionclase.formbean;

public class RegistroDeUsuario {
	private String email;
	private String contrasenia1;
	private String contrasenia2;

	public RegistroDeUsuario(String email, String contrasenia1, String contrasenia2) {
		super();
		this.email = email;
		this.contrasenia1 = contrasenia1;
		this.contrasenia2 = contrasenia2;
	}

	public RegistroDeUsuario() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia1() {
		return contrasenia1;
	}

	public void setContrasenia1(String contrasenia1) {
		this.contrasenia1 = contrasenia1;
	}

	public String getContrasenia2() {
		return contrasenia2;
	}

	public void setContrasenia2(String contrasenia2) {
		this.contrasenia2 = contrasenia2;
	}

	@Override
	public String toString() {
		return "RegistroDeUsuario [email=" + email + ", contrasenia1=" + contrasenia1 + ", contrasenia2=" + contrasenia2
				+ "]";
	}

}
