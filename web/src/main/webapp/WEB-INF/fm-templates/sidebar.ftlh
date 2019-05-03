<div class="float-left">
    <form class="form-sidebar col-12" id="sidebar">

        <div class="form-group">
            <label for="nameStopText">Nazwa przystanku: </label>
            <input type="text" name="nameStop" placeholder="Przystanek" list="stopsList" />
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
            <label for="tagStop">Tag przystanku: </label>
            <input type="text" name="tag" class="form-control" value="Ulubiony">
        </div>
        <input type="submit" name="save" value="Zapisz"/>

    </form>
</div>