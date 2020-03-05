<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>

<head>
	<title>Employee Tracker Application</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css" >
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<a class="logout" href="logout.jsp" onclick="if (!(confirm('Are you sure you want to log out?'))) return false">Logout</a>
			<h2>Employee Management System</h2>
		</div>

	</div>
	
	<div id="container">
		<div id="content">
		
		<form action="ControllerServlet" method="GET">
			<input type="hidden" name="command" value="SEARCH" />
                Search employee: <input type="text" name="searchKeyword" />
            <input type="submit" value="Search" class="addEmployeeButton" />
            
            <input type="button" 
			   value="Add Employee" 
			   onclick="window.location.href='addEmployee.jsp'; return false;"
			   class="addEmployeeButton"
			   style="float: right;"/>
        </form> 
        
        <br/>

		<table>
			<tr>
				<th>Last Name</th>
				<th>First Name</th>
				<th>Job Title</th>
				<th>Department</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="tempEmployee" items="${EMPLOYEE_LIST}"> 
			
				<c:url var="tempLink" value="ControllerServlet">
					<c:param name="command" value="LOAD" />
					<c:param name="employeeId" value="${tempEmployee.id}" />				
				</c:url>
				
				<c:url var="deleteLink" value="ControllerServlet">
					<c:param name="command" value="DELETE" />
					<c:param name="employeeId" value="${tempEmployee.id}" />				
				</c:url>
				
				<tr>
					<td> ${tempEmployee.lastName} </td>
					<td> ${tempEmployee.firstName} </td>
					<td> ${tempEmployee.jobTitle } </td>
					<td> ${tempEmployee.department } </td>
					<td> ${tempEmployee.email} </td>
					<td> <a href="${tempLink}">Update</a> | <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a></td>
				</tr>
			
			</c:forEach>	
		</table>
			
		</div>
	</div>

</body>

</html>