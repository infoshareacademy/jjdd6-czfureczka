<div>
    <form class="form-sidebar col-12" id="sidebar">
        <h3 class="heading-statistics">Ulubiony przystanek</h3>

        <div class="form-group">
            <label for="nameStopText" class="align-baseline mr-1">Nazwa przystanku: </label>
            <input type="text" name="nameStop" placeholder="Przystanek" list="stopsList" required/>
            <#if stops??>
            <datalist id="stopsList">
                <#list stops>
                    <#items as stop>
                        <option>${stop}</option>
                    </#items>
                </#list>
            </datalist>
            </#if>
        </div>
        <div class="form-group">
            <label for="tagStop" class="align-baseline mr-1">Tag przystanku:</label>
            <label>
            <input type="text" name="tag" class="form-control" value="Ulubiony">
            </label>
        </div>
        <input class="btn" type="submit" name="save" value="Zapisz" id="button-save"/>

    </form>
</div>