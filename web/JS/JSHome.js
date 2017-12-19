function hideReadMore(HID)
{
    $('#hrefID'+HID).hide();
}
function showParagraph(HID)
{
    $('#paragraphID'+HID).show();
}
function showButtons(HID)
{
    $('#susID'+HID).show();
    $('#unsusID'+HID).show();
    $('#remID'+HID).show();
}
function Suspend(HID){
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.open("GET","../HomeAjax?HouseID="+HID+"&Suspended=0&remove=0",true);
            
            xmlhttp.send();
            
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    $('#hrefID'+HID).hide();
                    $('#paragraphID'+HID).show();
                }
            }
        }
function UnSuspend(HID){
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.open("GET","../HomeAjax?HouseID="+HID+"&Suspended=1&remove=0",true);
            xmlhttp.send();
            
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    $('#paragraphID'+HID).hide();
                    $('#hrefID'+HID).show();
                }
            }
        }
function remove(HID)
{
    var xmlhttp = new XMLHttpRequest();
            xmlhttp.open("GET","../HomeAjax?HouseID="+HID+"&Suspended=2&remove=1",true);
            xmlhttp.send();
            
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    $('#PID'+HID).hide();
                }
            }
}