package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;

@Stateful

public class CategorieServiceImpl implements ICategorieService {

	// Transfo de l'assos UML en Java
	@EJB
	private ICategorieDao categorieDao;

	@Override
	public List<Categorie> consultationCategorie() {
		return categorieDao.consultationCategorie();
	}

	@Override
	public Categorie ajouterCategorie(Categorie cat) {
		return categorieDao.ajouterCategorie(cat);
	}

	@Override
	public int modifierCategorie(Categorie cat) {
		return categorieDao.modifierCategorie(cat);
	}

	@Override
	public int supprimerCategorie(Categorie cat) {
		return categorieDao.supprimerCategorie(cat);
	}

	@Override
	public Categorie getCategorieById(Categorie cat) {
		return categorieDao.getCategorieById(cat);
	}

}
