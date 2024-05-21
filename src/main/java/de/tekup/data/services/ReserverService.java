package de.tekup.data.services;

import java.util.List;


import de.tekup.data.models.Client;
import de.tekup.data.models.Produit;



public interface ReserverService {
	public List<Client> getReserversByClient(String client);
	public List<Produit> getReserversByproduit(String client);
	}
