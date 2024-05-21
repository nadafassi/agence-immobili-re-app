package de.tekup.data.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReserverDTO {
	 @JsonFormat(pattern="yyyy-MM-dd")
		private Date date;
		private String Etat;
		private String Role;
}
