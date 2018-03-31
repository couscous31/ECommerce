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

import org.primefaces.event.RowEditEvent;

import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@ManagedBean(name = "catMB")
@RequestScoped

public class CategorieMB implements Serializable {

	// transformer association uml en java :
	@EJB
	ICategorieService categorieService;

	// déclaration des attributs envoyées à la page :
	private Categorie categorie;
	private Agent agent;
	private boolean indice;

	HttpSession catSession;

	// constructeur vide :
	public CategorieMB() {
		this.categorie = new Categorie();
		this.indice = false;
	}

	@PostConstruct
	public void init() {
		// récupérer la session ouverte
		catSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		// récupérer l'agent stocké dans la session :
		this.agent = (Agent) catSession.getAttribute("agentListe");

	}

	// getter et setter
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

	public boolean isIndice() {
		return indice;
	}

	public void setIndice(boolean indice) {
		this.indice = indice;
	}

	// méthodes metier

	// ajouter une categorie :
	public String ajouterCategorie() {
		// appel de la methode
		Categorie catOut = categorieService.ajouterCategorie(categorie);

		if (catOut.getIdCategorie() != 0) {
			// recuperer et mettre à jour la nouvelle liste de categorie :
			List<Categorie> liste = categorieService.consultationCategorie();
			catSession.setAttribute("categorieListe", liste);

			return "accueilAgent";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Ajout categorie : fail !!!"));
			return "ajouterCategorie";
		}

	}

	// modifier categories :
	public void edittable(RowEditEvent event) {
		// appel de la méthode
		categorieService.modifierCategorie((Categorie) event.getObject());

		// récup et mettre à jour la liste
		List<Categorie> liste1 = categorieService.consultationCategorie();
		catSession.setAttribute("categorieListe", liste1);

	}

	// supprimer categories :
	public void supprimerCategorie() {

		int verif = categorieService.supprimerCategorie(categorie);

		if (verif != 0) {
			// recuperer et mettre à jour la nouvelle liste :
			List<Categorie> liste2 = categorieService.consultationCategorie();
			catSession.setAttribute("categorieListe", liste2);
		} else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Suppression categorie : fail !!!"));
		}
	}

	// rechercher une categorie par son id :
	public void rechercherCategorieById() {
		try {

			this.categorie = categorieService.getCategorieById(categorie);
			this.indice = true;

		} catch (Exception ex) {

			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("la categorie n'existe pas"));
			this.indice = false;
		}
	}

}
