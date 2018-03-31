package fr.adaming.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.persistence.OneToMany;

import fr.adaming.service.ILigneCommandeService;

public class Panier implements Serializable {

	// Transfo assos Uml et Java avec ligne de commande
	@EJB
	ILigneCommandeService lignecommandeService;
	
	private List<LigneCommande> listeLignecommandepa =new ArrayList<>();
	
	public Collection<LigneCommande> AjouterProduit(Produit pr, int quantite) {
		// Si l'id du produit est associer a l'id de la ligne de commande je ne
		// creer pas de ligne de commande
		// Si la dans la liste l'id du produit n'existe pas alors je creer une
		// ligne de commande
		// if(listeLignecommande.get(0).getProduit().getId()==0);

		int verif = 0;
		for (LigneCommande ligne : listeLignecommandepa) {
			if (ligne.getProduit().getId() == pr.getId()) {
				ligne.setQuantite(ligne.getQuantite() + quantite);

				verif = 1;
				break;
			}
			
		}

		if (verif == 0) {
			LigneCommande lc = new LigneCommande();
			lc.getProduit();
			lc.setQuantite(quantite);
			lc.setPrix(pr.getPrix());
			listeLignecommandepa.add(lc);
			
			
		}
		
		public Collection<LigneCommande> Ligne{
			return lignecommandeService.getAllListLcService();
			
		}
		
		
	}
	
	//Consulter le total
	public double GetAllPanier(){
		double total=0;
		for(LigneCommande lc:lignecommandeService.getAllListLcService()){
			total+=lc.getPrix()*lc.getQuantite();
			
		}
		return total;
	}
	
	//Supprimer
	public void Supprimerpro(Produit pr){
		listeLignecommandepa.remove(pr.getId());
		
	}
	
	
	
	
	
	
	

	

}
