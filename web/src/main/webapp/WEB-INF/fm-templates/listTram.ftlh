<div class="col-12">

    <#if tram??>
        <b>Tramwaje:</b>
        <#setting number_format="computer">

        <#list tram>
            <#items as routeWithModeOfTransportation>
                <span><input class="btn modeOfTransportation" type="button"
                             data-id="${routeWithModeOfTransportation.routeId}"
                             value=${routeWithModeOfTransportation.routeShortName}></span>
            </#items>
        </#list>

    </#if>

</div>