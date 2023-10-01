package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class IproduitdaoImplement implements IproduitDAO {

	// ---------------------------------------------------------------------------------------------------------//

	@Override
	public Produit save(Produit p) {

		// create connection

		Connection connection = SingletonConnection.getConnection();

		// save produit

		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO PRODUITS (DESIGNATION,PRIX,QUANTITE) " + "VALUE (?,?,?)");

			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());

			ps.executeUpdate();

			// SET id du produit

			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM PRODUITS");

			ResultSet rs = ps2.executeQuery();

			if (rs.next()) {

				p.setId(rs.getLong("MAX_ID"));
			}

			ps.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return p;
	}

	// ---------------------------------------------------------------------------------------------------------//

	@Override
	public List<Produit> ChercherProdParMotCle(String M) {
		
		List<Produit> produits = new ArrayList<Produit>();

		// create connection

		Connection connection = SingletonConnection.getConnection();
		
		try {
			
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ? ");
			
			ps.setString(1, M);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Produit p = new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				
				produits.add(p);
			}
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return produits;
	}

	// ---------------------------------------------------------------------------------------------------------//

	@Override
	public Produit getproduit(long id) {

		Produit p = null;

		// create connection

		Connection connection = SingletonConnection.getConnection();
		
		try {
			
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM PRODUITS WHERE ID=? ");
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				p= new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				
				
			}
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return p;
	}

	// ---------------------------------------------------------------------------------------------------------//

	@Override
	public Produit update(Produit p) {

		// create connection

				Connection connection = SingletonConnection.getConnection();

				// save produit

				try {
					PreparedStatement ps = connection
							.prepareStatement("UPDATE PRODUITS SET DESIGNATION=? ,PRIX=?,QUANTITE=?  WHERE ID=? ");

					ps.setString(1, p.getDesignation());
					ps.setDouble(2, p.getPrix());
					ps.setInt(3, p.getQuantite());
					ps.setLong(4,p.getId());

					ps.executeUpdate();

					// SET id du produit

					PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM PRODUITS");

					ResultSet rs = ps2.executeQuery();

					if (rs.next()) {

						p.setId(rs.getLong("MAX_ID"));
					}

					ps.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				return p;
	}

	// ---------------------------------------------------------------------------------------------------------//

	@Override
	public void deleteproduit(long id) {
		
		// create connection

		Connection connection = SingletonConnection.getConnection();

		// save produit

		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM PRODUITS WHERE ID=?");

			ps.setLong(1, id);
			
			
			ps.executeUpdate();

		
			ps.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}


	}

}
