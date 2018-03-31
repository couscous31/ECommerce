package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Categorie;

@Local

public interface ICategorieDao {

	public List<Categorie> consultationCategorie();

	public Categorie ajouterCategorie(Categorie cat);

	public int modifierCategorie(Categorie cat);

	public int supprimerCategorie(Categorie cat);

	public Categorie getCategorieById(Categorie cat);

}
