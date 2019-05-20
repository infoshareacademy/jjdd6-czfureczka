$(function () {

    $(document).ready(function () {

        $(".modeOfTransportation").click(function () {

            window.location.replace('/stopTimes?routeId=' + $(this).attr('data-id'))
            $("#spinner").show()

        });

        $(".stop-button").click(function () {
            window.location.replace('/stopTimes' + $(this).attr('data'))
            $("#spinner").show()
        })
    })
});