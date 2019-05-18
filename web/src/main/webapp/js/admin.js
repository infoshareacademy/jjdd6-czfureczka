$(function () {

    $(document).ready(function () {

        $('#addNewAdministrator').submit(function () {

            $.ajax({
                url: '/admin',
                type: 'POST',
                data: $(this).serializeArray(),
            });

        });

        $('#edit').submit(function () {

            $.ajax({
                url: '/admin',
                type: 'PUT',
                data: $(this).serializeArray(),
            });

        });

        $('#delete').submit(function () {

            $.ajax({
                url: '/admin',
                type: 'DELETE',
                data: $(this).serializeArray(),
            });

        });
    });
});