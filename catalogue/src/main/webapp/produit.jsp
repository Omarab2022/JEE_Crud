<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Produit</title>
</head>
<body>
 <%@include file="header.jsp"%>

	<br>
	<br>
	<div class="container col-md-10">
		<div class="card  border-primary ">
			<div class="card-header bg-primary border-primary ">Recherche
				des Produits</div>
			<div class="card-body ">

				<form action="chercher.do" method="get">
					<label> Mot cle : </label> 
					<input type="text" name="MotCle" value="${model.motCle}">
					<button class="btn btn-danger" type="submit">Chercher</button>
				</form>

				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>DESIGNATION</th>
						<th>PRIX</th>
						<th>QUANTITE</th>
					</tr>
					<!-- pour chaqie produit p qui se trouve sur la liste des produits qui se trouve dans le model -->
					<c:forEach items="${model.produits}" var="p">

						<tr>
							<td>${p.id}</td>
							<td>${p.designation}</td>
							<td>${p.prix}</td>
							<td>${p.quantite}</td>
							<td ><a onclick="return confirm('etes vous sur de supprimer !!')" href="supprimer.do?id=${p.id}">Supprimer</a></td>
							<td ><a href="edit.do?id=${p.id}">Edit</a></td>
						</tr>

					</c:forEach>
				</table>




			</div>
		</div>

	</div>

</body>
</html>
