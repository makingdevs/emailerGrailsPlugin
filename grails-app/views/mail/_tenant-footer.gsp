      <!-- Footer -->
        <div style="height:15px">&nbsp;</div><!-- divider-->

        <table width="700"  border="0" cellpadding="0" cellspacing="0" align="center" class="deviceWidth">
              <tr>
                <td class="center" style="
                font-size: 12px; 
                color: #999; 
                font-weight: bold; 
                text-align: center; 
                font-family: Arial, Helvetica, sans-serif; 
                line-height: 25px; 
                vertical-align: middle; 
                padding: 16px 50px 32px 50px;
                border-top:1px solid #EAEAEA;
                ">  
                <g:if test="${tenant}">${tenant.niceName}</g:if>
                <g:else>
                    © <g:formatDate format="yyyy" date="${new Date()}"/> <g:message code="app.name" />
                </g:else>
                </td>
            </tr>
        </table>
        <!--End Footer-->

        <div style="height:15px">&nbsp;</div><!-- divider-->

        </td>
    </tr>
</table> 
<!-- End Wrapper -->
</body>
</html>
