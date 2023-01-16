package it.prova.reservation.repository;

import it.prova.reservation.model.Reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{

	@Query("select numeroStanza from Reservation where (?1 < dataInizio and ?2 < dataInizio) or (?1 > dataFine and ?2 > dataFine)")
	List<Integer> findAllStanzeDisponibili(Date dataInizio, Date dataFine);
}
