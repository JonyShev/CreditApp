<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Clients info</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>


<div class="all-clients">
    <div class="container">
        <h2 class="limit">Форма клиента</h2>
        <br>
        <div class="form_container">
            <form:form action="saveClient" modelAttribute="client">
                <form:hidden path="id"/>

                ФИО <form:input class="form-control" path="fio"/>
                <form:errors path="fio"/>
                <br>
                Номер телефона <form:input class="form-control" path="phoneNumber"/>
                <form:errors path="phoneNumber"/>
                <br>
                Email <form:input class="form-control" path="email"/>
                <form:errors path="email"/>
                <br>
                Номер паспорта <form:input class="form-control" path="passportNumber"/>
                <form:errors path="passportNumber"/>
                <br>
                <input type="submit" class="btn btn-primary" value="OK">
            </form:form>
        </div>
    </div>
</div>


</body>
</html>