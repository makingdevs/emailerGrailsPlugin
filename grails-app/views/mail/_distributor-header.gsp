<!-- Wrapper -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
        <td width="100%" valign="top" bgcolor="#ffffff" style="padding-top:8px">

                <!--Start Header-->
    <table width="700" bgcolor="#fff" border="0" cellpadding="0" cellspacing="0" align="center" class="deviceWidth" style="border-bottom:1px solid #CCC">
        <tr>
            <td style="padding: 0">
                <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="deviceWidth">
                    <tr>
                    <g:if test="${distributor?.iconUri}">
                        <td class="center" style="padding: 8px 24px 8px">
                            <img 
                                src="${media.img(uri: distributor?.iconUri )}" height="80px"
                            >
                        </td>
                    </g:if>

                    <td width="50%" style="text-align:right; padding-right:32px; font-size: 16px; color:#999">
                        ${distributor?.name}, ${tenant?.niceName}
                    </td>
                    </tr>
                </table>
           </td>
        </tr>
    </table> 
    </td>
    </tr>
</table>
    <!--End Header-->