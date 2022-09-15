
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<title>Create New Book Form</title>
<link th:href="@{/resources/css/bootstrap.min.css}"
rel="stylesheet" />
</head>
<body>
<form id="form" class="form-horizontal"
action="updatebook" method="post" th:object="${bookBean}">
<div class="form-group">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<h2 style="text-align: center">Update
Book</h2>
</div>
</div>
<hr/>
<div class="form-group">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<label for="user-name">Book Code</label>
<input type="text" class="form-control"

th:field="*{bookCode}"></input>
<label

th:if="${#fields.hasErrors('bookCode')}"
th:errors="*{bookCode}" style="color:red;">Error</label>
</div>
</div>
<div class="form-group">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<label for="user-name">Book Title</label>

<input type="text" class="form-
control" th:field="*{bookTitle}"></input>

<label

th:if="${#fields.hasErrors('bookTitle')}"
th:errors="*{bookTitle}" style="color:red;">Error</label>
</div>
</div>
<div class="form-group">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<label for="user-name">Book
Author</label>

<input type="text" class="form-control" th:field="*{bookAuthor}"></input>

<label

th:if="${#fields.hasErrors('bookAuthor')}"
th:errors="*{bookAuthor}" style="color:red;">Error</label>
</div>
</div>
<div class="form-group">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<label for="user-name">Book Price</label>

<input type="text" class="form-control" th:field="*{bookPrice}"></input>

<label

th:if="${#fields.hasErrors('bookPrice')}"
th:errors="*{bookPrice}" style="color:red;">Error</label>
</div>
</div>
<div class="form-group">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<div class="col-sm-2">
<input type="submit" value="Update" class="btn btn-success" style="width: 80px;">
</div>

<div class="col-sm-1">

</div>
<div class="col-sm-2">

<a href="/" class="btn btn-primary">List All Book</a>

</div>
</div>
</div>
</form>
</body>
</html>