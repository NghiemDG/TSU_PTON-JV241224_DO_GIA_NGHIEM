<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dogia
  Date: 10/4/2025
  Time: 8:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Sinh Viên</title>
    <link rel="stylesheet" href="/css/list.css">
</head>
<body>
<div class="container">
    <header>
        <h1>🎓 DANH SÁCH CHUYẾN BAY</h1>
    </header>

    <div class="search-section">
        <form method="get" action="/flights" class="search-container">
            <div class="search-group">
                <label for="search-name">🔍 Tìm kiếm theo tên chuyến bay</label>
                <input type="text" id="search-name" name="search" placeholder="Nhập tên chuyến bay..." value="${search}">
            </div><div class="search-group">
                <label for="search-name">🔍 Tìm kiếm theo  điểm xuất phát</label>
                <input type="text" id="search-name" name="starting" placeholder="Nhập điểm xuất phát..." value="${starting}">
            </div>
            <div class="search-group">
                <label for="search-name">🔍 Tìm kiếm theo điểm đế</label>
                <input type="text" id="search-name" name="destination" placeholder="Nhập điểm đến..." value="${destination}">
            </div>
            <button type="submit" class="search-btn">Tìm kiếm</button>
        </form>
        <a href="/flights/add" class="btn-add-new">➕ Thêm mới chuyến bay</a>
    </div>

    <div class="table-wrapper">
        <table>
            <thead>
            <tr>
<%--                <th>Mã Chuyến Bay</th>--%>
                <th>Tên chuyến bay</th>
                <th>Điểm xuất phát</th>
                <th>Điểm đến</th>
                <th>Ngày khởi hành</th>
                <th>Thời gian chuyến bay</th>
                <th>Đơn vị</th>
                <th>Ảnh</th>
                <th>Trạng Thái</th>
                <th>Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${flightsList}" var="f">
                <tr>
                    <td>${f.flightName}</td>
                    <td>${f.starting_point}</td>
                    <td>${f.destination}</td>
                    <td>${f.departure_date}</td>
                    <td>${f.travel_time}</td>
                    <td>${f.time_unit}</td>
                    <td><img src="${f.travel_image}" alt=""></td>
                    <td>${f.status}</td>
                    <td><a href="/flights/edit/${f.id}">Sửa</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="pagination">
        <c:forEach begin="1" end="${totalPages}" varStatus="loop">
            <a href="/flights?page=${loop.index}&size=5" class="${page==loop.index? 'active':''}">${loop.index}</a>
        </c:forEach>
    </div>

<%--    <footer>--%>
<%--        <p>Tổng số sinh viên: <strong>100</strong> | Hiển thị: <strong>1-10</strong> | Trang: <strong>1/10</strong> |--%>
<%--            Cập nhật: 04/10/2025</p>--%>
<%--    </footer>--%>
</div>
</body>
</html>