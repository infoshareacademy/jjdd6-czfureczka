<!DOCTYPE html>
<html>
<head>
    <title>Szybko do celu</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment-with-locales.min.js"
            integrity="sha256-AdQN98MVZs44Eq2yTwtoKufhnU+uZ7v2kXnD5vqzZVo=" crossorigin="anonymous"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css"/>

    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" href="/image/favicon.ico" type ="image/ico" sizes="16x16">
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
    </#if>
    <br>
    <div class="w3-card-4 w3-light-gray mx-auto" style="width:80%">
        <br>
    <h3 class="heading-statistics"><b>Najbliższy odjazd</b></h3>
        <br>
    <div class="row">
        <form class="col-12" method="get" id="stops-form">
            <#include "initialStop.ftlh">
            <#include "timePicker.ftlh">
            <input class="btn" type="submit" name="search" value="Szukaj" id="button-check"/>
        </form>
    </div>

    <div class="col-12" style="text-align: center; margin-top: 2%">
        <div class="spinner-border " role="status" id="spinner" style="display:none"></div>
    </div>

    <div style="margin-top: 2%" id="stops-result">
        <#if result??>
            <div class="row">
                <div class="col-12">

                    <#list result>
                        <#items as timetableForStop>
                            <div>
                                Możesz pojechać następującą linią:
                                <span>${timetableForStop.routeId}, </span><br/>

                                Odjazdy są o:

                                <#list timetableForStop.time>
                                    <#items as time>
                                        <span>${time},</span>
                                    </#items>
                                </#list>
                                <br/><br/>
                            </div>
                        </#items>
                    </#list>

                </div>
            </div>
        </#if>
        <br>
    </div>
    </div>
    </div>
</div>
    <br>

<div class="col-12" style="text-align: center">
    <#include "copyright-footer.ftlh">
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="/js/stops.js"></script>
</body>
</html>