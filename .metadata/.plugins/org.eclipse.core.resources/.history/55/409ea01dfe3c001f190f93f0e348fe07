<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit Profile- Evergreen Bookstore</title>
	<link rel="stylesheet" href="css/style.css">
	
	<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	
</head>
<body>
	<jsp:directive.include file="header.jsp" /><br>
	<div align="center">
		<h2 class="pageheading">
			Edit My Profile
		</h2>
	</div>
	<div align="center">
		<form action="update_profile" method="post" id="customerForm">
			<table class="form">
				<tr>
					<td align="right">Email: </td>
					<td align="left"><b>${loggedCustomer.email}</b> (Cannot be changed)</td>
				</tr>
				<tr>
					<td align="right">First Name:</td>
					<td align="left"><input type="text" name="firstname"
						size="45" value="${loggedCustomer.firstname}" required /></td>
				</tr>
				<tr>
					<td align="right">Last Name:</td>
					<td align="left"><input type="text" name="lastname"
						 size="45" value="${loggedCustomer.lastname}" required/></td>
				</tr>
				<tr>
					<td align="right">Phone Number: </td>
					<td align="left"><input type="text" name="phone" size="45" value="${loggedCustomer.phone}" required /></td>
				</tr>
				<tr>
					<td align="right">Address Line 1:</td>
					<td align="left"><input type="text" name="address1"
						 size="45" value="${loggedCustomer.addressLine1}" required /></td>
				</tr>
				<tr>
					<td align="right">Address Line 2:</td>
					<td align="left"><input type="text" name="address2"
						 size="45" value="${loggedCustomer.addressLine2}" required /></td>
				</tr>
				<tr>
					<td align="right">City: </td>
					<td align="left"><input type="text" name="city" size="45" value="${loggedCustomer.city}" required/></td>
				</tr>
				<tr>
					<td align="right">State:</td>
					<td align="left"><input type="text" name="state"
						size="45" value="${loggedCustomer.state}" required /></td>
				</tr>
				<tr>
					<td align="right">Zip Code: </td>
					<td align="left"><input type="number" name="zipCode" size="45" value="${loggedCustomer.zipcode}" required/></td>
				</tr>
				<tr>
					<td align="right">Country: </td>
					<td align="left">
						<select id="country" name="country" required>
							<c:forEach items="${mapCountries}" var="country">
								<option value="${country.value}"
									<c:if test='${loggedCustomer.country eq country.value}'> selected='selected'</c:if>>${country.key}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<i>(Leave password fields blank if you don't want to change the password)</i>
					</td>
				</tr>
				<tr>
					<td align="right">Password: </td>
					<td align="left"><input type="password" name="password" id="password" size="45" /></td>
				</tr>
				<tr>
					<td align="right">Confirm Password: </td>
					<td align="left"><input type="password" name="confirmPassword" id="confirmPassword" size="45" /></td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit">Save</button>&nbsp;&nbsp;&nbsp;
						<button type="button" onclick="history.go(-1);">Cancel</button>
					</td>
				</tr>
			</table>
		</form>
	</div>	
	
	<jsp:directive.include file="footer.jsp" />

	<script type="text/javascript">
	
		$(document).ready(function() {
			$("#customerForm").validate({
				rules: {
					confirmPassword: {
						equalTo: "#password"
					}
				},
				
				messages: {
					confirmPassword: {
						equalTo:"Confirm password does not match password"
					}
				}
			});
			
		});
		
	</script>
</body>
</html>