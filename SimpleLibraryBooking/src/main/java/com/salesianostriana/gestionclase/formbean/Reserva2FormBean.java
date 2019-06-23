package com.salesianostriana.gestionclase.formbean;

public class Reserva2FormBean {
	private String horaInicio;

	public Reserva2FormBean(String horaInicio) {
		super();
		this.horaInicio = horaInicio;
	}

	public Reserva2FormBean() {
		super();
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	@Override
	public String toString() {
		return "Reserva2FormBean [horaInicio=" + horaInicio + "]";
	}

}
