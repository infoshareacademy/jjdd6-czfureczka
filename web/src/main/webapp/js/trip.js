$(function () {

    $(document).ready(function () {

        $('#trip').submit(function () {

            $.ajax({
                url: '/stops',
                type: 'GET',
                data: $(this).serializeArray(),
            });

        });
    });
});