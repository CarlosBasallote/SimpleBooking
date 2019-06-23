package com.salesianostriana.gestionclase.formbean;

public class ReservarForm {
	private String fechaInicio;

	public ReservarForm(String fechaInicio) {
		super();
		this.fechaInicio = fechaInicio;
	}

	public ReservarForm() {
		super();
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Override
	public String toString() {
		return "ReservarForm [fechaInicio=" + fechaInicio + "]";
	}

}
