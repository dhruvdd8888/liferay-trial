<%@ include file="/init.jsp"%>

<portlet:actionURL name="/login" var="loginButtonURL" />


<div class="container-portlet">	<br><br>
	<div class="row d-flex justify-content-center align-items-center h-100">
		<div class="col-12 col-md-8 col-lg-6 col-xl-5">
			<div class="card bg-dark text-white" style="border-radius: 1rem;">
				<div class="card-body p-5 text-center">
					
					<div class="mb-md-5 mt-md-4 pb-5">
						
						<form action="${loginButtonURL}" method="post">
							<button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
							<p class="text-white-50 mb-5">Please enter your email and
								password!</p>
								
								<div class="form-outline form-white mb-4">
									<label class="text-white-50 fw-bold" for="Email">Email</label>
									<input type="email" id="Email" name="<portlet:namespace/>email"
									class="form-control form-control-lg" /> 
								</div>
								
								<div class="form-outline form-white mb-4">
									<label class="text-white-50 fw-bold" for="Password">Password</label>
									<input type="password" id="typePasswordX" name = "<portlet:namespace/>password"
										class="form-control form-control-lg" /> 
								</div>
								

						</form>

					</div>



				</div>
			</div>
		</div>
	</div>
	</section>