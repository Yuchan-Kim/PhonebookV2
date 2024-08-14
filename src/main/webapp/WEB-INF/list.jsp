<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>   
<%@ page import = "com.kavaex.vo.PersonVO" %> 
<%
    List<PersonVO> personList = (List<PersonVO>)request.getAttribute("personList");
	System.out.println("jsp 양식");
	System.out.println(personList);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>전화번호 리스트</h1>

    <p>입력한 정보 내역 입니다.</p>
	<% for (int i = 0; i < personList.size(); i++){ %>
    <table border = "1">
        <tr>
            <td>이름(name)</td>
            <td><%=personList.get(i).getName() %></td>
        </tr>
        <tr>
            <td>핸드폰(hp)</td>
            <td><%=personList.get(i).getHp() %></td>
        </tr>
        <tr>
            <td>회사(company)</td>
            <td><%=personList.get(i).getCompanyhp() %></td>
        </tr>
    </table>
    <%} %>
    <a href = "#" id="listButton">전화번호 등록</a>
    
</body>
</html>