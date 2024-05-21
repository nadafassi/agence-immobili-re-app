package de.tekup.data.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
/* constructer avec tous arguments*/
@AllArgsConstructor
/*constructer par defaut*/
@NoArgsConstructor
@Entity
@Table(name="Users")
@EqualsAndHashCode(exclude = {"msgs"})
@ToString(exclude = {"msgs"})
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name =  "nom", length = 50, nullable = false, unique = true)
	private String nom;
	@Column(name =  "prenom", length = 50, nullable = false, unique = true)
	private String prenom;
	private String email;
	private String pwd;
	private String Role;
	@Column(name =  "Etat", length = 50, nullable = false, unique = true)
	private String  Etat;
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)    
	private Set<Message> msgs;
	
	
	
	

}
