<div class="col-12">
    <div class="col-12 heading-statistics">
        <h3>Linia ${routeId}</h3>
        <h4>Przystanek: ${stop}</h4>
    </div>
    <div>
        <b>Odjazy: </b>
    <#list time>
        <#items as x>
            <span>${x}, </span>
        </#items>
    </#list>
    </div>
</div>