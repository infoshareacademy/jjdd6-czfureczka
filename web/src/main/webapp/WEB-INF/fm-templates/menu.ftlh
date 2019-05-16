<!DOCTYPE html>
<html>

<head>
    <title>Szybko do celu</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>

<body>

<#include "logo.ftlh">
<#include "navbar.ftlh">


<div class="container">

    <#if google_name??>
        <h3 class="heading-statistics">Zalogowany jako: ${google_name}</h3>
    </#if>

    <#include "sidebar.ftlh">

    <div class="row">

        <div class="col-12">
            <h3 class="heading-statistics">Sprawdź czy podany przystanek/linia istnieje</h3>
        </div>

        <div class="col-12">
            <form class="menu-form">
                <div class="form-group">
                    <label for="initialStop" class="align-baseline mr-1">Przystanek:</label>
                    <label><#include "inputListStopsWithTags.ftlh"></label>
                </div>

                <div class="form-group">
                    <label for="routeId" class="align-baseline mr-1">Linia:</label>
                    <label><input type="text" name="routeId" required maxlength="4" id="routeId" class="form-control"
                                  placeholder="2"></label>
                </div>

                <input class="btn" type="submit" name="save" value="Sprawdź" id="button-check"/>

            </form>
        </div>

        <div class="col-12" style="text-align: center; margin-top: 2%">
            <#if stopDesc??>
                <p>Przystanek: ${(stopDesc?string('TAK', 'NIE'))! ""}</p>
            </#if>
            <#if routeId??>
                <p> Linia: ${(routeId?string('TAK', 'NIE'))! ""}</p>
            </#if>
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
