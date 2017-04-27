<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
    .ReadMsgBody {width: 100%; background-color: #ffffff;}
    .ExternalClass {width: 100%; background-color: #ffffff;}
    body     {width: 100%; background-color: #ffffff; margin:0; padding:0; -webkit-font-smoothing: antialiased;font-family: Arial, Helvetica, sans-serif}
    table {border-collapse: collapse;}
    
    @media only screen and (max-width: 640px)  {
                    body[yahoo] .deviceWidth {width:440px!important; padding:0;}    
                    body[yahoo] .center {text-align: center!important;}  
            }
            
    @media only screen and (max-width: 479px) {
                    body[yahoo] .deviceWidth {width:280px!important; padding:0;}    
                    body[yahoo] .center {text-align: center!important;}  
            }
</style>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" yahoo="fix" style="font-family: Arial, Helvetica, sans-serif">
    <!-- Wrapper -->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
        <tr>
            <td width="100%" valign="top" bgcolor="#ffffff" style="padding-top:8px">

                <!--Start Header-->
    <table width="700" bgcolor="#fff" border="0" cellpadding="0" cellspacing="0" align="center" class="deviceWidth">
        <tr>
            <td style="padding: 12px 0px 12px"  bgcolor="#f7f7f7">
                <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="deviceWidth">
                    <tr>
                        %{-- When we have a distributor the info if shown --}%
                        <g:if test="${distributor}">
                            <td class="center" width="50%" style="padding: 8px 32px 8px">
                                <g:if test="${distributor.iconUri}">
                                    <img src="${media.img(uri:distributor.iconUri)}" height="64px">
                                </g:if>
                            </td>
                            <td width="50%" style="text-align:right; padding-right:32px; font-size: 16px; color:#999">
                                ${distributor.name}
                            </td>
                        </g:if>
                        %{-- No distributor default header --}%
                        <g:else>
                            <td class="center" style="padding: 20px 32px 10px; font-size: 16px;">
                                <a href="http://bookandlearn.com">Book & Learn</a>
                            </td>
                        </g:else>
                    </tr>
                </table>
           </td>
        </tr>
    </table> 
    <!--End Header-->