package it.prova.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DateDTO {
	@NotNull(message = "{data.notnull}")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dataInizio;

	@NotNull(message = "{data.notnull}")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dataFine;
}
