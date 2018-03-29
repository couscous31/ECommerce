package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Categorie implements Serializable {

	// Declaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cat")
	private long idCategorie;
	private String nomCategorie;
	private byte photoCat;
	private String description;

	// Constructeurs
	public Categorie() {
		super();
	}

	public Categorie(String nomCategorie, byte photoCat, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.photoCat = photoCat;
		this.description = description;
	}

	public Categorie(long idCategorie, String nomCategorie, byte photoCat, String description) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.photoCat = photoCat;
		this.description = description;
	}
	// Declaration des guetter et setter

	public long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public byte getPhotoCat() {
		return photoCat;
	}

	public void setPhotoCat(byte photoCat) {
		this.photoCat = photoCat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// Methode ToString

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", photoCat=" + photoCat
				+ ", description=" + description + "]";
	}

}
