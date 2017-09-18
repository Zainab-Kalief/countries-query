<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
	
</style>
</head>
<body>
	<table>
		<tr>
			<td>Country</td>
			<td>Language</td>
			<td>Percentage</td>
		<tr>
		<c:forEach items="${ countries }" var="value">
			<tr>
			<td><c:out value="${ value[0] }"/> </td>
			<td><c:out value="${ value[1] }"/> </td>
			 <td><c:out value="${ value[2] }"/> </td> 
			</tr>
		</c:forEach>
	</table>
</body>
</html>