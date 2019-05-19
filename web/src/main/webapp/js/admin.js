$(function () {

    $(document).ready(function () {

        $('#addNewAdministrator').submit(function () {

            event.preventDefault();

            $.ajax({
                url: '/admin',
                type: 'POST',
                data: $(this).serializeArray(),
                success: function (result) {
                    $("#success-alert-add").show();
                    setTimeout(function() { $("#success-alert-add").hide(); }, 5000);
                    document.getElementById("addNewAdministrator").reset();
                    //location.reload();
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
                    $("#success-alert-edit").show();
                    setTimeout(function() { $("#success-alert-edit").hide(); }, 4000);
                    document.getElementById("edit").reset();
                    //location.reload();
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
                    $("#success-alert-delete").show();
                    setTimeout(function() { $("#success-alert-delete").hide(); }, 4000);
                    document.getElementById("delete").reset();
                    //location.reload();
                }
            });

        });
    });
});