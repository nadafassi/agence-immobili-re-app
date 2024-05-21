package de.tekup.data.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Produits")
@EqualsAndHashCode(exclude = {"categorie","resevs"})
@ToString(exclude = {"categorie","resevs"})
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int prix;
	private String Description;
	private String Etat;
	@OneToMany(mappedBy="produit", fetch = FetchType.LAZY)    
	private Set<Reserver> resevs;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="produit", insertable = false, updatable = false, nullable=false)
	private Categorie categorie;
	
}
