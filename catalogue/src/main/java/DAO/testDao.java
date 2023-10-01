package DAO;

import java.util.List;

import metier.entities.Produit;

public class testDao {

	public static void main(String[] args) {

		IproduitdaoImplement dao = new IproduitdaoImplement();

		Produit p1 = dao.save(new Produit("dell latitude", 800, 40));
		Produit p2 = dao.save(new Produit("lenovo thik", 6600, 40));
		Produit p3 = dao.save(new Produit("Mac air ", 300, 30));
		
		
		List<Produit> prods = dao.ChercherProdParMotCle("%t%");
		
		for(Produit p :prods) {
			
			System.out.println(p.toString());
		}
		
		

	}

}
