<div class="form-group">

    <label for="initialStopText">Nazwa przystanku początkowego: </label>
    <input type="text" name="initialStop" placeholder="Przystanek" list="initialList"/>

    <datalist id="initialList">

        <#if promotedStops??>
            <#list promotedStops>
                <#items as pS>
                    <option><b>${pS.tag}</b>: ${pS.name}</option>
                </#items>
            </#list>
        </#if>

        <#if stops??>
            <#list stops>
                <#items as stop>
                    <option>${stop}</option>
                </#items>
            </#list>
        </#if>
    </datalist>

</div>