<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Evergreen Books - Online Book Store</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<br>
	<br>
	<div align="center">
		<div align="center" style="width: 90%; margin: 0 auto;">
			<h2>New Books</h2>
			<c:forEach items="${listNewBooks}" var="book">
				<div style="display: inline-block; margin: 20px">
					<div>
						<a href="view_book?id=${book.bookId}"> <img
							src="data:image/jpg;base64,${book.base64Image}" width="128"
							height="164" />
						</a>
					</div>
					<div>
						<a href="view_book?id=${book.bookId}"> <b>${book.title}</b>
						</a>
					</div>
					<div>Ratings *****</div>
					<div>
						<i>by ${book.author}</i>
					</div>
					<div>
						<b>$${book.price}</b>
					</div>
				</div>
			</c:forEach>
		</div>
		<div align="center" style="clear:both">
			<h2>Best-Selling Books</h2>
		</div>
		<div align="center" style="clear:both">
			<h2>Most favored Books</h2>
		</div>
	</div>
	<br>
	<br>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>