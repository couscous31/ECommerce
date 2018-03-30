package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Stateful
public class ClientServiceImpl implements IClientService {

	@EJB
	private IClientDao ClientDao;

	@Override
	public List<Client> getAllListClientService(Client cl) {

		return ClientDao.getAllListClient(cl);
	}

}
