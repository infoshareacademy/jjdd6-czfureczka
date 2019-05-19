$(function () {

    $(document).ready(function () {

        $('#stops-form').submit(function () {

            event.preventDefault();

            $.ajax({
                url: '/stops',
                type: 'GET',
                data: $(this).serializeArray(),
                success: function (result) {
                $("#stops-result").show();
                document.getElementById("stops-form").reset();
                }
            });

        });
    });
});