<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Все кредиты</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="all-credit">
    <div class="container">

        <h2 class="limit">Лимиты и процентные ставки</h2>
        <div class="table_limit_percent">
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th>Лимит тыс/р</th>
                    <th>Процентная ставка %</th>
                    <th>Операции</th>
                </tr>
                </thead>

                <c:forEach var="credit" items="${allCredit}">

                    <c:url var="updateButton" value="/updateCredit">
                        <c:param name="creditId" value="${credit.id}"/>
                    </c:url>

                    <c:url var="deleteButton" value="/deleteCredit">
                        <c:param name="creditId" value="${credit.id}"/>
                    </c:url>

                    <tr>
                        <td>${credit.limit}</td>
                        <td>${credit.percent}</td>
                        <td>
                            <input type="button" class="btn btn-warning" value="Обновить"
                                   onclick="window.location.href = '${updateButton}'"/>
                            <input type="button" class="btn btn-danger" value="Удалить"
                                   onclick="window.location.href = '${deleteButton}'"/>
                        </td>
                    </tr>


                </c:forEach>
            </table>
        </div>


        <br>

        <input type="button" class="btn btn-success" value="Добавить" onclick="window.location = 'addNewCredit'">

        <br><br>

        <a href="/">Стартовая страница</a>


    </div>

</div>


</body>
</html>