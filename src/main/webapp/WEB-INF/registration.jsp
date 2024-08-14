<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>전화번호 등록</h1>

    <p>전화번호를 등록하려면<br> 아래 항목을 기입하고 '등록' 버튼을 클릭하세요.</p>

    <label>이름(name): </label>
    <input type="text" id="name" required><br><br>
    <label>핸드폰(phone): </label>
    <input type="tel" id="phone" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required><br><br>
    <label>회사(company): </label>
    <input type="tel" id="company" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required><br><br>

    <input type="submit" id = "submit" value = "등록"> <br><br>

    <a href = "list.jsp" id="listButton">리스트 바로가기</a>


</body>
</html>