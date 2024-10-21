<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Quản lý tin tức</title>
<style>
body {
	font-family: Arial, sans-serif;
}

.menu {
	text-align: center;
	margin-top: 20px;
}

.menu a {
	margin: 0 20px;
	text-decoration: none;
	color: black;
	font-size: 18px;
}

.menu a:hover {
	text-decoration: underline;
}

.footer {
	text-align: center;
	margin-top: 20px;
	font-size: 14px;
}

.content {
	height: 420px;
}
</style>
</head>
<body>
	<form action="/Tuan04_Bai3/DanhMucServlet" method="GET">
		<div class="header">
			<img src="image/banner.png" alt="News Banner"
				style="width: 100%; height: auto;">
		</div>

		<div class="menu">
			<a href="DanhSachTinTucServlet">Danh sách tin tức</a> | <a
				href="TinTucFormServlet">Thêm tin tức mới</a> | <a
				href="QuanLyFormServlet">Chức năng quản lý</a>
			<hr>
		</div>

		<div class="content"></div>

		<div class="footer">
			<hr>
			Hồ Hoàng Vân Anh -20098521 - DHKTPM16B
			<hr>
		</div>
	</form>
</body>
</html>