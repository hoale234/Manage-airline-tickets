var idCtNum = $("#idCtNumber");
var idSheet = $("#idSheet");
var idActual = $("#idActual");
var idRules = $("#idRules");
var idCtName = $("#idCtName");
var idFares = $("#idFares");
var idRtRecords = $("#idRtRecords");
var idToRecords = $("#idToRecords");
var idDateRecei = $("#idDateRecei");
var idDateDis = $("#idDateDis");
var idDateEffec = $("#idDateEffec");
var idDateCla = $("#idDateCla");
var idDateQueuEnd = $("#idDateQueuEnd");
var idDateQueuStart = $("#idDateQueuStart");
var idAirline = $("#idAirline");
var idImportant = $("#idImportant");
var idRegion = $("#idRegion");
var idMarket = $("#idMarket");
var idPriority = $("#idPriority");
var idFare = $("#idFare");





function checkCtName(contractName) {
  var flag = true;
  const alphanumericRegex = /^[a-zA-Z0-9 ]+$/;
  if (contractName.length === 0) {
    showMessageCtName("Contract Name must be entered.");
    flag = false;
  } else if (contractName.length > 100) {
    showMessageCtName("Contract number cannot exceed 100 characters.");
    flag = false;
  } else if (!alphanumericRegex.test(contractName)) {
    showMessageCtName("Can only enter letters or numbers");
    flag = false;
  } else {
    showMessageCtName("");
    var flag = true;
    // Do something with the valid contract name here
  }
  return flag;
}
function checkAirline(airline) {
  var flag = true;
  if (airline.length === 0) {
    showMessageAirline("Airline must be entered.");
    flag = false;
  }
  return flag;
}
function checkMarket(market) {
  var flag = true;
  if (market.length === 0) {
    showMessageMarket("Market must be entered.");
    flag = false;
  }
  return flag;
}
function checkImportant(important) {
  var flag = true;
  if (important.length === 0) {
    showMessageImportant("Important must be entered.");
    flag = false;
  }
  return flag;
}
function checkRegion(region) {
  var flag = true;
  if (region.length === 0) {
    showMessageRegion("Region must be entered.");
    flag = false;
  }
  return flag;
}
function checkPriority(priority) {
  var flag = true;
  if (priority.length === 0) {
    showMessagePriority("Priority must be entered.");
    flag = false;
  }
  return flag;
}
function checkFare(fare) {
  var flag = true;
  if (fare.length === 0) {
    showMessageFare("Fare Type must be entered.");
    flag = false;
  }
  return flag;
}
function checkSheet(idSheet) {
  var flag = true;
  const numberRegex = /^[0-9]+$/;
  if (idSheet.length === 0) {
    showMessageSheet("Number of Fare Sheets must be entered.");
    flag = false;
  } else if (idSheet.test(numberRegex) && idSheet > 0) {
    showMessageSheet("Number of Fare Sheets must be a number and > 0.");
    flag = false;
  }
  return flag;
}

function showMessageCtNumber(message) {
  const validationMessage = $("#messageErrorCtNumber");
  validationMessage.text(message);
}
function showMessageCtName(message) {
  const validationMessage = $("#messageErrorCtName");
  validationMessage.text(message);
}

function showMessageMarket(message) {
  const validationMessage = $("#messageErrorMarket");
  validationMessage.text(message);
}
function showMessageImportant(message) {
  const validationMessage = $("#messageErrorImportant");
  validationMessage.text(message);
}
function showMessageRegion(message) {
  const validationMessage = $("#messageErrorRegion");
  validationMessage.text(message);
}
function showMessagePriority(message) {
  const validationMessage = $("#messageErrorPriority");
  validationMessage.text(message);
}
function showMessageFare(message) {
  const validationMessage = $("#messageErrorFare");
  validationMessage.text(message);
}
function showMessageSheet(message) {
  const validationMessage = $("#messageErrorSheet");
  validationMessage.text(message);
}
