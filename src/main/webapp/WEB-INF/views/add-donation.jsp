<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<%@include file="header.jspf"%>
<header class="header--main-page">

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br/>
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>
        </div>
    </div>
</header>

<section class="steps">
    <h2>Wystarczą 4 proste kroki</h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3>Wybierz rzeczy</h3>
            <p>ubrania, zabawki, sprzęt i inne</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3>Spakuj je</h3>
            <p>skorzystaj z worków na śmieci</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3>Zdecyduj komu chcesz pomóc</h3>
            <p>wybierz zaufane miejsce</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3>Zamów kuriera</h3>
            <p>kurier przyjedzie w dogodnym terminie</p>
        </div>
    </div>



    <br/>
    <h1>Wypełnij formularz</h1>
    <br/>

    <div class="about-us">

        <form:form method="post" modelAttribute="donation" class="form-steps-container">
            <br/>
            <p></p>
            <form:input path="id" type="hidden"/>
            <div class="form-group form-group--50"> <label class="form-group--checkbox">Kategorie:</label>
                <form:checkboxes path="categories" items="${categories}" itemLabel="name"/>
            </div>

            <div class="form-group form-group--50">
                <label class="form-group--checkbox">Instytucje:</label>
                <form:select path="institution" items="${institutions}" itemLabel="name" />
            </div>

            <div class="form-group form-group--50">
                <label class="form-group--checkbox">Kod pocztowy </label>
                <form:input path="zipCode" type="text" class="form-group form-group--50" />
            </div>

            <div class="form-group form-group--50">
                <label class="form-group--checkbox">Ulica </label>
            <form:input path="street" type="text" class="form-group form-group--50"/>
            </div>

            <div class="form-group form-group--50">
                <label class="form-group--checkbox">Miasto</label>
            <form:input path="city" type="text" class="form-group form-group--50" />
            </div>

            <div class="form-group form-group--50">
                <label class="form-group--checkbox">Ilość worków </label>
            <form:input path="quantity" type="text" />
            </div>

            <div class="form-group form-group--50">
                <label class="form-group--checkbox">Komentarz:</label>
            <form:textarea path="pickUpComment" />
            </div>

            <div class="form-group form-group--50">
                <label class="form-group--checkbox">Data odbioru:</label>
            <form:input type="date" path="pickUpDate"  />
            </div>

            <div class="form-group form-group--50">
                <label class="form-group--checkbox">Godzina odbioru:</label>
            <form:input type="time" path="pickUpTime" />
            </div>
            <button class="btn" type="submit">Wyślij</button>
        </form:form>
    </div>

</section>
<br/>

<%@include file="footer.jspf"%>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
