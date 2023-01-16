package it.prova.reservation.service;

import it.prova.reservation.repository.ReservationRepository;
import it.prova.reservation.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository repository;

    @Override
    public List<Reservation> listAllReservations() {
        return (List<Reservation>) repository.findAll();
    }

    @Override
    public List<Integer> findAllStanzeDisponibili(Date dataInizio, Date dataFine) {
        return repository.findAllStanzeDisponibili(dataInizio, dataFine);
    }
}
