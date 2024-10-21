	<%@ page contentType="text/html; charset=UTF-8" language="java"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core"%>
	
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Quản lý Tin Tức</title>
	<style>
	body {
		font-family: Arial, sans-serif;
	}
	
	.container {
		display: flex;
	}
	
	.menu {
		width: 20%;
		border-right: 1px solid #ddd;
		padding-right: 20px;
	}
	
	.menu ul {
		list-style-type: none;
		padding: 0;
	}
	
	.menu li {
		margin-bottom: 10px;
	}
	
	.menu li a {
		text-decoration: none;
		color: blue;
	}
	
	.menu li a:hover {
		text-decoration: underline;
	}
	
	.content {
		width: 80%;
		padding-left: 20px;
	}
	
	table {
		width: 100%;
		border-collapse: collapse;
	}
	
	table, th, td {
		border: 1px solid black;
	}
	
	th, td {
		padding: 10px;
		text-align: left;
	}
	</style>
	</head>
	<body>
		<form action="/Tuan04_Bai3/DanhSachTinTucServlet" method='GET'>
			<h2>Quản lý Tin Tức</h2>
	
			<div class="container">
	
				<div class="menu">
					<h3>Danh Mục</h3>
					<ul>
						<c:forEach var="danhMuc" items="${danhMucList}">
							<li><a href="DanhSachTinTucServlet?madm=${danhMuc.maDM}">
									${danhMuc.tenDanhMuc} </a></li>
						</c:forEach>
					</ul>
				</div>
	
	
				<div class="content">
					<h3>Danh Sách Tin Tức</h3>
					<table>
						<thead>
							<tr>
								<th>Mã TT</th>
								<th>Tiêu Đề</th>
								<th>Nội Dung</th>
								<th>Liên Kết</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="tin" items="${tinTucList}">
								<tr>
									<td>${tin.maTT}</td>
									<td>${tin.tieuDe}</td>
									<td>${fn:substring(tin.noiDung, 0, 100)}...</td>
									<td><a href="${tin.lienKet}" target="_blank">${tin.lienKet}</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</body>
	</html>