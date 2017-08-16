<%@page import="java.time.ZonedDateTime"%>
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
			<li><a href="#">Créer un bulletin</a></li>
			<li><a href="<c:url value='/mvc/employes/logout'></c:url>">logout</a></li>
		</ul>
	</div>
	
	<h1 align="center">Liste des bulletins</h1>
	
	<!--  Liste des bulletins  -->
	<table border='2'>
		<thead>
			<tr>
				<th style="text-align: center;">Date et heure de création</th>
				<th style="text-align: center;">Periode</th>
				<th style="text-align: center;">Matricule</th>
				<th style="text-align: center;">Salaire brut</th>
				<th style="text-align: center;">Net imposable</th>
				<th style="text-align: center;">Net à payer</th>
				<th style="text-align: center;">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="Bulletin" items="${listBulletin}">
				<tr>
					<td style="text-align: center;">${Bulletin.dateCreation}</td>
					<td style="text-align: center;">${Bulletin.periode}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!--  Fin Liste des bulletins  -->
</body>
</html>