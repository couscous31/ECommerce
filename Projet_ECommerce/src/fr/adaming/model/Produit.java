package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produits")
public class Produit implements Serializable{
	
	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_p")
	private long id;
	private String designation;
	private String description;
	private double prix;
	private int quantite;
	private boolean selectionne;
	private byte[] photoProd;
	

	
	//Constructeurs
	public Produit() {
		super();
	}
	public Produit(String designation, String description, double prix, int quantite, boolean selectionne,
			byte[] photoProd) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photoProd = photoProd;
	}
	public Produit(long id, String designation, String description, double prix, int quantite, boolean selectionne,
			byte[] photoProd) {
		super();
		this.id = id;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photoProd = photoProd;
	}
	
	//Getter et setter
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public boolean isSelectionne() {
		return selectionne;
	}
	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}
	public byte[] getPhotoProd() {
		return photoProd;
	}
	public void setPhotoProd(byte[] photoProd) {
		this.photoProd = photoProd;
	}
	
	

}
