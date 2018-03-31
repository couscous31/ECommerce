package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Categorie;

@Stateless

public class CategorieDao implements ICategorieDao {

	@PersistenceContext(unitName = "pu")
	private EntityManager em;

	
	@Override
	public List<Categorie> consultationCategorie() {
		// creation de la requete SQl:
		String req = "SELECT cat FROM Categorie AS cat ";

		// création d'un query :
		Query query = em.createQuery(req);

		// envoyer la requete et recuperer le resultat :
		return query.getResultList();
	}

	@Override
	public Categorie ajouterCategorie(Categorie cat) {
		em.persist(cat);
		return cat;
	}

	@Override
	public int modifierCategorie(Categorie cat) {
		// creation de la requete :
		String req2 = "UPDATE Categorie AS cat SET cat.nomCategorie=:pNom," + "cat.description=pDescription"
				+ " cat.photoCat=:pPhoto, " + " where cat.idCategorie=:pIdCat";

		// creation d'un query :
		Query query2 = em.createQuery(req2);

		// passages des parametres :
		query2.setParameter("pNom", cat.getNomCategorie());
		query2.setParameter("pDescription", cat.getDescription());
		query2.setParameter("pPhoto", cat.getPhotoCat());
		query2.setParameter("pIdCat", cat.getIdCategorie());

		// envoyer la requete et récupérer le résultat
		return (int) query2.executeUpdate();
	}

	@Override
	public int supprimerCategorie(Categorie cat) {
		// creation de la requete :
		String req3 = "DELETE FROM Categorie WHERE cat.idCategorie=:pIdCat";

		// creation du query :
		Query query3 = em.createQuery(req3);

		// passage des parametres :
		query3.setParameter("pIdCat", cat.getIdCategorie());

		// envoyer la requete et recuperer le resultat :
		return (int) query3.executeUpdate();
	}

	
	@Override
	public Categorie getCategorieById(Categorie cat) {

		// appel de la requete :
		String req4 = "SELECT cat FROM Categorie WHERE cat.idCategorie=:pId";

		// creation du query :
		Query query4 = em.createQuery(req4);

		// passages des parametres :
		query4.setParameter("pIdCat", cat.getIdCategorie());

		return (Categorie) query4.getSingleResult();
	}

}
