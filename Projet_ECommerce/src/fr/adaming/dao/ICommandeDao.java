package fr.adaming.dao;

import javax.ejb.Local;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Panier;

@Local
public interface ICommandeDao {
	
	public Commande recordCommande(Panier pa, Client cl);
	

}
