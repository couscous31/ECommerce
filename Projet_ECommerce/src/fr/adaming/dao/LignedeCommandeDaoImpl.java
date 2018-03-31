package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.LigneCommande;

@Stateless
public class LignedeCommandeDaoImpl implements ILignedeCommandeDao {

	@PersistenceContext(unitName = "pu")
	private EntityManager em;

	@Override
	public List<LigneCommande> getAllListLc() {

		String req = "SELECT lc FROM LigneCommande";

		Query query = em.createQuery(req);

		return (List<LigneCommande>) query.getResultList();
	}

}
