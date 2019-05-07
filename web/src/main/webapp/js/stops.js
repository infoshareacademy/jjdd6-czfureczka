$(function () {

    $(document).ready(function () {

        $('form').submit(function () {

            $.ajax({
                url: '/stops',
                type: 'GET',
                data: $(this).serializeArray(),
            });

        });
    });
});