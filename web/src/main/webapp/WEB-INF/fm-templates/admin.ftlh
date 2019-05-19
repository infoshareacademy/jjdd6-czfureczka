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
    <#if administrator??>
    <div class="row">
        <div class="col-12">
            <h3 class="heading-statistics">Dodaj nowego administratora</h3>
        </div>
    </div>

    <form id="addNewAdministrator">
        <div class="form-group row">
            <label for="email" class="col-md-1 offset-md-2 col-form-label mr-0">Email:</label>
            <div class="col-md-6">
                <input type="email" class="form-control" id="email" placeholder="Email" name="email">
            </div>
        </div>

        <#include "permissions.ftlh">

        <div class="form-group row">
            <div class="col-sm-6 offset-4">
                <button type="submit" class="btn btn-primary button-admin">Dodaj</button>
            </div>
        </div>
    </form>

    <div class="row">
        <div class="col-12">
            <h3 class="heading-statistics">Edytuj dane administratora</h3>
        </div>
    </div>

    <form id="edit">
        <div class="form-group row">
            <label for="email1" class="col-md-1 offset-md-2 col-form-label mr-0">Email:</label>
            <div class="col-md-6">
                <input type="email" class="form-control" id="email1" placeholder="Email" name="email">
            </div>
        </div>

        <div class="form-group row">
            <div class="col-md-2 offset-md-2 mr-0">Uprawnienia:</div>
            <div class="col-md-6">
                <div class="form-check custom-switch">
                    <input type="checkbox" class="custom-control-input" id="switch3" name="addNewAdministrator">
                    <label class="custom-control-label" for="switch3">Dodawanie nowego administartora</label>
                </div>
                <div class="form-check custom-switch">
                    <input type="checkbox" class="custom-control-input" id="switch4" name="deleteAdministrator">
                    <label class="custom-control-label" for="switch4">Usuwanie/edycja administratora</label>
                </div>
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-6 offset-4">
                <button type="submit" class="btn btn-primary button-admin">Edytuj</button>
            </div>
        </div>
    </form>

    <div class="row">
        <div class="col-12">
            <h3 class="heading-statistics">Usuń administratora</h3>
        </div>
    </div>

    <form id="delete">
        <div class="form-group row">
            <label for="email2" class="col-md-1 offset-md-2 col-form-label mr-0">Email:</label>
            <div class="col-md-6">
                <input type="email" class="form-control" id="email2" placeholder="Email" name="email">
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-6 offset-4">
                <button type="submit" class="btn btn-primary button-admin">Usuń</button>
            </div>
        </div>
    </form>

<#else>
    <h2 class="heading-statistics">Brak uprawnień</h2>
</#if>
</div>

<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="/js/admin.js"></script>
</body>
</html>