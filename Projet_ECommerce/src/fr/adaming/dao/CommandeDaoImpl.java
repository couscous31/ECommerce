package fr.adaming.dao;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;

@Stateless
public class CommandeDaoImpl implements ICommandeDao {

	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	@Override
	public Commande recordCommande(Panier pa, Client cl) {
		em.persist(cl); //Dans un commande il y a quoi? UN client et un panier ! Il faut que j'enregistre le client
		//Je dois creer une nouvelle commande vide
		Commande comdm=new Commande();
		//Rentrer les information de la commande : la date et le panier
		comdm.setDateCommande(new Date()); //Date du jour automatique grace au pakage util date de l'ordi
		comdm.setListelc(pa.GetAllPanier());;
		
		
		
		return null;
	}

}
