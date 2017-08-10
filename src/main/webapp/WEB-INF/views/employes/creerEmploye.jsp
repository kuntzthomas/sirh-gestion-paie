<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	<h1 align="center">Ajouter un employé</h1>


	<form class="form-horizontal">
		<fieldset>


			<!-- Text input-->
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
							<option value="${entreprise.id}">${entreprise.denomination}</option>
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
							<option value="${profil.id}">${profil.code}</option>
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
							<option value="${grade.id}">${grade.code}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<div class="col-md-4">
					<button id="ajouter" name="ajouter" class="btn btn-primary">Ajouter</button>
				</div>
			</div>

		</fieldset>
	</form>

</body>
</html>
