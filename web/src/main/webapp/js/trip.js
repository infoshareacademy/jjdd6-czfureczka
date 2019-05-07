$(function () {

    $(document).ready(function () {

        $('#trip').submit(function () {

            $.ajax({
                url: '/transfer',
                type: 'GET',
                data: $(this).serializeArray(),
            });

        });
    });
});