package it.prova.reservation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataInizio;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataFine;

    private Integer numeroStanza;
}
