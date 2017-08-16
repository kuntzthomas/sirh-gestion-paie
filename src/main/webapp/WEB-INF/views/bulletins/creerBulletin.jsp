<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'> </c:url>">
<title>SGP - App</title>
</head>
<body>

	<div>
		<ul class="nav nav-pills">
			<li><a href="<c:url value='/mvc/employes/lister'></c:url>">Lister
					les remunerations</a></li>
			<li><a href="<c:url value='/mvc/employes/creer'></c:url>">Ajouter
					une remuneration</a></li>
			<li><a href="#">Lister les bulletins</a></li>
			<li><a href="<c:url value='/mvc/bulletins/creer'></c:url>">Créer un bulletin</a></li>
			<li><a href="<c:url value='/mvc/employes/logout'></c:url>">logout</a></li>
		</ul>
	</div>

	<h1 align="center">Créer un bulletin de salaire</h1>

	<form class="form-horizontal" method="post" action="">
		<fieldset>

			<!-- Select Periode -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="periode">Période</label>
				<div class="col-md-4">
					<select id="periode" name="periode" class="form-control">
						<c:forEach var="periode" items="${listPeriodes}">
							<option value="${periode.id}">${periode.denomination}-
								${periode.dateFin}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Select Matricule -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="matricule">Profil</label>
				<div class="col-md-4">
					<select id="matricule" name="matricule" class="form-control">
						<c:forEach var="matricule" items="${listmatricules}">
							<option value="${bulletin.remunerationEmploye.matricule}">
							${bulletin.remunerationEmploye.matricule}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Prime exeptionnelle -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Prime
					exceptionnelle</label>
				<div class="col-md-4">
					<input id="prime" name="prime" class="form-control input-md"
						type="text">
				</div>
			</div>

			<!-- Button ajout -->
			<div class="form-group">
				<div align="right" class="col-md-8">
					<button id="ajouter" name="ajouter" class="btn btn-primary">Ajouter</button>
				</div>

			</div>

		</fieldset>
		<sec:csrfInput />
	</form>
</body>
</html>