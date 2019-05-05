<#if routeId??>
    <div class="col-12 heading-statistics">
        <h3>Linia ${routeId}</h3>
    </div>
</#if>

<div class="row">
    <#if listStops??>
        <#list listStops>
            <#items as tripWithStops>

                <div class="list-group col-6">

                    <button type="button" class="list-group-item list-group-item-action"
                            style="background-color: mediumseagreen !important; color: white; cursor: auto;">
                        <b>Kierunek: ${tripWithStops.stopEnd}</b></button>

                    <#list tripWithStops.stops>
                        <#items as stop>
                            <button type="button" class="list-group-item list-group-item-action"
                                    style="color: black;">${stop}</button>
                        </#items>
                    </#list>

                </div>

            </#items>
        </#list>
    </#if>
</div>