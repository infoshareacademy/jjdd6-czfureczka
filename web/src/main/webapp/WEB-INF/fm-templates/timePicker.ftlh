<div>
    <div>

        <div class="form-group">
            <label class="align-baseline mr-1">Godzina odjazdu:</label>
            <label>
                <div class="input-group date" id="datetimepicker3" data-target-input="nearest">
                    <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker3"
                           name="time"/>
                    <div class="input-group-append" data-target="#datetimepicker3" data-toggle="datetimepicker">
                        <div class="input-group-text"><i>⌛</i></div>
                    </div>
                </div>
            </label>
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