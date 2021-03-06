<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ex_Biblio</title>
</head>
<body>
	<h1>Gestion de bibliotheque</h1>
	<br />
	<br />
	<br />
	<h2>Liste auteurs</h2>
	<c:set var="auteurs" value="${requestScope['LISTE_AUTEURS']}" />

	<c:if test="${fn:length(auteurs) > 1}">
		<c:forEach var="a" items="${auteurs}">

			<c:out value="${a.nom}" />
			<c:out value="${a.prenom}" />
			<a
				href="${pageContext.request.contextPath}/do/delAuteur?ID=${a.id}&DELETE=true"><button>Delete</button></a>&nbsp;
		<br>
		</c:forEach>
	</c:if>
	<br />
	<br />
	<br />
	<br />
	<br />

	<form action="${pageContext.request.contextPath}/do/newAuteur"
		method="post">
		<fieldset>
			<legend>
				<b>Ajout d'un nouvel auteur</b>
			</legend>
			<label>Nom</label> <input name="AUTEUR_NOM" type="text" size="25"
				maxlength="40" /> <br /> <label>Prenom</label> <input
				name="AUTEUR_PRENOM" type="text" size="25" maxlength="40" /> <br />
			<button>ajouter</button>
		</fieldset>
	</form>
	<br />
	<a href="${pageContext.request.contextPath}/Index.jsp">index</a>


</body>
</html>