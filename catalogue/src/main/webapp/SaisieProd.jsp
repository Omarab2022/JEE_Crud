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
			<div class="card-header bg-primary border-primary ">Saisie d'un
				Produit</div>
			<div class="card-body ">

				<form action="saveproduit.do" method="post">

					<div class="form-group">

						<label class="control-label">Designation : </label><br> <br><input
							type="text" name="designation"  value="${produit.designation}" class="form-control" required="required"> <Span></Span>

					</div>
					<br>
					<div class="form-group">

						<label class="control-label">Prix : </label> <br><br><input
							type="text" name="prix" value="${produit.prix}" class="form-control" required="required" > <Span></Span>

					</div>
					<br>
					<div class="form-group">

						<label class="control-label">Quantite :</label> <br><br><input
							type="text" name="quantite" value="${produit.quantite}" class="form-control" required="required" > <Span></Span>

					</div>
					<br>
					<button type="submit" class="btn btn-success">Submit</button>
					<br>
	

				</form>






			</div>
		</div>

	</div>

</body>
</html>
