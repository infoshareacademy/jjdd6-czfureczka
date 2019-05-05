$(function () {

    $(document).ready(function () {

        $(".modeOfTransportation").click(function () {

            window.location.replace('/stopTimes?routeId=' + $(this).attr('data-id'))

        })
    })
});