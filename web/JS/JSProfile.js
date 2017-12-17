

function EditFunction() 
{
    $('#nameID').prop('disabled', false);
    $('#e-mailID').prop('disabled', false);
    $('#passID').prop('disabled', false);
    $('#phoneID').prop('disabled', false);
    $('#ChangeId').show();
    
}
function ChangeFunction()
{
    document.getElementById("form_id").submit();
    $('#nameID').prop('disabled', true);
    $('#e-mailID').prop('disabled', true);
    $('#passID').prop('disabled', true);
    $('#phoneID').prop('disabled', true);
    $('#ChangeId').hide() ;
    
}