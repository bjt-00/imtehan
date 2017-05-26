$(document).ready(function(){
	
    $("button").click(function(){
    	$("#inhtml").html("js called");
        $.get("questionForm.jsp", function(data, status){
        	$("#inhtml").html(data);
            //alert("Data: " + data + "\nStatus: " + status);
        });
    });
    
    
});