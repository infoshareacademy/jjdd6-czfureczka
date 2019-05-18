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


<div class="container content">
    <div class="row">

        <#if google_name??>
            <h3 class="heading-statistics">Zalogowany jako: ${google_name}</h3>
        </#if>

        <div class="col-12">
            <h3 class="heading-statistics">Rozkład jazdy</h3>
        </div>

        <#include "listTram.ftlh">
        <#include "listBus.ftlh">
        <#include "listTrolleybus.ftlh">
    </div>
    <#if time??>
        <#include "timetable.ftlh">
    <#else>
        <#include "listStops.ftlh">
    </#if>

    <div class="col-12" style="margin-top: 3%">
        <#include "copyright-footer.ftlh">
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="/js/modeOfTransportation.js"></script>
</body>
</html>