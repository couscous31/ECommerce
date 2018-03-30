package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Agent;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Stateful

public class ProduitServiceImpl implements IProduitService{
	
	//transfo assos Uml en Java
	@EJB
	private IProduitDao produitDao;

	@Override
	public List<Produit> getAllProduit() {  
		return produitDao.getAllProduit();    
	}

	@Override
	public Produit addProduit(Produit pr) {
		return produitDao.addProduit(pr);
	}

	@Override
	public int deleteProduit(Produit pr) {
		return produitDao.deleteProduit(pr);
	}

	@Override
	public int updateProduit(Produit pr) {
		return produitDao.updateProduit(pr);
	}

	@Override
	public Produit getProduitById(Produit pr) {
		return produitDao.getProduitById(pr);
	}
	
	

}
