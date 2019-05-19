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

    <#if google_name??>
        <h3 class="heading-statistics">Zalogowany jako: ${google_name}</h3>
    </#if>

    <div class="col-12">
        <h3 class="heading-statistics">Wyznaczanie trasy</h3>
    </div>

    <div class="row">
        <form class="col-12" id="trip" method="get">
            <#include "initialStop.ftlh">
            <#include "destinationStop.ftlh">
            <input class="btn" type="submit" name="search" value="Szukaj" id="button-check"/>
        </form>
    </div>

    <div class="row" style="margin-top: 30px">

        <#if deficiency??>
            <div class="col-12">
                Przystanek początkowy nie został podany.
            </div>
        </#if>

        <#if noConnection??>
            <div class="col-12">
                Brak połączenia :(
            </div>
        </#if>

        <#if trip??>
            <div class="col-12">
                Możesz pojechać:
                <#list trip>
                    <#items as route>
                        <span>${route}<#sep>, </#sep></span>
                    </#items>
                </#list>
            </div>
        </#if>

        <#if transfer??>
            <div class="col-12">


                <#list transfer>
                    <#items as tripWithTransfer>
                        <div>
                            Należy pojechać linią:

                            <#list tripWithTransfer.routeStart>
                                <#items as route>
                                    <span>${route}<#sep>, </#sep></span>
                                </#items>
                            </#list>
                            <br/>

                            Przesiadka na: ${tripWithTransfer.stop}<br/>

                            Następnie jedź:

                            <#list tripWithTransfer.routeEnd>
                                <#items as routeEnd>
                                    <span>${routeEnd}<#sep>, </#sep></span>
                                </#items>
                            </#list>
                            <br/><br/>
                        </div>
                    </#items>
                </#list>

            </div>
        </#if>

    </div>


    <#include "copyright-footer.ftlh">
</div>

<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<#--<script src="/js/trip.js"></script>-->

</body>
</html>