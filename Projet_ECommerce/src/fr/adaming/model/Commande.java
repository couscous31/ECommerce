package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commandes")
public class Commande  implements Serializable{
	
	//Declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_com")
	private long idCommande;
	private Date dateCommande;
	
	//Transformation uml en java
	@ManyToOne
	private  List<LigneCommande> listelc;
	
	//Constructeurs
	public Commande() {
		super();
	}

	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	public Commande(long idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	
	
	
	
	

}
