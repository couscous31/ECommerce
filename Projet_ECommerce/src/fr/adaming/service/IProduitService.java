package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Local

public interface IProduitService {
	
	public List<Produit> getAllProduit(Agent a, Client cl);
	
	public Produit addProduit(Produit pr, Agent a);
	
	public int deleteProduit(Produit pr, Agent a);
	
	public int updateProduit(Produit pr, Agent a);
	
	public Produit getProduitById(Produit pr, Agent a);


}
