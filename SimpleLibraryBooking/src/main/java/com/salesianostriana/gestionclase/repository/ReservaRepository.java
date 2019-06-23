package com.salesianostriana.gestionclase.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.gestionclase.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM RESERVA RIGHT JOIN SALA ON ( RESERVA.SALA_ID =  SALA.ID) WHERE (:inicio  BETWEEN FECHAINICIO AND FECHAFIN AND  :fin   BETWEEN FECHAINICIO AND FECHAFIN AND (	:inicio >= FECHAINICIO AND :fin  <= FECHAFIN));")
	Reserva comprobarSiEstaOcupada(@Param("inicio") LocalDateTime inicio, @Param("fin") LocalDateTime fin);
	
	@Query(nativeQuery = true, value = "SELECT * FROM RESERVA JOIN USUARIO ON  (RESERVA.USUARIO_IDUSUARIO = USUARIO.IDUSUARIO) WHERE USUARIO.IDUSUARIO = :id")
	Iterable<Reserva> buscarReservasDeUsuario(@Param("id") Long id);
}
