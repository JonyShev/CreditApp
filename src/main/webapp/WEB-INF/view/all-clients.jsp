<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Все клиенты</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="all-clients">
    <div class="container">
        <h2 class="limit">Все клиенты</h2>
        <table class="table">
            <thead class="thead-light">
            <tr>
                <th>ФИО</th>
                <th>Номер телефона</th>
                <th>Email</th>
                <th>Номер паспорта</th>
                <th>Операции</th>
            </tr>
            </thead>

            <c:forEach var="client" items="${allClients}">

                <c:url var="updateButton" value="/updateInfo">
                    <c:param name="clientId" value="${client.id}"/>
                </c:url>

                <c:url var="deleteButton" value="/deleteClient">
                    <c:param name="clientId" value="${client.id}"/>
                </c:url>

                <c:url var="checkoutButton" value="/checkoutCredit">
                    <c:param name="clientId" value="${client.id}"/>
                </c:url>

                <tr>
                    <td>${client.fio}</td>
                    <td>${client.phoneNumber}</td>
                    <td>${client.email}</td>
                    <td>${client.passportNumber}</td>
                    <td>
                        <input type="button" class="btn btn-warning" value="Обновить"
                               onclick="window.location.href = '${updateButton}'"/>
                        <br><br>
                        <input type="button" class="btn btn-danger" value="Удалить"
                               onclick="window.location.href = '${deleteButton}'"/>
                        <br><br>
                        <input type="button" class="btn btn-info" value="Оформить кредит"
                               onclick="window.location.href = '${checkoutButton}'"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <input type="button" value="Добавить" class="btn btn-success" onclick="window.location = 'addNewClients'">
        <br><br>
        <a href="/">Стартовая страница</a>
    </div>
</div>
</body>
</html>