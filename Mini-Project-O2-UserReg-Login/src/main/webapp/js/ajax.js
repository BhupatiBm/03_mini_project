
$(document).ready(function(e) {
	$("#emailId").blur(function(event) {
		$("#dupEmail").html("");
		var emailId = $("#emailId").val();
		$.ajax({
			url : 'verifyEmail?email=' + emailId,
			success : function(abc) {
				if (abc == 'invalid') {
					$("#dupEmail").html("Email already registered");
					$("#emailId").focus();
				}
			}
		});
	});


	$("#countryId").change(function() {
		
		$("#stateId").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#stateId");
		
		$("#cityId").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#cityId");
		
		var countryId = $("#countryId").val();
		$.ajax({
			type : "GET",
			url : "getAllStates?cid=" + countryId,
			success : function(res) {
				$.each(res, function(stateId, stateName) {
					$('<option>').val(stateId).text(stateName).appendTo("#stateId");
				});
			}
		});
	});
	
$("#stateId").change(function() {
		
		$("#cityId").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#cityId");
		
		
		var stateId = $("#stateId").val();
		$.ajax({
			type : "GET",
			url : "getAllCitys?sid=" + stateId,
			success : function(res) {
				$.each(res, function(cityId, cityName) {
					$('<option>').val(cityId).text(cityName).appendTo("#cityId");
				});
			}
		});
});
});