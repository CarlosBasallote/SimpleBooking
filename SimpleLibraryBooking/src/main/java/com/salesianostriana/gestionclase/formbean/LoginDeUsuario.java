package com.salesianostriana.gestionclase.formbean;

public class LoginDeUsuario {

	private String nombreUsuario;
	private String contrasenia;

	public LoginDeUsuario(String nombreUsuario, String contrasenia) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}
	

	public LoginDeUsuario() {
		super();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "LoginDeUsuario [nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia + "]";
	}

}
