package com.salesianostriana.gestionclase.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Sala {
	@GeneratedValue
	@Id
	private Long id;
	@NotNull
	@NotEmpty
	private String nombreSala;

	private int aforo;

	@OneToMany(mappedBy = "sala")
	Set<Reserva> listaReservasDeHabitacion = new HashSet<>();

	public Sala(Long id, String nombreSala, int aforo, Set<Reserva> listaReservasDeHabitacion) {
		this.id = id;
		this.nombreSala = nombreSala;
		this.aforo = aforo;
		this.listaReservasDeHabitacion = listaReservasDeHabitacion;
	}

	public Sala() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public Set<Reserva> getListaReservasDeHabitacion() {
		return listaReservasDeHabitacion;
	}

	public void setListaReservasDeHabitacion(Set<Reserva> listaReservasDeHabitacion) {
		this.listaReservasDeHabitacion = listaReservasDeHabitacion;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", nombreSala=" + nombreSala + ", aforo=" + aforo + ", listaReservasDeHabitacion="
				+ listaReservasDeHabitacion + "]";
	}

	// Helper

	public void addReserva(Reserva r) {
		if (r != null) {
			r.setSala(this);
			this.getListaReservasDeHabitacion().add(r);
		}
	}

	public void removeReserva(Reserva r) {
		if (r != null) {
			r.setSala(this);
			this.getListaReservasDeHabitacion().remove(r);
		}
	}

}
