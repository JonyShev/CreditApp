<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>График платежей</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="all-clients">
    <div class="container">
        <h2 class="limit">График платежей</h2>
        <h3>Параметры кредита/займа</h3>
        <br>
        Сумма кредита/займа ${sumCredit} тыс/р
        <br>
        Срок кредита/займа ${years} год(а)/лет
        <br>
        Процентная ставка ${percent} %
        <br>
        Дата выдачи кредита/займа ${data}
        <br>
        <br>
        <h3>Результаты расчета</h3>
        <br>
        Всего выплат ${allPayment} тыс/р
        <br>
        Переплата ${pereplata} тыс/р
        <br>
        <br>
        <table class="table">
            <thead class="thead-light">
            <tr>
                <th>Дата</th>
                <th>Платеж</th>
                <th>Проценты</th>
                <th>Тело кредита</th>
                <th>Остаток</th>
            </tr>
            </thead>

            <c:forEach var="pay" items="${listPayment}">
                <tr>
                    <td>${pay.date}</td>
                    <td>${pay.platezh}</td>
                    <td>${pay.percents}</td>
                    <td>${pay.bodyCredit}</td>
                    <td>${pay.ostatok}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


</body>
</html>