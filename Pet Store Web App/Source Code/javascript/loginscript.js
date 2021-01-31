/**
 * 
 */
$(document).ready(function(){
	$("#login").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		
		if (username=='') {
			//TODO make text red
		}
		if (password == '') {
			//TODO make text red
		}
		if (username != '' && password != '') {
			//TODO login with ajax
			$.ajax({
				url : "loginservice",
				method : 'GET',
				data : {
					username : username,
					password : password
				},
				success : function(results) {
					if (results != null && results != "") {
						var resultsData = results.data;
						if (resultsData == null) {
							alert("Error attempting to login. Please try again.");
						} else {
							window.location.replace("http://localhost:8080/pos?user="+resultsData);
						}
					} else {
						//TODO display incorrect user
					}
				}
			})
		}
	})
	
})