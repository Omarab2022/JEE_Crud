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
	<div class="container col-md-8">
		<div class="card  border-primary ">
			<div class="card-header bg-primary border-primary ">Confirmation</div>
			<div class="card-body ">

				<div class="form-group">


					<label class="control-label">ID : </label>
					 <label class="control-label">${produit.id}</label>  <br> <br>

				</div>
				<div class="form-group">


					<label class="control-label">Designation : </label>
					 <label class="control-label">${produit.designation}</label>  <br> <br>

				</div>
				<div class="form-group">


					<label class="control-label">Prix : </label>
					 <label class="control-label">${produit.prix}</label>  <br> <br>

				</div>
				<div class="form-group">


					<label class="control-label">Quantite : </label>
					 <label class="control-label">${produit.quantite}</label>  <br> <br>

				</div>


			</div>
		</div>

	</div>

</body>
</html>