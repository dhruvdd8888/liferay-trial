<%@ include file="init.jsp" %>

<portlet:actionURL name="/submithandle" var="submiturl">
</portlet:actionURL>



	<div id="full-page">
		<h2>Gold Lucky Draw Form</h2>
		<form action = "${submiturl}" method = "post">
			<table>
				<tr>
					<td>
						<label for="name">Name:</label>
					</td>
					<td>
						<input type="text" id="name" name="<portlet:namespace />name" placeholdeer="name" required />
					</td>
					<td rowSpan="8">
						<div id="submitted-data"></div>
					</td>
				</tr>
				<tr>
					<td>
						<label for="number">Number:</label>
					</td>
					<td>
						<input type="tel" id="number" name="<portlet:namespace />number" placeholdeer="number" required />
					</td>
				</tr>
				<tr>
					<td>
						<label for="email">Email:</label>
					</td>
					<td>
						<input type="email" id="email" name="<portlet:namespace />email" placeholdeer="email" required />
					</td>
				</tr>
				<tr>
					<td>
						<label for="dob">Date of Birth:</label>
					</td>
					<td>
						<input type="date" id="dob" name="<portlet:namespace />dob" required />
					</td>
				</tr>
				<tr>
					<td>
						<label for="country">Country:</label>
					</td>
					<td>
						<select id="country" name = "<portlet:namespace />country" onchange="populateStates()">
							<option value="">Select Country</option>
							<option value="india">INDIA</option>
							<option value="usa">USA</option>
							<option value="canada">Canada</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<label for="state">State:</label>
					</td>
					<td>
						<select id="state" name = "<portlet:namespace />state" onchange="populateCities()">
							<option value="">Select State</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<label for="city">City:</label>
					</td>
					<td>

						<select id="city" name = "<portlet:namespace />city">
							<option value="">Select City</option>
						</select>
					</td>
				</tr>
			</table>

			<button type="submit">Submit</button>
		</form>
	</div>
	
	
	
	
	
	<script>
		const countryData = {
			india:{
				states:{
					Gujarat:['Rakjkot', 'Ahmedabad', 'Baroda'],
					Maharashtra: ['Mumbai', 'Nagpur', 'Pune'],
				}
			},
			usa: {
				states: {
					California: ['Los Angeles', 'San Francisco'],
					Texas: ['Houston', 'Dallas'],
				}
			},
			canada: {
				states: {
					Ontario: ['Toronto', 'Ottawa'],
					Quebec: ['Montreal', 'Quebec City'],
				}
			}

		};
		
		function populateStates() {
			const countrySelect = document.getElementById('country');
			const stateSelect = document.getElementById('state');
			const citySelect = document.getElementById('city');

			const selectedCountry = countrySelect.value;

			// Clear existing options
			stateSelect.innerHTML = '<option value="">Select State</option>';
			citySelect.innerHTML = '<option value="">Select City</option>';

			if (selectedCountry && countryData[selectedCountry]) {
				const states = Object.keys(countryData[selectedCountry].states);
				states.forEach(state => {
					const option = document.createElement('option');
					option.value = state;
					option.textContent = state;
					stateSelect.appendChild(option);
				});
			}
		}

		function populateCities() {
			const countrySelect = document.getElementById('country');
			const stateSelect = document.getElementById('state');
			const citySelect = document.getElementById('city');

			const selectedCountry = countrySelect.value;
			const selectedState = stateSelect.value;

			// Clear existing options
			citySelect.innerHTML = '<option value="">Select City</option>';

			if (selectedCountry && selectedState && countryData[selectedCountry].states[selectedState]) {
				const cities = countryData[selectedCountry].states[selectedState];
				cities.forEach(city => {
					const option = document.createElement('option');
					option.value = city;
					option.textContent = city;
					citySelect.appendChild(option);
				});
			}
		}
		
	</script>
	