<!DOCTYPE html>
<html>

<head>
    <title>Szybko do celu!</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css" type="text/css"/>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="icon" href="/image/favicon.ico" type="image/ico" sizes="16x16">
    <style>
        body {
            background-image: url("/image/background1.png");
        }
    </style>
</head>

<body>

<#include "logo.ftlh">
<#include "navbar.ftlh">


<div class="container content">

    <#if google_name??>
        <h3 class="heading-statistics">Zalogowany jako: ${google_name}</h3>
        <div class="w3-card-4 w3-light-gray mx-auto" style="width:80%">
            <#include "sidebar.ftlh">
        </div>

        <div class="row" style="margin-top: 2%">
            <div class="col-12" style="text-align: center">
                <div class="alert alert-success" id="success-alert" style="display:none">Tag dodany</div>
            </div>
        </div>
    </#if>
    <div class="w3-card-4 w3-light-gray mx-auto col-12" style="width:80%">
        <br>
        <h3 class="heading-statistics" style="margin-top: 20px"><b>Sprawdź czy podany przystanek/linia istnieje</b></h3>
        <br>

        <form class="menu-form">
            <div class="form-group">
                <label for="initialStop" class="align-baseline mr-1"><b>Przystanek:</b></label>
                <label><#include "inputListStopsWithTags.ftlh"></label>
            </div>

            <label for="routeId" class="align-baseline mr-1"><b>Linia:</b></label>
            <label><input type="text" name="routeId" maxlength="4" id="routeId" class="form-control"
                          placeholder="2"></label>
            <br>
            <br>
            <input class="btn" type="submit" name="save" value="Sprawdź" id="button-check"/>
            <br>

        </form>

        <div class="col-12" style="text-align: center; margin-top: 2%">
            <#if stopDesc??>
                <p>Przystanek: ${(stopDesc?string('TAK', 'NIE'))! ""}</p>
            </#if>
            <#if routeId??>
                <p> Linia: ${(routeId?string('TAK', 'NIE'))! ""}</p>
            </#if>
            <br>
        </div>
    </div>

    <div class="col-12 counter">
        <p>
            <small>Liczba wejść: ${counter}</small>
        </p>
    </div>

    <div class="col-12" style="text-align: center">
        <#include "copyright-footer.ftlh">
    </div>
</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="/js/promotedStop.js"></script>
</body>
</html>


