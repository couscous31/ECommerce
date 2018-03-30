package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Client;


@Local
public interface IClientService  {
	
	public List<Client> getAllListClientService (Client cl);

}
