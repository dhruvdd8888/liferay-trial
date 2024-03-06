<%@ include file="init.jsp" %>

<portlet:resourceURL id="/get-country-states-city" var="getCountryStatesCityURL" />

<portlet:actionURL name="/signup" var="signup_action" />

 <head>
 	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<form action="${signup_action}" method="post">
    <div class="form-group">
        <label class="" for="username">Username</label>
        <input id="username" placeholder="Enter Username" class="form-control" type="text"
            name="<portlet:namespace/>username" value="">
    </div>

    <div class="form-group">
        <label class="" for="mobile">Mobile</label>
        <input id="mobile" placeholder="Enter Mobile" class="form-control" type="text"
            name="<portlet:namespace/>mobile" value="">
    </div>

    <div class="form-group">
        <label class="" for="email">EMail</label>
        <input id="email" placeholder="Enter EMail" class="form-control" type="text"
            name="<portlet:namespace/>email" value="">
    </div>
	<div class="form-group">
		<label class="" for="country">Country</label> <select aria-label="Label"
			id="countryselect" name="<portlet:namespace/>country" class="form-control">
			<option value="">Select Country</option>
			<c:forEach var="element" items="${countries}">
				<option value="${element}">${element}</option>
			</c:forEach>
		</select>
	</div>



    <div class="form-group">
        <label class="" for="state">State</label> 
        <select aria-label="Label" id="stateselect"
            name="<portlet:namespace/>state" class="form-control">
            <option value="">Select state</option>
        </select>
    </div>

    <div class="form-group">
        <label class="" for="city">City</label> 
        <select aria-label="Label" id="cityselect"
            name="<portlet:namespace/>city" class="form-control">
            <option value="">Select city</option>
        </select>
    </div>

    <div class="form-group">
        <button class="btn btn-primary" type="submit">Submit</button>
    </div>

</form>

<script>
$( document ).ready(function() {
    $('#countryselect').on('change', function(){
    	$.ajax({
		    url : '${getCountryStatesCityURL}',
		    type: "POST",
		    data : {
                '<portlet:namespace/>requestFrom':'country',
		    	'<portlet:namespace/>country':$(this).val()
		    },
		    success: function(response, textStatus, jqXHR){
		    	if(response){
		    		const resObj = JSON.parse(response);
		    		if(resObj.status == 'success'){
		    			const states = resObj.data;
		    			var cityEle = $('#cityselect').empty();
                        cityEle.append( '<option value="Select City">Select City</option>' ); 
			            
		    			var stateEle = $('#stateselect').empty();
                        stateEle.append( '<option value="Select State">Select State</option>' ); 
			            $.each(states, function(i,item) {
			            	stateEle.append( '<option value="'
			                                     + item
			                                     + '">'
			                                     + item
			                                     + '</option>' ); 
			            });
		    		}
		    	}
			},
			error: function (jqXHR, textStatus, errorThrown){
			}
		});
    });




    $('#stateselect').on('change', function(){
    	$.ajax({
		    url : '${getCountryStatesCityURL}',
		    type: "POST",
		    data : {
                '<portlet:namespace/>requestFrom':'state',
		    	'<portlet:namespace/>state':$(this).val()
		    },
		    success: function(response, textStatus, jqXHR){
		    	if(response){
		    		const resObj = JSON.parse(response);
		    		if(resObj.status == 'success'){
		    			const city = resObj.data;
		    			var cityEle = $('#cityselect').empty();
                        cityEle.append( '<option value="Select City">Select City</option>' ); 
			            $.each(city, function(i,item) {
			            	cityEle.append( '<option value="'
			                                     + item
			                                     + '">'
			                                     + item
			                                     + '</option>' ); 
			            });
		    		}
		    	}
			},
			error: function (jqXHR, textStatus, errorThrown){
			}
		});
    });
});
</script>