  
let hideEmployeeSavedAlertTimer = undefined;

document.addEventListener("DOMContentLoaded", () => 
{
    // TODO: Things that need doing when the view is loaded
    //validate();
    document.getElementById("saveButton").addEventListener("click", saveActionClick);     
});

function validate()
{
    let first = getFirstName();
    let last = getLastName();
    let password = getPassword();
    let confirm = getConfirmPassword();
    let employee = getEmployeeType();

    if(first == null)
    {
        displayError("First name is blank");
        return false;
    }

    if(last == null)
    {
        displayError("First name is blank");
        return false;
    }

    if(password == null)
    {
        displayError("First name is blank");
        return false;
    }

    if(confirm != password)
    {
        displayError("");
        return false;
    }

    if(employee != "cashier" || employee != "shiftManager" || employee != "generalManager")
    {
        displayError("Use valid employee type");
        return false;
    }

    return true;
}
// Save
function saveActionClick(event) {
    // TODO: Actually save the employee via an AJAX call
    var validEmployee = validate();
    if(validEmployee == false)
    {
        return;
    }
    else
    {
        displayEmployeeSavedAlertModal();
    }
}

function displayEmployeeSavedAlertModal() {
	if (hideEmployeeSavedAlertTimer) {
		clearTimeout(hideEmployeeSavedAlertTimer);
	}

	const savedAlertModalElement = getSavedAlertModalElement();
	savedAlertModalElement.style.display = "none";
	savedAlertModalElement.style.display = "block";

	hideEmployeeSavedAlertTimer = setTimeout(hideEmployeeSavedAlertModal, 1200);
}

function hideEmployeeSavedAlertModal() {
	if (hideEmployeeSavedAlertTimer) {
		clearTimeout(hideEmployeeSavedAlertTimer);
	}

	getSavedAlertModalElement().style.display = "none";
}
// End save

//Getters and setters

function getFirstName()
{
    return document.getElementById("firstName");
}

function getLastName()
{
    return document.getElementById("lastName");
}

function getPassword()
{
    return document.getElementById("password");
}

function getConfirmPassword()
{
    return document.getElementById("confirmPassword");
}

function getEmployeeType()
{
    return document.getElementsByName("employeeType");
}

function getSavedAlertModalElement() {
	return document.getElementsById("employeeSavedAlertModal");
}
//End getters and setters