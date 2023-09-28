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
<link rel="stylesheet" href="<c:url value ='/lib/css/home.css'/>">
<link rel="stylesheet"
	href="<c:url value ='/lib/icon/unpkg.com_boxicons@2.1.4_css_boxicons.min.css'/>">
<style type="text/css">
.message-out{
    display: flex;
    height: 100px;
    width: 300px;
    top: 3%;
    left: 40%;
    background-color: #adadadda;
    color: #994d4d;
    border-radius: 7px;
    align-items: center;
    justify-content: center;
}

.message-in{
    display: flex;
    height: 100%;
    width: 100%;
    border: 1px solid #eeebeb;
    border-radius: 5px;
    align-items: center;
    justify-content: center;
}
</style>
</head>
<body>
	<div class="container-fluid position-relative">
		<div class="input_update">
			<div class="form_update">
				<div class="header">
					<div class="close-button "
						style="padding: 5px; border: black solid 1px; width: 35px; border-radius: 7px; background-color: white; margin-left: 25px; height: 35px;">
						<div
							class="h-100 w-100 d-flex justify-content-center align-items-center"
							style="background-image: linear-gradient(rgba(129, 190, 236, 1), rgba(80, 130, 167, 1)); box-shadow: 0px 1px 4px 1px; text-align: center;">
							<i class="fa-solid fa-minus" style="color: #ffffff;"></i>
						</div>
					</div>
					<div class="header-text col-10 d-flex align-items-center"
						style="color: rgba(37, 113, 148, 1); font-size: 24px; font-weight: 600; margin-left: 10px;">
						Screen List Unassigned Contracts...</div>
				</div>
				<div class="main">
					<div class="border">
						<div class="flex-cls"
							style="display: flex; justify-content: center; align-items: center;">
							<div class="list_data_update" style="width: 100%">
								<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">Contract Number</th>
											<th scope="col">Contract Name</th>
											<th scope="col">Airline</th>
											<th scope="col">Market</th>
											<th scope="col">Priority</th>
											<th scope="col">Queuing Start Date</th>
											<th scope="col">Queuing End Date</th>
											<th scope="col">Update</th>
											<th scope="col">Delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="list" items="${listContract}">
											<tr>
												<th>${list.contractNumber}</th>
												<td>${list.contractName}</td>
												<td>${list.airline.airlineName}</td>
												<td>${list.market.countryName}</td>
												<td>${list.priority.priorityName}</td>
												<td>${list.queuingStartDate}</td>
												<td>${list.queuingEndDate}</td>
												<td><a
													href="${pageContext.request.contextPath}/updateContract?id=${list.contractId}"><i
														class="fa-regular fa-pen-to-square"
														style="color: #0000ff;"></i></a></td>
												<td><a
													href="${pageContext.request.contextPath}/deleteLop"><i
														class="fa-regular fa-trash-can" style="color: #ff0000;"></i></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<c:if test="${not empty message}">
		<div class="position-absolute message-out" id="alertSuccess">
			<div class="message-in">
                ${message}
			</div>
		</div>
	</c:if>
	<script
		src="<c:url value="/lib/js/code.jquery.com_jquery-3.7.0.min.js" />"></script>
	<script src="<c:url value="/lib/js/update.js" />"></script>
	<script src="<c:url value="/lib/js/bootstrap.min.js" />"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		var alertSuccess = document.getElementById("alertSuccess");
		setTimeout(function() {
			alertSuccess.style.display = "none";
		}, 4000);
	</script>
</body>

</html>