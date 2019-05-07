$(function () {

    $(document).ready(function () {

        $('#sidebar').submit(function () {

            $.ajax({
                url: '/menu',
                type: 'POST',
                data: $(this).serializeArray(),
                success: function (result) {
                    location.reload();
                }
            });

        });
    });
});