package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Client;

@Stateless
public class ClientDaoImpl implements IClientDao {

	@PersistenceContext(unitName = "pu")
	private EntityManager em;

	@Override
	public List<Client> getAllListClient(Client cl) {

		String req = "SELECT cl FROM Client";

		Query query = em.createQuery(req);

		return (List<Client>) query.getSingleResult();
	}

}
