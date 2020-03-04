window.addEventListener('DOMContentLoaded', () => 
{

    document.getElementById("start").addEventListener("click", 
    function()
    {
        displayError("Functionality not implemented");
    });

    document.getElementById("view").addEventListener("click",
    function()
    {
        window.location.replace("productListing.html");
    });

    document.getElementById("create").addEventListener("click",
    function()
    {
        window.location.replace("employeeDetail.html")
    });

    document.getElementById("sales").addEventListener("click", 
    function()
    {
        displayError("Functionality not implemented");
    });

    document.getElementById("cashier").addEventListener("click", 
    function()
    {
        displayError("Functionality not implemented");
    });

    document.getElementById("signOut").addEventListener("click", signOutActionClickHandler());
});