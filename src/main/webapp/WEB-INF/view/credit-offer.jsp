<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Кредитное предложение</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="all-clients">
    <div class="container">
        <h2 class="limit">Кредитное предложение</h2>
        <br>
        <div class="form_container">
            <div class="fio_text">
                Для клиента: ${client.fio}
            </div>

            <br>

            <form:form action="showPayments" modelAttribute="parametriCredita">

                Желаемая сумма кредита тыс/р<form:input class="form-control" path="sumCredit"/>
                <form:errors path="sumCredit"/>
                <br>
                Дата выдачи кредита/займа дд.мм.гггг<form:input class="form-control" path="data"/>
                <form:errors path="data"/>
                <br>
                Срок кредита/займа год(а)/лет <form:input class="form-control" path="years"/>
                <form:errors path="years"/>
                <br>
                <input type="submit" class="btn btn-primary" value="OK">
            </form:form>
        </div>

    </div>
</div>
</body>
</html>