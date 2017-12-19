function hideReadMore(HID)
{
    $('#hrefID'+HID).hide();
}
function showParagraph(HID)
{
    $('#paragraphID'+HID).show();
}
function showSusButtons(HID)
{
    $('#susID'+HID).show();
    $('#unsusID'+HID).show();
}
function Suspend(HID){
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.open("GET","../HomeAjax?HouseID="+HID+"&Suspended=0",true);
            
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
            xmlhttp.open("GET","../HomeAjax?HouseID="+HID+"&Suspended=1",true);
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
