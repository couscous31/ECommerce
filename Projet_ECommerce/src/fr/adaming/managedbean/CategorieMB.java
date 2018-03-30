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
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.service.ICategorieService;

@ManagedBean(name="catMB")
@RequestScoped
public class CategorieMB implements Serializable   {
	
	//transformer association uml en java :
	@EJB
	ICategorieService categorieService;
	
	//d�claration des attributs envoy�es � la page :
	private Categorie categorie;
	private Agent agent;
	private Client client;
	
	private boolean indice ;
	
	
	
	//constructeur vide :
	HttpSession catSession;

	public CategorieMB() {
		this.categorie=new Categorie();
		this.indice=false;
	}
	
	@PostConstruct
	public void init ()
	{
		//r�cup�rer la session ouverte
		catSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		//r�cup�rer l'agent stock� dans la session :
		this.agent = (Agent) catSession.getAttribute("agentListe");       ///VERIFIER LE NOM DE agentListe
		
		
		// ????????????
		//r�cup�rer le client stock�e dans la liste :
		this.client= (Client) catSession.getAttribute("clientListe");        ///VERIFIER LE NOM DE clientListe
		
		
	}

	
	//get et set
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	
	
	
	
	//m�thodes metier 
	
public boolean isIndice() {
		return indice;
	}

	public void setIndice(boolean indice) {
		this.indice = indice;
	}

	//ajouter une categorie  :
	public String ajouterCategorie()
	{
		//appel de la methode
		Categorie catOut = categorieService.ajouterCategorieService(categorie, agent);
		
		if(catOut.getIdCategorie() != 0)
		{
			//recuperer la nouvelle liste de categorie :
			List<Categorie> liste= categorieService.consulatationCategorieService(agent, client);
			
			//mettre �  jour la session :
			catSession.setAttribute("categorieListe", liste);          ///VERIFIER LE NOM DE categorieListe
			
			return "accueilAgent";
			
		}
		else
		{
			return "ajouterCategorie";
		}
		
}
	

	//modifier categorie :
	public String modifierCategorie()
	{
		//appel de la  methode :
		int verif= categorieService.modifierCategorieService(categorie, agent);
		
		if(verif != 0)
		{
			//r�cuperer la nouvelle liste de categories :
			List<Categorie> liste= categorieService.consulatationCategorieService(agent, client);
			
			//mettre � jour la session :
			catSession.setAttribute("categorieListe", liste);
			
			return "accueilAgent";
		}
		else
		{
			return "modifierCategorier";
		}
	}
	
	
	//supprimer categorie :
	public String  supprimerCategorie()
	{
		
		int verif = categorieService.supprimerCategorie(categorie, agent);
		
		if(verif!=0)
		{
			//recuperer la nouvelle liste :
			List<Categorie> liste= categorieService.consulatationCategorieService(agent, client);
			
			//mettre � jour la session :
			catSession.setAttribute("categorieListe", liste);
			
			return "accueilAgent";
		}
		else
		{
			return "supprimerCategorie";
		}
	}
		
	
		//rechercher une categorie par son id :
		public String  rechercherCategorieById ()
		{
			try {
				
			Categorie  catOut= categorieService.getCategorieByIdService(categorie, agent);
			
		
				this.categorie=catOut;
				
				return "rechercherCategorieParId";
			
			}
			catch (Exception ex)
			{
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("la categorie n'existe pas"));
				return "rechercherCategorieParId";
				
			}
		}
		
		
	
	
	
	
	

}
