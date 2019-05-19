<div id="carouselSlides" class="carousel slide " data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active text-center">
            <img src="${firstPhoto}" class="rounded errorImage" alt="A sad animal">
        </div>
        <#list images>
            <#items as image>
                <div class="carousel-item text-center">
                    <img src="${image}" class="rounded errorImage" alt="A sad animal">
                </div>
            </#items>
        </#list>
    </div>
</div>