<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm tin tức mới</title>
</head>
<body>
    <h2>Thêm tin tức mới</h2>

    <c:if test="${not empty errorMessage}">
        <div style="color: red;">
            <p>${errorMessage}</p>
        </div>
    </c:if>

    <form action="/Tuan04_Bai3/TinTucFormServlet" method="post">
        <label for="maTT">Mã TT:</label><br>
        <input type="text" id="maTT" name="maTT" value="${param.maTT}"><br><br>

        <label for="tieuDe">Tiêu đề:</label><br>
        <input type="text" id="tieuDe" name="tieuDe" value="${param.tieuDe}"><br><br>

        <label for="noiDung">Nội dung:</label><br>
        <textarea id="noiDung" name="noiDung" rows="4" cols="50">${param.noiDung}</textarea><br><br>

        <label for="lienKet">Liên kết:</label><br>
        <input type="text" id="lienKet" name="lienKet" value="${param.lienKet}"><br><br>

        <label for="danhMuc">Danh mục:</label><br>
        <select id="danhMuc" name="danhMuc">
            <option value="">Chọn danh mục</option>
            <c:forEach var="danhMuc" items="${danhMucList}">
                <option value="${danhMuc.maDM}" ${param.danhMuc == danhMuc.maDM ? 'selected' : ''}>
                    ${danhMuc.tenDanhMuc}
                </option>
            </c:forEach>
        </select><br><br>

        <input type="submit" value="Thêm">
    </form>
</body>
</html>