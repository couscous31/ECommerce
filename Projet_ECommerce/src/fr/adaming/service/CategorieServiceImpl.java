package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;


@Stateful
public class CategorieServiceImpl implements ICategorieService {
	
	@EJB
	private ICategorieDao categorieDao;

	@Override
	public List<Categorie> consulatationCategorieService(Agent a, Client cl) {
		// TODO Auto-generated method stub
		return categorieDao.consulatationCategorie(a, cl);
	}

	@Override
	public Categorie ajouterCategorieService(Categorie cat, Agent a) {
		 cat.setAgent(a);
		return categorieDao.ajouterCategorie(cat);
	}

	@Override
	public int modifierCategorieService(Categorie cat, Agent a) {
		cat.setAgent(a);
		return categorieDao.modifierCategorie(cat);
	}

	@Override
	public int supprimerCategorie(Categorie cat, Agent a) {
		cat.setAgent(a);
		return categorieDao.supprimerCategorie(cat);
	}

}
