package fr.adaming.managedbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@ManagedBean(name = "clMB")
@RequestScoped
public class ClientManageBean implements Serializable {

	@EJB // Transformation UML en Java
	IClientService clService;

	// Declarer comme un attribut
	private Client client;

	//Constructeurs
	public ClientManageBean() {
		this.client = new Client();
	}

	
	//Guetter et Setter
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	//Methode afficher la liste des clients
	
	

}
