<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <div class="input-group date" id="datetimepicker3" data-target-input="nearest">
                    <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker3"/>
                    <div class="input-group-append" data-target="#datetimepicker3" data-toggle="datetimepicker">
                        <div class="input-group-text"><i>⌛</i></div>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            $(function () {
                $('#datetimepicker3').datetimepicker({
                    format: 'LT',
                    locale: 'pl'
                });
            });
        </script>
    </div>
</div>