<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link href="/webjars/bootstrap/5.2.2/css/bootstrap.min.css"
	rel="stylesheet">


<meta charset="ISO-8859-1">
<title>Vehicles List</title>
</head>
<body>
	<div class="container">

		<h1>Vehicles List - <a href="/downloadExcel">Download </a> </h1>
		<table class="table">
			<thead>

				<tr>
					<th>Vehicle Number</th>
					<th>Vehicle Name</th>
					<th>Vehicle Type</th>
					<th>Vehicle Model</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${vehicles}" var="vehicle">
					<tr>
						<td>${vehicle.number}</td>
						<td>${vehicle.name}</td>
						<td>${vehicle.type}</td>
						<td>${vehicle.model}</td>
						<td><a href="edit-vehicle?id=${vehicle.number}"
							class="btn btn-success">EDIT</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-vehicle" class="btn btn-success">Add Vehicle</a>
	</div>
	<script type="text/javascript"
		src="/webjars/bootstrap/5.2.2/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="/webjars/jquery/3.6.0/jquery.min.js"></script>

</body>
</html>