<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="/webjars/bootstrap/5.2.2/css/bootstrap.min.css"
	rel="stylesheet">


<meta charset="ISO-8859-1">
<title>Add/Update Vehicle Page</title>
</head>
<body>
	<div class="container">

		<h1>Enter Vehicle Details</h1>
		<form:form method="post" modelAttribute="vehicle">

			<c:choose>
				<c:when test="${empty param.id}">
      Number: <form:input type="text" path="number" required="required"
						readonly="false" />
				</c:when>
				<c:otherwise>
       Number: <form:input type="text" path="number" required="required"
						readonly="true" />
				</c:otherwise>
			</c:choose>
			<form:errors path="name" />
			Name: <form:input type="text" path="name" required="required" />
			  
			
			Type: <form:input type="text" path="type" required="required" />
			Model: <form:input type="text" path="model" required="required" />
			<input type="submit" class="btn btn-success" />
		</form:form>
	</div>

</body>
</html>