<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value ='/lib/css/bootstrap5.min.css'/>">
<link rel="stylesheet"
	href="<c:url value ='/lib/css/fontawesome.min.css'/>">
<link rel="stylesheet" href="<c:url value ='/lib/css/all.min.css'/>">
<link rel="stylesheet" href="<c:url value ='/lib/css/all.css'/>">
<link rel="stylesheet" href="<c:url value ='/lib/css/err.css'/>">
<%-- <link rel="stylesheet" href="<c:url value ='/lib/css/home.css'/>"> --%>
<link rel="stylesheet"
	href="<c:url value ='/lib/icon/unpkg.com_boxicons@2.1.4_css_boxicons.min.css'/>">
<script
	src="<c:url value="/lib/js/code.jquery.com_jquery-3.7.0.min.js" />"></script>
<script src="<c:url value="/lib/js/main.js" />"></script>
<script src="<c:url value="/lib/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<body>
	<h1>404</h1>
	<div class="cloak__wrapper">
		<div class="cloak__container">
			<div class="cloak"></div>
		</div>
	</div>
	<div class="info">
		<h2>We can't find that page</h2>
		<p>We're fairly sure that page used to be here, but seems to have
			gone missing. We do apologise on it's behalf.</p>
		<a href="/Hoale/">Home</a>
	</div>
</body>

</html>