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
    <div class="row">

        <div class="col-12 col-sm-6">
            <div class="col-12 heading-statistics">
                <h3>Najpopularniejszy przystanek </h3>
            </div>

            <div class="col-12" style="text-align: center">
                <#if result??>

                    <ol class="list-group">
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            ${result.name}
                            <span class="badge navbar-bg badge-pill badge-dark">
                        ${result.quantity}
                    </span>
                        </li>
                    </ol>

                </#if>
            </div>
        </div>

        <div class="col-12 col-sm-6">
            <div class="col-12 heading-statistics">
                <h3>Najpopularniejsza linia </h3>
            </div>

            <div class="col-12" style="text-align: center">
                <#if resultRoute??>

                    <ol class="list-group">
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            ${resultRoute.name}
                            <span class="badge navbar-bg badge-pill badge-dark">
                        ${resultRoute.quantity}
                    </span>
                        </li>
                    </ol>

                </#if>
            </div>
        </div>
    </div>
    <div class="row">
        <form enctype="multipart/form-data" class="form-statistics col-12">

            <label class="align-baseline mr-1">Ilość przystanków w rankingu:</label>
            <label> <input type="number" min="1" name="popularStops" value="1"></label>
            <br/>
            <label class="align-baseline mr-1">Ilość linii w rankingu:</label>
            <label><input type="number" min="1" name="popularRoutes" value="1"></label>
            <br/>
            <label><input type="submit" value="Wyświetl"/></label>
        </form>


        <div class="col-12">
            <div class="col-12 heading-statistics">
                <h3>Ranking najpopularniejszych przystanków</h3>
            </div>

            <div class="col-6 offset-3" style="text-align: center">
                <ol class="list-group">

                    <#if popularStops??>
                        <#list popularStops>
                            <#items as x>

                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    ${x.name}
                                    <span class="badge navbar-bg badge-pill badge-dark">${x.quantity}</span>
                                </li>

                            </#items>
                        </#list>
                    </#if>

                </ol>
            </div>
        </div>

        <div class="col-12">
            <div class="col-12 heading-statistics">
                <h3>Ranking najpopularniejszych linii</h3>
            </div>

            <div class="col-6 offset-3" style="text-align: center">
                <ol class="list-group">

                    <#if popularRoutes??>
                        <#list popularRoutes>
                            <#items as y>

                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    ${y.name}
                                    <span class="badge navbar-bg badge-pill badge-dark">${y.quantity}</span>
                                </li>

                            </#items>
                        </#list>
                    </#if>

                </ol>
            </div>
        </div>

        <div class="col-12" style="text-align: center; margin-top: 50px">
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
</body>
</html>