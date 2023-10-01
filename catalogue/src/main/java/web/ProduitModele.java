package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class ProduitModele {
	
	
	private String MotCle ;
	
	private List<Produit> produits = new ArrayList<Produit>();

	public String getMotCle() {
		return MotCle;
	}

	public void setMotCle(String motCle) {
		MotCle = motCle;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	

}
