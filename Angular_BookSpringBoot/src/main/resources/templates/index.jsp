
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<title>List All Book</title>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet"/>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 100%;
}
th, td {
	text-align: left;
	padding: 8px;
}
tr:nth-child(even){
	background-color: #f2f2f2}
th {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
<center>
	<h2>List All Book</h2>
</center>
<table class="table table-striped table-hover table-bordered">
<tr>
	<th>Book Code</th>
	<th>Book Title</th>
	<th>Book Author</th>
	<th>Book Price</th>
	<th>Action</th>
	<tr th:each="book: ${list}">
	<td th:text="${book.bookCode}" />
	<td th:text="${book.bookTitle}" />
	<td th:text="${book.bookAuthor}" />
	<td align="right" th:text="${book.bookPrice}" />
	<td> <a th:href="@{/setupUpdateBook(code=${book.bookCode})}">Update</a>|

		<a th:href="@{/deleteBook(code=${book.bookCode})}">Delete</a>
	</td>

</tr>
</table>
<center>
	<a href="setupaddbook"><input type="submit" value="Create New Book" class="btn btn-success"></a>
 </center>

</body>
</html>