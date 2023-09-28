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

</head>
<body>
	<div class="container-fluid">
		<div class="input_update">
			<div class="form_update" style="width: 65%">
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
						Update Unassigned Contracts...</div>
				</div>
				<div class="main">
					<form:form
						action="${pageContext.request.contextPath}/updateSubContract?id=${getUpdate.contractId}"
						method="post" class="border" modelAttribute="getUpdate">
						<div class="flex-cls" style="display: flex;">
							<div class="input_left">
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Contract Number<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 60%;">
										<form:input id="idCtNumber" path="contractNumber" type="text"
											class="form-control" placeholder="Contract Number"
											maxlength="20" />
										<form:errors path="contractNumber"
											cssClass="error text-danger" />
										<span id="messageErrorCtNumber"
											style="font-size: 12px; font-weight: 100; color: red; height: 10px;"></span>
									</div>
								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Airline Code<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 70%;">
										<form:select path="airline.airlineCode" id="idAirline"
											class="form-select" aria-label="Default select example">
											<c:forEach var="ari" items="${getListAir}" varStatus="status">
												<form:option value="${ari.airlineCode}">${ari.airlineName}</form:option>
											</c:forEach>
										</form:select>
									</div>

								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Important Level<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 30%;">
										<form:select path="importantLevel" class="form-select"
											aria-label="Default select example" disabled="true">
											<form:option value="${getUpdate.importantLevel}"></form:option>
										</form:select>
									</div>

								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Region<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 60%;">
										<form:select path="region.regionCode" id="idRegion"
											class="form-select" aria-label="Default select example">
											<c:forEach var="regi" items="${getListRegi}"
												varStatus="status">
												<form:option value="${regi.regionCode}">${regi.regionName}</form:option>
											</c:forEach>
										</form:select>
									</div>

								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Date Received<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 65%; height: 50px;">
										<form:input path="dateReceived" id="idDateRecei" type="Date"
											class="form-control" style="width: 60%;" />
										<form:errors path="dateReceived" cssClass="error text-danger" />
										<span id="messageErrorRecei"
											style="font-size: 12px; font-weight: 100; color: red; height: 10px;"></span>
									</div>

								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Discontinue Date<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 65%; height: 50px;">
										<form:input id="idDateDis" path="discontinueDate" type="Date"
											class="form-control" style="width: 60%;" />
										<form:errors path="discontinueDate"
											cssClass="error text-danger" />
										<span id="messageErrorDateDis"
											style="font-size: 12px; font-weight: 100; color: red; height: 10px;"></span>
									</div>
								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Number of Fare Sheets<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 55%;">
										<form:input path="numberOfFareSheets" id="idSheet"
											style="width: 30%" type="number" class="form-control" />
										<form:errors path="numberOfFareSheets"
											cssClass="error text-danger" />
										<span id="messageErrorSheet"
											style="font-size: 12px; font-weight: 100; color: red; height: 10px;"></span>
									</div>

								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Rtgs Actual<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 55%;">
										<form:input path="rtgsActual" id="idActual" style="width: 30%"
											type="number" class="form-control" />
										<form:errors path="rtgsActual" cssClass="error text-danger" />
										<span id="messageErrorActual"
											style="font-size: 12px; font-weight: 100; color: red; height: 10px;"></span>
									</div>
								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Number of Rules<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 55%;">
										<form:input path="numberOfRules" id="idRules"
											style="width: 30%" type="number" class="form-control" />
										<form:errors path="numberOfRules" cssClass="error text-danger" />
										<span id="messageErrorRules"
											style="font-size: 12px; font-weight: 100; color: red; height: 10px;"></span>
									</div>
								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Queuing Start Date<span
										style="color: red;">*</span> :
									</label>
									<form:input path="queuingStartDate" id="idDateQueuStart"
										type="date" class="form-control" style="width: 39%; height: 40px; background-color: #e9ecef;
  											opacity: 1; pointer-events: none;"/>
								</div>
							</div>
							<div class="input_right">
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Contract Name<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 50%;">
										<form:input path="contractName" id="idCtName" type="text"
											class="form-control" placeholder="Contract Name"
											value="${contractName}" />
										<form:errors path="contractName" cssClass="error text-danger" />
										<span id="messageErrorCtName"
											style="font-size: 12px; font-weight: 100; color: red; height: 10px;"></span>
									</div>
								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Market<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 60%;">
										<form:select path="market.countryCode" id="idMarket"
											class="form-select" aria-label="Default select example">
											<c:forEach var="mar" items="${getListCon}" varStatus="status">
												<form:option value="${mar.countryCode}">${mar.countryName}</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Project/Contract Priority<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 50%;">
										<form:select path="priority.priorityCode" id="idPriority"
											class="form-select" aria-label="Default select example">
											<c:forEach var="pri" items="${getListPri}" varStatus="status">
												<form:option value="${pri.priorityCode}">${pri.priorityName}</form:option>
											</c:forEach>
										</form:select>
									</div>

								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Fare Type<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 50%;">
										<form:select path="fareType.fareTypeCode" id="idFare"
											class="form-select" aria-label="Default select example">
											<c:forEach var="fare" items="${getListFare}"
												varStatus="status">
												<form:option value="${fare.fareTypeCode}">${fare.fareTypeName}</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Effective Date<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 50%; height: 50px;">
										<form:input path="effectiveDate" id="idDateEffec" type="date"
											class="form-control" style="width: 65%;" />
										<form:errors path="effectiveDate" cssClass="error text-danger" />
										<span id="messageErrorEffec"
											style="font-size: 12px; font-weight: 100; color: red; height: 10px;"></span>
									</div>
								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Date Clarification Cleared<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 50%; height: 50px;">
										<form:input path="dateClarificationCleared" id="idDateCla"
											type="date" class="form-control" style="width: 65%;" />
										<form:errors path="dateClarificationCleared"
											cssClass="error text-danger" />
										<span id="messageErrorDateCla"
											style="font-size: 12px; font-weight: 100; color: red; height: 10px;"></span>
									</div>
								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Number of Fares<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 48%; height: 50px;">
										<form:input path="numberOfFares" style="width: 30%"
											id="idFares" type="number" class="form-control" />
										<form:errors path="numberOfFares" cssClass="error text-danger" />
										<span id="messageErrorFares"
											style="font-size: 12px; font-weight: 100; color: red; height: 10px;"></span>
									</div>

								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Rtgs Records<span
										style="color: red;">*</span> :
									</label>
									<div class="input_group" style="width: 48%; height: 50px;">
										<form:input path="rtgsRecords" id="idRtRecords" type="number"
											class="form-control" style="width: 30%" />
										<form:errors path="rtgsRecords" cssClass="error text-danger" />
										<span id="messageErrorRtRecords"
											style="font-size: 12px; font-weight: 100; color: red; height: 10px;"></span>
									</div>
								</div>
								<div class="mb-3">
									<label class="form-label" style="margin: 0.5rem 0px;">Total Records<span
										style="color: red;">*</span> :
									</label>
									<form:input path="totalRecords" id="idTotalRecords" type="text"
										class="form-control" disabled="true" style="width: 14%; height: 40px;" />
								</div>
								<div class="mb-3">
									<label class="form-label"  style="margin: 0.5rem 0px;">Queuing End Date :</label> <input
										value="${exp.dateExpected}" id="idDateQueuEnd"
										type="date" class="form-control" style="width: 32%; height: 40px; background-color: #e9ecef;
  											opacity: 1; pointer-events: none;"/>
								</div>

							</div>
						</div>
						<div class="btn">
							<button type="reset" id="clear"
								class="button-design d-flex justify-content-center align-items-center">Clear</button>
							<button type="submit" id="update"
								class="button-design d-flex justify-content-center align-items-center">Update</button>
							<a href="${pageContext.request.contextPath}" style="text-decoration: none;">
								<button type="button"
									class="button-design d-flex justify-content-center align-items-center">Cancel
								</button>
							</a>
						</div>
					</form:form>
				</div>
			</div>

		</div>
	</div>

	<script
		src="<c:url value="/lib/js/code.jquery.com_jquery-3.7.0.min.js" />"></script>
	<script src="<c:url value="/lib/js/bootstrap.min.js" />"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

	<script type="text/javascript">
	var updateBtn = $("#update");
	updateBtn.on("click", function(event) {
		const idCtNum = $("#idCtNumber").val().trim();
		const idCtName = $("#idCtName").val().trim();
		const idDateRecei = $("#idDateRecei").val().trim();
		const idDateDis = $("#idDateDis").val().trim();
		const idDateEffec = $("#idDateEffec").val().trim();
		const idDateCla = $("#idDateCla").val().trim();
		const idSheet = $("#idSheet").val().trim();
		const idFares = $("#idFares").val().trim();
		const idActual = $("#idActual").val().trim();
		const idRtRecords = $("#idRtRecords").val().trim();
		const idRules = $("#idRules").val().trim();
		
		const dateDateRecei = new Date($("#idDateRecei").val());
		const dateDateCla = new Date($("#idDateCla").val());
		
		const dateDateEffec = new Date($("#idDateEffec").val());
		const dateDateDis = new Date($("#idDateDis").val());


		
		const containsLetterAndDigit = /^(?=.*[a-zA-Z])(?=.*\d).+$/;
		const alphanumericRegex = /^[a-zA-Z0-9 ]+$/;
		const numberRegex = /^\d+$/;
		// Lấy năm hiện tại từ đối tượng Date
		const currentDate = new Date();
		const currentYear = currentDate.getFullYear();
		
//---------------------------------------------------------------------------------------


		// Validate Contract Number
		if (idCtNum.length === 0) {
			event.preventDefault();
			showMessageCtNumber("Contract Number must be entered.")
		} else if (idCtNum.length > 20) {
			event.preventDefault();
		    showMessageCtNumber("Contract number cannot exceed 20 characters.");
		} else if (!alphanumericRegex.test(idCtNum)) {
			event.preventDefault();
		    showMessageCtNumber("Contract Number must be in the format of alpha numeric.")
		} else {
			showMessageCtNumber("");
		}
		
		// Validate Contract Name
		if (idCtName.length === 0) {
			event.preventDefault();
			showMessageCtName("Contract Name must be entered.")
		} else if (idCtName.length > 100) {
			event.preventDefault();
		    showMessageCtName("Contract number cannot exceed 100 characters.");
		} else if (!alphanumericRegex.test(idCtName)) {
			event.preventDefault();
		    showMessageCtName("Can only enter letters or numbers.");
		} else {
			showMessageCtName("");
		}
		//Validate Received
  		if (idDateRecei === "") {
  			event.preventDefault();
  			showMessageRecei("Date Received must be entered.");
    	} else {
    		showMessageRecei("");
		}
		//Validate Discontinue
  		if (idDateDis === "") {
  			event.preventDefault();
  			showMessageDateDis("Discontinue Date must be entered.");
    	} else if (dateDateDis <= dateDateEffec) {
  			event.preventDefault();
  			showMessageDateDis("Discontinue Date must be later than or equals to Effective date");
    	} else if (dateDateDis <= dateDateCla) {
  			event.preventDefault();
  			showMessageDateDis("Discontinue Date must be later than or equals to Date Clarification");
    	} else {
    		showMessageDateDis("");
		}
		//Validate Effective Date
  		if (idDateEffec === "") {
  			event.preventDefault();
  			showMessageEffec("Effective Date must be entered.");
    	} else {
    		showMessageEffec("");
		}
		//Validate Date Clarification Cleared
  		if (idDateCla === "") {
  			event.preventDefault();
  			showMessageDateCla("Date Clarification Cleared must be entered.");
    	} else if (dateDateCla <= dateDateRecei) {
  			event.preventDefault();
  			showMessageDateCla("Date Clarification must be later or equals to Date Received");
    	} else {
    		showMessageDateCla("");
		}
		//Validate Number of Fare Sheets
  		if (idSheet === "") {
  			event.preventDefault();
  			showMessageSheet("Number of Fare Sheets must be entered.");
    	} else if (idSheet.length > 3) {
  			event.preventDefault();
  			showMessageSheet("Number of Fares must be a Maximum length is 3 digits");
    	} else if (!numberRegex.test(idSheet) || parseInt(idSheet) <= 0) {
    		event.preventDefault();
    	    showMessageSheet("Number of Fare Sheets must be a number and > 0.");
    	} else {
    		showMessageSheet("");
		}
		//Validate Number of Fares
  		if (idFares === "") {
  			event.preventDefault();
  			showMessageFares("Number of Fares must be entered.");
    	} else if (idFares.length > 5) {
  			event.preventDefault();
  			showMessageFares("Number of Fares must be a Maximum length is 5 digits.");
    	} else if (!numberRegex.test(idFares) || parseInt(idFares) <= 0) {
    		event.preventDefault();
    		showMessageFares("Number of Fares must be a number and > 0.");
    	} else {
    		showMessageFares("");
		}
		//Validate Rtgs Actual
  		if (idActual === "") {
  			event.preventDefault();
  			showMessageActual("Rtgs Actual must be entered.");
    	} else if (idActual.length > 5) {
  			event.preventDefault();
  			showMessageActual("Rtgs Actual must be a Maximum length is 5 digits");
    	} else if (!numberRegex.test(idActual) || parseInt(idActual) <= 0) {
    		event.preventDefault();
    		showMessageActual("Rtgs Actual must be a number and > 0.");
    	} else {
    		showMessageActual("");
		}
		//Validate Rtgs Records
  		if (idRtRecords === "") {
  			event.preventDefault();
  			showMessageRtRecords("Rtgs Records must be entered.");
    	} else if (idRtRecords.length > 5) {
  			event.preventDefault();
  			showMessageRtRecords("Rtgs Records must be a Maximum length is 5 digits");
    	} else if (!numberRegex.test(idRtRecords) || parseInt(idRtRecords) <= 0) {
    		event.preventDefault();
    		showMessageRtRecords("Rtgs Records must be a number and > 0.");
    	} else {
    		showMessageRtRecords("");
		}
		//Validate Number of Rules
  		if (idRules === "") {
  			event.preventDefault();
  			showMessageRules("Number of Rules must be entered.");
    	} else if (idRules.length > 3) {
  			event.preventDefault();
  			showMessageRules("Number of Rules must be a Maximum length is 3 digits");
    	} else if (!numberRegex.test(idRules) || parseInt(idRules) <= 0) {
    		event.preventDefault();
    		showMessageRules("Number of Rules must be a number and > 0.");
    	} else {
    		showMessageRules("");
		}
  		
	});
  		

		const idFaresInput = document.getElementById("idFares");
		const idRtRecordsInput = document.getElementById("idRtRecords");
		const idRulesInput = document.getElementById("idRules");
		const idTotalRecordsInput = document.getElementById("idTotalRecords");

		const idDateClaInput = document.getElementById("idDateCla");
		const idDateQueuStartInput = document.getElementById("idDateQueuStart");
		const idDateQueuEndInput = document.getElementById("idDateQueuEnd");

	
		[idFaresInput, idRtRecordsInput, idRulesInput].forEach(input => {
		    input.addEventListener("input", function () {
		      // Lấy giá trị từ các ô input khác và tính toán tổng
		      const fares = parseInt(idFaresInput.value) || 0;
		      const rtRecords = parseInt(idRtRecordsInput.value) || 0;
		      const rules = parseInt(idRulesInput.value) || 0;
		      const total = fares + rtRecords + rules;
	
		      // Gán giá trị tổng vào ô input tổng
		      idTotalRecordsInput.value = total;
		    });
		});
		
		idDateClaInput.addEventListener("input", function () {
		    idDateQueuStartInput.value = idDateClaInput.value;
		});
		idDateClaInput.addEventListener("input", function () {
		    idDateQueuStartInput.value = idDateClaInput.value;
		});
	
		
		function showMessageCtNumber(message) {
		  const validationMessage = $("#messageErrorCtNumber");
		  validationMessage.text(message);
			}
		function showMessageCtName(message) {
		  const validationMessage = $("#messageErrorCtName");
		  validationMessage.text(message);
		}
		function showMessageRecei(message) {
		  const validationMessage = $("#messageErrorRecei");
		  validationMessage.text(message);
		}
		function showMessageDateDis(message) {
		  const validationMessage = $("#messageErrorDateDis");
		  validationMessage.text(message);
		}
		function showMessageEffec(message) {
		  const validationMessage = $("#messageErrorEffec");
		  validationMessage.text(message);
		}
		function showMessageDateCla(message) {
		  const validationMessage = $("#messageErrorDateCla");
		  validationMessage.text(message);
		}
		function showMessageSheet(message) {
		  const validationMessage = $("#messageErrorSheet");
		  validationMessage.text(message);
		}
		function showMessageFares(message) {
		  const validationMessage = $("#messageErrorFares");
		  validationMessage.text(message);
		}
		function showMessageActual(message) {
		  const validationMessage = $("#messageErrorActual");
		  validationMessage.text(message);
		}
		function showMessageRtRecords(message) {
		  const validationMessage = $("#messageErrorRtRecords");
		  validationMessage.text(message);
		}
		function showMessageRules(message) {
		  const validationMessage = $("#messageErrorRules");
		  validationMessage.text(message);
		}
			
		$("#clear").click(function () {
            $("#messageErrorCtNumber").text("");
            $("#messageErrorCtName").text("");
            $("#messageErrorRecei").text("");
            $("#messageErrorDateDis").text("");
            $("#messageErrorEffec").text("");
            $("#messageErrorDateCla").text("");
            $("#messageErrorSheet").text("");
            $("#messageErrorFares").text("");
            $("#messageErrorActual").text("");
            $("#messageErrorRtRecords").text("");
            $("#messageErrorRules").text("");
        });
	</script>
</body>
</html>