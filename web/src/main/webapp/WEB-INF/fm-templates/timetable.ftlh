<div class="col-12">
    <div class="col-12 heading-statistics">
        <h3>Linia ${routeId}</h3>
        <h4>Przystanek: ${stop}</h4>
    </div>
    <div class="content">
        <b>Odjazy: </b>
    <#list time>
        <#items as x>
            <span>${x}<#sep>,</#sep></span>
        </#items>
    </#list>
    </div>
</div>