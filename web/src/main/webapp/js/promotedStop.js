$(function () {

    $(document).ready(function () {

        $('#sidebar').submit(function () {

            event.preventDefault();

            $.ajax({
                url: '/menu',
                type: 'POST',
                data: $(this).serializeArray(),
                success: function (result) {
                    $("#success-alert").show();
                    setTimeout(function() { $("#success-alert").hide(); }, 5000);
                    document.getElementById("sidebar").reset();
                }
            });

        });
    });
});