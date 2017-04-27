%{-- 
  Since emial doesn't play nice with external css all styles are saved in variblaes
  to add in every elment
 --}%

%{-- Style for table headers --}%
<g:set var="theadStyle" scope="request">
    padding:4px;
    font-size:11px; 
    font-weight:300;
    text-transform:uppercase;
    background-color: #CCC;
</g:set>
<g:set var="thLgStyle" scope="request">
    padding:6px 10px;
    font-weight:300;
    background-color: #CCC;
</g:set>
<g:set var="counterStyle" scope="request">
    font-size: 36px; 
    line-height:1.5; 
    margin:0;
    background-color:white;
</g:set>
<g:set var="counterSmallStyle" scope="request">
    font-size: 32px;
    line-height:1.5; 
    margin:0;
    color: gray;
</g:set>

<g:set var="infoAlert" scope="request">
   background-color: #d9edf7;
   border-color: #bce8f1;
   padding: 8px 16px;
</g:set>

<g:set var="smallAlert" scope="request">
   background-color: white;
   border-color: none;
   padding: 8px 16px;
   font-size: 11px;
</g:set>

<g:set var="tableTitle" scope="request">
  font-size: 18px;
  line-height: 1.25;
  margin:0;
  font-weight: normal;
</g:set>

<g:set var="tableTitle2" scope="request">
  font-size: 16px;
  line-height: 1.25;
  margin:0;
  font-weight: normal;
  white-space: nowrap;
</g:set>

<g:set var="tableTitle0" scope="request">
  font-size: 20px;
  line-height: 1.25;
  margin:0;
  white-space: nowrap;
</g:set>

<g:set var="lineCell" scope="request">
    font-weight: 400;
    text-align: left;
    vertical-align:top;
    border-top: 1px solid #CCC;
    padding: 8px 12px 8px;
</g:set>
<g:set var="feeCell" scope="request">
  font-size: 12px;
  padding: 4px 12px;
  background-color:#EAEAEA;
</g:set>
%{-- Estilo de texto para encabezados --}%
<g:set var="thText" scope="request">
  margin:0;
  line-height: 1.25;
  font-size: 14px;
</g:set>
%{-- Estilso de texto normal --}%
<g:set var="thText" scope="request">
  margin:0;
  line-height: 1.25;
  font-size: 12px;
</g:set>
<g:set var="hrStyle" scope="request">
  border: 1px solid #DDD !important;
  border-bottom-width: 0px;
</g:set>



<g:set var="tdButtonStyle" scope="request">
padding: 24px 18px 24px 18px; 
-webkit-border-radius:3px; 
border-radius:3px;
background-color: #1F9647;
</g:set>

<g:set var="buttonStyle" scope="request">
font-size: 16px; 
font-family: Helvetica, Arial, sans-serif; 
font-weight: normal; 
color: #ffffff; 
text-decoration: none; 
display: inline-block;
</g:set>

<g:set var="smallCell" scope="request">
width: 1px;
white-space: nowrap;
</g:set>