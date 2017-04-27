<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <g:set var="bgColor" value="${tenant?.mainColor ?: '#1F9647'}" />
  <tmpl:/_common/email-styles />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
    .ReadMsgBody {width: 100%; background-color: #ffffff;}
    .ExternalClass {width: 100%; background-color: #ffffff;}
    body {
      width: 100%; 
      background-color: #ffffff; 
      margin:0; 
      padding:0; 
      -webkit-font-smoothing: antialiased;
      font-family: Arial, Helvetica, sans-serif;
      border-top: 8px solid ${bgColor};
    }

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

<body 
  leftmargin="0" 
  topmargin="0" 
  marginwidth="0" 
  marginheight="0" 
  yahoo="fix" 
  style="font-family: Arial, Helvetica, sans-serif"
>

  <tmpl:/mail/distributor-header tenant="${tenant}" distributor="${distributor}" />

<table width="700" border="0" cellpadding="0" cellspacing="0" align="center" class="deviceWidth" style="margin:4px auto 16px">
    <tr>
      <td valign="top" style="font-size: 16px; color: #303030; font-family: Arial, Helvetica, sans-serif; line-height: 22px; vertical-align: middle; padding: 20px 10px 20px;">
        <div class="alert alert-info" role="alert">${message}</div>
      </td>
     </tr>

    <tr>
        <td align="center" style="padding-top:24px; padding-bottom: 16px; margin-bottom: 16px">
            <table width="60%">
                <tr>
                  <td bgcolor="${bgColor}" style="${tdButtonStyle}; background-color: ${bgColor}" align="center">
                    <a href="${link}"
                      target="_blank" style="${buttonStyle}">
                       <g:message code="comparative.show.button" locale="${lang}" /> &rarr;
                    </a>
                  </td>
                </tr>

            </table>
        </td>
    </tr>

    <tr>
      <td valign="top" style="font-size: 16px; color: #303030; font-family: Arial, Helvetica, sans-serif; line-height: 22px; vertical-align: middle; padding: 16px 20px">
        <g:message code="comparative.more.info" locale="${lang}" />

        <ul style="margin-bottom: 0">
          <li>${reporter?.email}</li>
          
           <g:if test="${reporter?.profile != null}">
             <g:if test="${reporter?.profile?.phone != null}">
              <li>${reporter?.profile}</li>
              </g:if>
           </g:if>
        </ul>
      </td>
     </tr>

     <tr>
       <td style="font-size: 16px; color: #303030; font-family: Arial, Helvetica, sans-serif; line-height:1.25; vertical-align: middle; padding: 8px 20px 8px 24px;">
          <small>
          <g:message code="button.click.alternative" locale="${lang}" /> <br />
          ${link} <br>
          <g:message code="password.reset.expiracy" args="[tokenExpiry]" locale="${lang}" /> 
        </small>
       </td>
     </tr>
</table>

<table width="700" border="0" cellpadding="0" cellspacing="0" align="center" class="deviceWidth" style="margin:12px auto 16px">
  <tr>  
     <th style="${lineCell}; padding-top: 16px; width: 82px;" colspan="1">
        %{-- Show distributor icon or icon uri --}%
        <img src="${media?.img(uri: reporter?.iconUri ?: distributor?.iconUri )}" 
              alt="${ distributor?.iconUri  }"
             style="max-height: 94px; max-width: 100%; margin-top:4px; margin-left:4px">
    </th>
    
    <th style="${lineCell}; padding-top: 20px" colspan="1">
         <p style="${tableTitle}">
            ${reporter?.name}
         </p>
         
         <p style="${thText}">${reporter?.email}</p>
         <p style="${thText}">
            ${reporter?.distributor?.name}, ${tenant?.niceName}
        </p>
    </th>
  </tr>
</table>

<table style="width: 100%; background-color:#EAEAEA"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td style="color: #999; font-size: 12px; text-align: center; padding: 24px">
      © Book&Learn. <em>The smartest way to book.</em>
    </td>
  </tr>
</table>

</body>
</html>
