<div class="col-12">

    <#if trolleybus??>
        <b>Trolejbusy:</b>
        <#setting number_format="computer">

        <#list trolleybus>
            <#items as routeWithModeOfTransportation>
                <span><input class="btn modeOfTransportation" type="button"
                             data-id="${routeWithModeOfTransportation.routeId}"
                             value=${routeWithModeOfTransportation.routeShortName}></span>
            </#items>
        </#list>

    </#if>

</div>