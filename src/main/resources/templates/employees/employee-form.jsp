<!DOCTYPE html>

<html>

<head>
	<title>Add Employee</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-employee-style.css">
</head>


<body>

	<div id="wrapper">
		<div id="header">
			<h2>Employee Management System</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Employee</h3>
		
		<form action="ControllerServlet" method="GET">
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label><b>Title</b></label></td>
						<td>
							<select name="title">
								<option>-</option>
								<option>Mr</option>
								<option>Mrs</option>
							</select>
						</td> 
					</tr>
					<tr>
						<td><label><b>First Name</b> *</label></td>
						<td><input type="text" name="firstName" required="required" /></td> 
					</tr>
					<tr>
						<td><label><b>Last Name</b> *</label></td>
						<td><input type="text" name="lastName" required="required" /></td> 
					</tr>
					<tr>
						<td><label><b>Job Title</b> *</label></td>
						<td><input type="text" name="jobTitle" required="required" /></td> 
					</tr>
					<tr>
						<td><label><b>Department</b></label></td>
						<td>
							<select id="dept" name="department">
								<option></option>
								<option>Development</option>
								<option>Finance</option>
								<option>Marketing</option>
								<option>Human Resources</option>
								<option>Support</option>
								<option>Research & Development</option>
								<option>Sales</option>
							</select>
						</td> 
					</tr>
					<tr>
						<td><label><b>Email</b> *</label></td>
						<td><input type="text" name="email" required="required" /></td> 
					</tr>
					<tr>
						<td><label><b>Phone Number</b></label></td>
						<td><input type="text" name="phone" /></td> 
					</tr>
					<tr>
						<td><label><b>Date of Birth</b> *</label></td>
						<td><input type="date" name="dateOfBirth" required="required" /></td> 
					</tr>
					<tr>
						<td><label><b>Address</b></label></td>
						<td><input type="text" name="address" /></td> 
					</tr>
					<tr>
						<td><label><b>Notes</b></label></td>
						<td>
							<textarea name="notes" placeholder="Add comments" rows="5"></textarea>
						</td> 
					</tr>
					<tr>
						<td><label></label></td>
						<td>
							<input type="submit" value="Save" class="save" />
							<input type="button" value="Cancel" class="cancel" onclick="window.location.href='./ControllerServlet'"/>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		
		<div id="fields_note">
			(*) required fields
		</div>
		
		<div style="clear: both;"></div>

	</div>

</body>

</html>