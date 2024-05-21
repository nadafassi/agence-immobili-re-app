package de.tekup.data.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	private String nom;
	private String prenom;
	private String email;
	private String pwd;
	private String Role;
	private String  Etat;
}
