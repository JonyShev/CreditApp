<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Main page</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div class="mainBank">
    <div class="container">
        <div class="logo">
            <img src="<c:url value="/resources/img/icon.webp"/>" alt="logo" class="logo_img">
            <div class="logo_text">Система оформления кредитов</div>
        </div>
        <h1 class="title">В этом приложении можно создать клиента и оформить кредит.
            А также работать с лимитами и процентными ставками банка!</h1>
        <br><br>
        <form action="showAllCredit">
            <button class="btn_href" type="submit">Список кредитов</button>
        </form>
        <br><br>
        <form action="showAllClients">
            <button class="btn_href" type="submit">Список клиентов</button>
        </form>

    </div>
</div>


</body>
</html>