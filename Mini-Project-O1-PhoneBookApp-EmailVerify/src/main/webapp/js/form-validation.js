
$(function() {
	  $("form[name='form']").validate({
		rules: {
			contactName: {
		   required: true
		  },
		  contactEmail: {
			required: true,
			contactEmail: true
		  },
		  contactNumber:{
			required: true,
			min:10
		  }
		},
		messages: {
			contactName: "Please enter your name",
			contactNumber: {
			required: "Please provide your Contact Number",
			length: "Your Contact Number must be contain 10 number"
		  },
		  contactEmail: "Please enter a valid email address"
		},
		submitHandler: function(form) {
		  form.submit();
		}
	  });
	});
