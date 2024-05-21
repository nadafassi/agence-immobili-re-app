package de.tekup.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.data.models.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long>{

}
