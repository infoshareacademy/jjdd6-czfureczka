$(function () {

    $(document).ready(function () {

        $(".modeOfTransportation").click(function () {
            $.ajax({
                url: '/stopTimes?routeId=' + $(this).attr('data-id'),
                type: 'GET'
            })
        })
    })
});