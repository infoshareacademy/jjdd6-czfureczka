<!DOCTYPE html>
<html>
<head>
    <title>Szybko do celu</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css" type="text/css"/>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" href="/image/favicon.ico" type="image/ico" sizes="16x16">
    <style>
        body {
            background-image: url("/image/background1.png");
        }
    </style>
</head>
<body>
<#setting number_format="computer">
<#include "logo.ftlh">
<#include "navbar.ftlh">

<div class="container content">

    <#if google_name??>
        <h3 class="heading-statistics">Zalogowany jako: ${google_name}</h3>
    </#if>
    <div class="col-12" style="text-align: center; margin-top: 2%">
        <div class="spinner-border " role="status" id="spinner" style="display:none"></div>
    </div>
</div>

<div class="container content">

    <#if time??>
        <div class="w3-card-4 w3-light-gray">
            <div class="w3-container ">
                <#include "timetable.ftlh">
                <br>
            </div>
        </div>
    </#if>
    <#if listStops??>
        <div class="w3-card-4 w3-light-gray">
            <div class="w3-container ">
                <#include "listStops.ftlh">

                <br>
            </div>
        </div>
    </#if>
    <br>
</div>

<div class="container content">
    <div class="w3-card-4  w3-light-gray">
        <div class="w3-container">
            <br>
            <img src="/image/tramcar.png" alt="Avatar" class="w3-left" style="width:10%">
            <br>
            <h1><b>TRAMWAJE</b></h1>
        </div>
        <button type="text" class="list-group-item list-group-item-action"
                style="background-color: #15400e !important; color: white; cursor: auto;"><b>LINIE</b></button>
        <br>
        <#include "listTram.ftlh">
        <br>
    </div>
    <br>
    <div class="w3-card-4 w3-light-gray">
        <div class="w3-container ">
            <br>
            <img src="/image/bus.png" alt="Avatar" class="w3-left" style="width:10%">
            <br>
            <h1><b>AUTOBUSY</b></h1>
        </div>
        <button type="text" class="list-group-item list-group-item-action"
                style="background-color: #15400e !important; color: white; cursor: auto;"><b>LINIE</b></button>

        <br>
        <#include "listBus.ftlh">
        <br>

    </div>


<br>
<div class="w3-card-4 w3-light-gray">
    <div class="w3-container ">
        <br>
        <img src="/image/frontbus.png" alt="Avatar" class="w3-left" style="width:10%">
        <br>
        <h1><b>TROLEJBUSY</b></h1>
    </div>
    <button type="text" class="list-group-item list-group-item-action"
            style="background-color: #15400e !important; color: white; cursor: auto;"><b>LINIE</b></button>
<br>
    <#include "listTrolleybus.ftlh">
<br>
</div>

<br>
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