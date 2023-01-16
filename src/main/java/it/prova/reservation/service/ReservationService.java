package it.prova.reservation.service;

import it.prova.reservation.model.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationService {

    public List<Reservation> listAllReservations();

    public List<Integer> findAllStanzeDisponibili(Date dataInizio, Date dataFine);
}
