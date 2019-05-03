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
<#include "sidebar.ftlh">

<div class="container content">
    <h1>Wyznaczanie trasy</h1>


    <div class="row">
        <form class="col-12" id="trip">
            <#include "initialStop.ftlh">
            <#include "destinationStop.ftlh">
            <input type="submit" name="search" value="Szukaj"/>
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
                <ul>
                    <#list trip>
                        <#items as route>
                            <li>${route}</li>
                        </#items>
                    </#list>
                </ul>
            </div>
        </#if>

        <#if transfer??>
            <div class="col-12">
                <ol>

                    <#list transfer>
                        <#items as tripWithTransfer>
                            <li>
                                Należy pojechać linią:

                                <#list tripWithTransfer.routeStart>
                                    <#items as route>
                                        <span>${route}, </span>
                                    </#items>
                                </#list>
                                <br/>

                                Przesiadka na: ${tripWithTransfer.stop}<br/>

                                Następnie jedź:

                                <#list tripWithTransfer.routeEnd>
                                    <#items as routeEnd>
                                        <span>${routeEnd}</span>
                                    </#items>
                                </#list>
                                <br/><br/>
                            </li>
                        </#items>
                    </#list>

                </ol>
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
<script src="/js/promotedStop.js"></script>
<script src="/js/trip.js"></script>

</body>
</html>