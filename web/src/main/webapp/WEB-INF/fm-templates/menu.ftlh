<!DOCTYPE html>
<html>
<head>
    <title>Szybko do celu</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Witaj!</h1>
<p>Liczba wejsc: ${counter}</p>
<#list stops>
    <#items as names>
        <ul>
            <li>${names}</li>
        </ul>
    </#items>
</#list>

</body>
</html>
