$(function () {
    $('.selectpicker').selectpicker();
});

$('.input-group.date').datepicker({
    format: "dd/mm/yyyy",
    startView: 2,
    clearBtn: true,
    daysOfWeekHighlighted: "0,6"
});
$('#customFile').on('change', function () {
    //get the file name
    var fileName = $(this).val();
    //replace the "Choose a file" label
    $('#file-label').html(fileName);
});

function validate() {
    if (document.f.username.value === "" && document.f.password.value === "") {
        alert("${noUser} and ${noPass}");
        document.f.username.focus();
        return false;
    }
    if (document.f.username.value === "") {
        alert("${noUser}");
        document.f.username.focus();
        return false;
    }
    if (document.f.password.value === "") {
        alert("${noPass}");
        document.f.password.focus();
        return false;
    }
}
