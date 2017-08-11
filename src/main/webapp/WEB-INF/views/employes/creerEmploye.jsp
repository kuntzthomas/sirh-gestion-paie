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
			<li role="presentations"><a
				href="<c:url value='/mvc/employes/lister'></c:url>">Lister les remunerations</a></li>
			<li role="presentations"><a
				href="<c:url value='/mvc/employes/creer'></c:url>">Ajouter une remuneration</a></li>
			<li role="presentations"><a href="#">Lister les bulletins</a></li>
			<li role="presentations"><a href="#">Créer un bulletin</a></li>
			<li role="presentations"><a href="<c:url value='/mvc/employes/logout'></c:url>">logout</a></li>
		</ul>
	</div>

	<h1 align="center">Ajouter un employé</h1>


	<form class="form-horizontal" method="post" action="">
		<fieldset>


			<!-- Matricule -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Matricule</label>
				<div class="col-md-4">
					<input id="matricule" name="matricule"
						class="form-control input-md" type="text">
				</div>
			</div>

			<!-- Select Entreprise -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="entreprise">Entreprise</label>
				<div class="col-md-4">
					<select id="entreprise" name="entreprise" class="form-control">
						<c:forEach var="entreprise" items="${listEntreprises}">
							<option value="${entreprise.denomination}">${entreprise.denomination}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="profil">Profil</label>
				<div class="col-md-4">
					<select id="profil" name="profil" class="form-control">
						<c:forEach var="profil" items="${listProfils}">
							<option value="${profil.code}">${profil.code}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="grade">Grade</label>
				<div class="col-md-4">
					<select id="grade" name="grade" class="form-control">
						<c:forEach var="grade" items="${listGrades}">
							<option value="${grade.code}">${grade.code}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Button -->
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
