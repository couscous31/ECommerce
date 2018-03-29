package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;

@Local
public interface ICategorieService {
	
	public List<Categorie> consulatationCategorieService (Agent a, Client cl);
	
	public Categorie ajouterCategorieService (Categorie cat, Agent a);

	public int modifierCategorieService (Categorie cat, Agent a);

	public int supprimerCategorie (Categorie cat, Agent a);
	
	public  Categorie getCategorieByIdService(Categorie cat, Agent a);




}
