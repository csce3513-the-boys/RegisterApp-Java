document.getElementById("button1").addEventListener("click", startTransaction);
document.getElementById("button2").addEventListener("click", viewProducts);
document.getElementById("button3").addEventListener("click", createEmployee);
document.getElementById("button4").addEventListener("click", salesReport);
document.getElementById("button5").addEventListener("click", cashierReport);
document.getElementById("signOut").addEventListener("click", signOut);

var employeeRequest = newXMLHttpRequest();

function startTransaction()
{
    displayError("Functionality has not been implemented");
}

function viewProducts()
{
    window.location = "productListing.html";
}

function createEmployee()
{
    window.location = "employeeDetail.html";
}

function salesReport()
{
    displayError("Functionality has not been implemented");
}

function cashierReport()
{
    displayError("Functionality has not been implemented");
}

function signOut()
{
    employeeRequest.ajaxDelete();
}