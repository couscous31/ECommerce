package fr.adaming.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IAgentService;

@ManagedBean(name = "aMB")
@RequestScoped
public class AgentManageBean implements Serializable {

	@EJB // Transformation UML en java
	IAgentService agentService;

	// Declarer l'agent comme attribut d'un managebean
	private Agent agent;
	private List<Categorie> CategorieListe;
	private List<Produit> produitsListe;
	

	// Constructeur
	public AgentManageBean() {
		this.agent = new Agent() ;
	}
	

	// G+S

	public IAgentService getAgentService() {
		return agentService;
	}

	public void setAgentService(IAgentService agentService) {
		this.agentService = agentService;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	// Methodes se connecter

	public String seConnecter() {

		Agent aOut = agentService.isExist(this.agent);

		if (aOut != null) {
			
			// Ajouter l'agent comme attribut de la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agentSession", aOut);
			
			return "success";

		} else {
			return "echec";
		}
	}

	public String seDeconnecter() {

		// Fermer la session ouvert
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "accueil";
	}
}
