package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.OneToMany;

public class Panier implements Serializable{
	
	//Transfo assos Uml et Java
	@OneToMany(mappedBy="panier")
	private List<LigneCommande> listeLignecommande;
	

}
