<!DOCTYPE html>
<html>
<head>
    <title>Szybko do celu</title>
    <meta charset="UTF-8">
</head>
<body>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>

<h1>Witaj!</h1>
<p>Liczba wejsc: ${counter}</p>

<form enctype="multipart/form-data">
    Przystanek: <input type="text" name="stop" placeholder="Przystanek"><br/><br/>
    Linia: <input type="number" min="1" name="routeId" placeholder="2"><br/><br/>
    <input type="submit" name="save" value="Sprawdź"/><br/><br/>
</form>
 <p>Przystanek: ${(stopDesc?string('yes', 'no'))! ""}</p>
<p> Linia: ${(routeId?string('yes', 'no'))! ""}</p>

<#--<#list stops>-->
<#--    <#items as names>-->
<#--        <ul>-->
<#--            <li>${names}</li>-->
<#--        </ul>-->
<#--    </#items>-->
<#--</#list>-->
<script src="/js/menu.js"></script>
</body>
</html>
