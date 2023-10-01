package web;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.connector.Response;

import DAO.IproduitDAO;
import DAO.IproduitdaoImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entities.Produit;

public class ContreleurServlet extends HttpServlet {

	private IproduitDAO metier;

	@Override
	public void init() throws ServletException {

		metier = new IproduitdaoImplement();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		// to get path chercher.do
		String path = request.getServletPath();
		
		//-------------------------------------------------------------------------------------------------//

		if (path.equals("/index.do")) {
			
			String MotCle = request.getParameter("MotCle");
			ProduitModele model = new ProduitModele();

			model.setMotCle(MotCle);

			List<Produit> produits = metier.ChercherProdParMotCle("");

			model.setProduits(produits);

			request.setAttribute("model",model);

			request.getRequestDispatcher("produit.jsp").forward(request, response);

		}
		
		//-------------------------------------------------------------------------------------------------//
		
		
		else if (path.equals("/chercher.do")) {
			String MotCle = request.getParameter("MotCle");
			ProduitModele model = new ProduitModele();

			model.setMotCle(MotCle);

			List<Produit> produits = metier.ChercherProdParMotCle("%"+MotCle+"%");

			model.setProduits(produits);

			request.setAttribute("model",model);

			request.getRequestDispatcher("produit.jsp").forward(request, response);

		}
		
		
		//-------------------------------------------------------------------------------------------------//
		
		
		else if(path.equals("/saisie.do")){
			
			
			request.setAttribute("produit", new Produit());
			
			request.getRequestDispatcher("SaisieProd.jsp").forward(request, response);
			
		}
		
		//-------------------------------------------------------------------------------------------------//
		
		
		else if (path.equals("/saveproduit.do")&& (request.getMethod().equals("POST"))){
			
			
			String design = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			
			
			Produit p = metier.save(new Produit(design,prix,quantite));
			
			request.setAttribute("produit", p);
			
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			
			
			
		}
		
		
		//-------------------------------------------------------------------------------------------------//
		else if(path.equals("/supprimer.do")) {
			
			Long id= Long.parseLong(request.getParameter("id"));
			
			metier.deleteproduit(id);
			
			//request.getRequestDispatcher("produit.jsp").forward(request, response);
			
			response.sendRedirect("chercher.do?MotCle=");
			
		}
		
		//-------------------------------------------------------------------------------------------------//
				else if(path.equals("/edit.do")) {
					
					Long id= Long.parseLong(request.getParameter("id"));
					
				     Produit p = metier.getproduit(id);
				     
				     request.setAttribute("produit", p);
				     
				     request.getRequestDispatcher("Editproduit.jsp").forward(request, response);
					
				}
		
		
		//-------------------------------------------------------------------------------------------------//
		
		
				else if (path.equals("/updateproduit.do")&& (request.getMethod().equals("POST"))){
					
					Long id = Long.parseLong(request.getParameter("id"));
					
					String design = request.getParameter("designation");
					double prix = Double.parseDouble(request.getParameter("prix"));
					int quantite = Integer.parseInt(request.getParameter("quantite"));
					
					
					Produit p = new Produit(design,prix,quantite);
					
					p.setId(id);
					
					metier.update(p);
					
					
					
					request.setAttribute("produit", p);
					
					request.getRequestDispatcher("confirmation.jsp").forward(request, response);
					
					
					
				}
		
		
		else {
			response.sendError(Response.SC_NOT_FOUND);
		}

	}
	
	
	//-------------------------------------------------------------------------------------------------//
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}

}
