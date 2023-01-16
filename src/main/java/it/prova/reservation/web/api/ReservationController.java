package it.prova.reservation.web.api;

import it.prova.reservation.dto.DateDTO;
import it.prova.reservation.dto.RoomDTO;
import it.prova.reservation.model.Reservation;
import it.prova.reservation.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class ReservationController {

	@Autowired
	private ReservationService reservationServiceService;

	@Autowired
	private WebClient webClient;

	@GetMapping("/test")
	public String test() {
		return "Ok";
	}

	@GetMapping()
	public List<Reservation> lista() {
		return reservationServiceService.listAllReservations();
    }

	@PostMapping("/ricerca")
	public List<Integer> stanzeDisponibili(@Valid @RequestBody DateDTO dateInput) {

		List<Integer> disponibili = reservationServiceService.findAllStanzeDisponibili(dateInput.getDataInizio(), dateInput.getDataFine());

		for(int i = 0; i < disponibili.toArray().length; i++) {
			RoomDTO room = webClient.post().uri("/findByNumero/" + disponibili.get(i)).retrieve().bodyToMono(RoomDTO.class).block();
			System.out.println(room.toString());
		}

		return disponibili;
	}
}