package de.tekup.data.DTO;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
	@NotBlank(message = "Name may not be blank")
	@Size(max = 50, min = 3)
	@Pattern(regexp = "[a-zA-Z ]+", message = "Nom must contain only characters")
	private String nom;
	@NotBlank(message = "Prenom may not be blank")
	@Size(max = 50, min = 3)
	@Pattern(regexp = "[a-zA-Z ]+", message = "Prenom must contain only characters")
	private String prenom;
	@NotEmpty
	@Email
	private String email;
	// password should not be null or empty
	// password should have at least 8 characters
	@NotEmpty
	@Size(min = 8, message = "password should have at least 8 characters")
	private String pwd;
	
	private String Role;
	private String  Etat;
}
