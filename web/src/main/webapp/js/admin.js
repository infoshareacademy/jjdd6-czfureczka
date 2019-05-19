$(function () {

    $(document).ready(function () {

        $('#addNewAdministrator').submit(function () {

            event.preventDefault();

            $.ajax({
                url: '/admin',
                type: 'POST',
                data: $(this).serializeArray(),
                success: function (result) {
                    location.reload();
                }
            });

        });

        $('#edit').submit(function () {

            event.preventDefault();

            $.ajax({
                url: '/admin',
                type: 'PUT',
                data: $(this).serializeArray(),
                success: function (result) {
                    location.reload();
                }
            });

        });

        $('#delete').submit(function () {

            event.preventDefault();

            $.ajax({
                url: '/admin',
                type: 'DELETE',
                data: $(this).serializeArray(),
                success: function (result) {
                    location.reload();
                }
            });

        });
    });
});