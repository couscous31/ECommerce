package fr.adaming.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name="prMB")
@RequestScoped

public class ProduitMB implements Serializable{
	
	//Transfo de l'assos Uml en Java
	@EJB
	private IProduitService produitService;
	
	//Attributs MB
	private Produit produit;
	private Agent agent;
	private Client client;
	
	HttpSession maSession;
	
	//Constructeur vide
	public ProduitMB() {
		this.produit=new Produit();
	}
	
	//Méthode Session
	@PostConstruct
	public void init(){
		//récup de la session ouverte
		this.maSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		//récup agent de session
		this.agent=(Agent) maSession.getAttribute("agentSession");
		
	}
	
	//Getter et setter
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	//Méthodes
	public String ajouterProduit(){
		
		//appel de la méthode
		Produit prAjout=produitService.addProduit(produit, agent);
		
		if(prAjout.getId() != 0){
			//récup et mettre à jour la liste
			List<Produit> liste=produitService.getAllProduit(agent, client);
			maSession.setAttribute("produitsListe", liste);
			
			return "accueilAgent";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout produit : fail !!!"));
			return "accueilAgent";
		}
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
