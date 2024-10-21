<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý tin tức</title>
</head>
<body>
	<h2>Quản lý tin tức</h2>
	<table border="1">
		<tr>
			<th>Mã TT</th>
			<th>Tiêu đề</th>
			<th>Nội dung</th>
			<th>Liên kết</th>
			<th>Hành động</th>
		</tr>
		<c:forEach var="tin" items="${tinTucList }">
			<tr>
				<td>${tin.maTT}</td>
				<td>${tin.tieuDe}</td>
				<td>${tin.noiDung}</td>
				<td><a href="${tin.lienKet}" target="_blank">${tin.lienKet}</a></td>
				<td>
					<form action="QuanLyFormServlet" method="post">
						<input type="hidden" name="maTT" value="${tin.maTT}"> <input
							type="submit" value="Xóa">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>