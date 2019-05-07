<div class="col-12">

    <#if bus??>
        <b>Autobusy:</b>
        <#setting number_format="computer">

        <#list bus>
            <#items as routeWithModeOfTransportation>
                <span><input class="btn modeOfTransportation" type="button"
                             data-id="${routeWithModeOfTransportation.routeId}"
                             value=${routeWithModeOfTransportation.routeShortName}></span>
            </#items>
        </#list>

    </#if>

</div>
