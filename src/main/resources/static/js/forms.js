// Disabling form submissions if there are invalid fields
function disablingFormSubmissions() {
	'use strict';
	window.addEventListener('load', function() {
		// Fetch all the forms we want to apply custom Bootstrap validation
		// styles to
		var forms = document.getElementsByClassName('needs-validation');
		// Loop over them and prevent submission
		var validation = Array.prototype.filter.call(forms, function(form) {
			form.addEventListener('submit', function(event) {
				if (form.checkValidity() === false) {
					event.preventDefault();
					event.stopPropagation();

					var errorElements = document
							.querySelectorAll(".form-control:invalid");
					errorElements.forEach(function(element) {
						element.parentNode.childNodes.forEach(function(node) {
							if (node.className == 'valid-feedback') {
								node.className = 'invalid-feedback';
								node.innerText = 'Please choose a Gender';
							}
						});
					});
					$('html, body').animate({
						scrollTop : $(errorElements[0]).offset().top - 70
					}, 1000);
				}
				form.classList.add('was-validated');
			}, false);
		});
	}, false);
}
