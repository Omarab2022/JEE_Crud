package DAO;

import java.util.List;

import metier.entities.Produit;

public interface IproduitDAO {
	
	public Produit save(Produit p);
	
	public List<Produit> ChercherProdParMotCle(String M);
	
	public Produit getproduit(long id);
	
	public Produit update(Produit p);
	
	public void deleteproduit(long id);
	
	

}
