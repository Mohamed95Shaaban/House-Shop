
function EditFunction(accountID) 
{
    
    $('#PID'+accountID).prop('disabled', false);
    
}
function ChangeFunction(accountID)
{
            var xmlhttp = new XMLHttpRequest();
            var pas = document.getElementById("PID"+accountID).value;
            xmlhttp.open("GET","../AdminServlet?AccountID="+accountID+"&PID="+pas,true);
            
            xmlhttp.send();
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    document.getElementById('PID'+accountID).value=pas;
                    $('#PID'+accountID).prop('disabled', true);
                }
            }
}