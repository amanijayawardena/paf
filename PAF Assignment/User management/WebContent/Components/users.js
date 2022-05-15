$(document).ready(function() {
if ($('#alertSuccess').text().trim() == "") {
$('#alertSuccess').hide();
}



$('#alertError').hide();
})



// SAVE
$(document).on("click","#btnSave", function(event) {
// Clear alerts
$("#alertSuccess").text("");
$("#alertSuccess").hide();
$("#alertError").text("");
$("#alertError").hide();



// Form validation
var status = validateUserForm();
if (status != true)
{
$("#alertError").text(status);
$("#alertError").show();
return;
}

// if hideUserIDSave value is null set as POST else set as PUT
var type = ($("#hidUserIDSave").val() == "") ? "POST" : "PUT";



// ajax communication
$.ajax({
url: "User",
type: type,
data: $("#formUser").serialize(),
dataType: "text",
complete: function(response, status) {
onItemSaveComplete(response.responseText, status);
}
});
});



//after completing save request
function onUserSaveComplete(response, status) {



if (status == "success") { //if the response status is success
var resultSet = JSON.parse(response);



if (resultSet.status.trim() === "success") { //if the json status is success
//display success alert
$("#alertSuccess").text("Successfully saved");
$("#alertSuccess").show();

//load data in json to html
$("#divEmployeesGrid").html(resultSet.data);



} else if (resultSet.status.trim() === "error") { //if the json status is error
//display error alert
$("#alertError").text(resultSet.data);
$("#alertError").show();
}
} else if (status == "error") {
//if the response status is error
$("#alertError").text("Error while saving");
$("#alertError").show();
} else {
//if an unknown error occurred
$("#alertError").text("Unknown error occurred while saving");
$("#alertError").show();
}



//resetting the form
$("#hideUserIDSave").val("");
$("#formUser")[0].reset();
}



//UPDATE
//to identify the update button we didn't use an id we used a class
$(document).on("click", ".btnUpdate", function(event)
{
//get User id from the data-userid attribute in update button
$("#hidUserIDSave").val($(this).data('userid'));
//get data from <td> element
$("#username").val($(this).closest("tr").find('td:eq(0)').text());
$("#useraddress").val($(this).closest("tr").find('td:eq(1)').text());
$("#userelectricityaccountnumber").val($(this).closest("tr").find('td:eq(2)').text());

});



//DELETE
$(document).on("click",".btnRemove", function(s) {
// ajax communication
$.ajax({
url: "UserAPI",
type: "DELETE",
data: "userid=" + $(this).data("userid"),
dataType: "text",
complete: function(response, status) {
onUserDeleteComplete(response.responseText, status);
}
});
});



//after completing delete request
function onUserDeleteComplete(response, status) {



if (status == "success") { //if the response status is success
var resultSet = JSON.parse(response);



if (resultSet.status.trim() === "success") { //if the json status is success
//display success alert
$("#alertSuccess").text("Successfully deleted");
$("#alertSuccess").show();

//load data in json to html
$("#divItemsGrid").html(resultSet.data);



} else if (resultSet.status.trim() === "error") { //if the json status is error
//display error alert
$("#alertError").text(resultSet.data);
$("#alertError").show();
}
} else if (status == "error") {
//if the response status is error
$("#alertError").text("Error while deleting");
$("#alertError").show();
} else {
//if an unknown error occurred
$("#alertError").text("Unknown error occurred while deleting");
$("#alertError").show();
}
}



//VALIDATION
function validateUserForm() {
// Name
if ($("#username").val().trim() == "")
{
return "Insert User Name.";
}

// DOB
if ($("#useraddress").val().trim() == "")
{
return "Insert User Address.";
}

// ADDRESS
if ($("#userelectricityaccountnumber").val().trim() == "")
{
return "Insert User Electricity Account Number.";
}

return true;