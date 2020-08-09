
$(function() {
	  $("form[name='form']").validate({
		rules: {
			name: {
		   required: true
		  },
		  email: {
			required: true,
			email: true
		  },
		 number:{
			required: true,
			min:10
		  }
		},
		messages: {
		  name: "Please enter your name",
		  number: {
			required: "Please provide your Contact Number",
			length: "Your Contact Number must be contain 10 number"
		  },
		  email: "Please enter a valid email address"
		},
		submitHandler: function(form) {
		  form.submit();
		}
	  });
	});
