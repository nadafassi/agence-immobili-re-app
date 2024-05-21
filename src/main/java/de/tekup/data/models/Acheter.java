package de.tekup.data.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
/* constructer avec tous arguments*/
@AllArgsConstructor
/*constructer par defaut*/
@NoArgsConstructor
@Entity
@Table(name="Acheter")
public class Acheter extends Reserver {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
}
