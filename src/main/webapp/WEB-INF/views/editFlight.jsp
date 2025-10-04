<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dogia
  Date: 10/4/2025
  Time: 8:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Mới Sinh Viên</title>
    <link rel="stylesheet" href="/css/add.css">
</head>
<body>
<div class="container">
    <header>
        <h1>➕ THÊM MỚI CHUYẾN BAY</h1>
        <p>Nhập đầy đủ thông tin chuyến bay</p>
    </header>

    <div class="form-section">
        <form:form action="/flights/edit/${flight.id}" modelAttribute="flight" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <form:label path="flightName" >Tên Chuyến bay <span class="required"></span></form:label>
                <form:input path="flightName" type="text" />
                <form:errors cssStyle="color: red" path="flightName" class="form-hint"/>
            </div>
            <div class="form-group">
                <form:label path="starting_point" for="ma-sv">Điểm xuất phát <span
                        class="required">*</span></form:label>
                <form:input path="starting_point" type="text"  placeholder="VD: Hà Nội"/>
                <form:errors cssStyle="color: red" path="starting_point" class="form-hint"/>
            </div>
            <div class="form-group">
                <form:label path="destination" for="ma-sv">Điểm đến <span class="required">*</span></form:label>
                <form:input path="destination" type="text"  placeholder="VD: Hà Nội"/>
                <form:errors cssStyle="color: red" path="destination" class="form-hint"/>
            </div>
            <div class="form-group">
                <form:label path="departure_date" for="ma-sv">Ngày khời hành<span class="required">*</span></form:label>
                <form:input path="departure_date" type="date" />
                <form:errors cssStyle="color: red" path="departure_date" class="form-hint"/>
            </div>

            <div class="form-group">
                <form:label path="travel_time" for="ma-sv">Thời gian bay<span class="required">*</span></form:label>
                <form:input path="travel_time" type="number" />
                <form:errors cssStyle="color: red" path="travel_time" class="form-hint"/>
            </div>

            <div class="form-group">
                <form:label path="time_unit" for="ma-sv">Đơn vị<span class="required">*</span></form:label>
                <form:input path="time_unit" type="text"/>
                <form:errors cssStyle="color: red" path="time_unit" class="form-hint"/>
            </div>

            <div class="form-group">
                <form:label path="travel_image" for="ma-sv">Đơn vị<span class="required">*</span></form:label>
                <form:input path="travel_image" type="file"/>
                <form:errors cssStyle="color: red" path="travel_image" class="form-hint"/>
            </div>


            <div class="form-group">
                <label>Trạng thái <span class="required">*</span></label>
                <div class="radio-group">
                    <div class="radio-option">
                        <label><form:radiobutton path="status"  value="0"/>Chờ</label>
                        <label><form:radiobutton path="status"  value="1"/>Đang bay</label>
                        <label><form:radiobutton path="status"  value="2"/>Hạ cánh</label>
                    </div>
                </div>
            </div>
            <input type="hidden" value="${flight.id}">
            <div class="button-group">
                <button type="submit" class="btn btn-submit">✓ Lưu thông tin</button>
                <button type="reset" class="btn btn-reset">↻ Nhập lại</button>
                <a href="/flights" class="btn btn-back">← Quay lại</a>
            </div>
        </form:form>
    </div>

</div>
</body>
</html>