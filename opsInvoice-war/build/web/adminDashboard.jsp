<%-- 
    Document   : adminDashboard
    Created on : 28-Jul-2014, 02:55:05
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Board</title>
        <%@include file="lookup.jsp" %>
    </head>
    <body>
    <center>
         <img src="Header" height="100" width="100%" alt="header" border="0"/>
     <div style="background-color:whitesmoke;width:100%;height:550px;padding-top:0px;  ">
         
         <div class="easyui-panel" style="padding:5px;">
		<a href="#" class="easyui-linkbutton" data-options="plain:true" onclick="document.location='Logout';">Logout</a>
		
	</div>
         <table width="60%" style="padding-top:80px;color:green">
             <tr>
                 <td width="25%" align="center">
                     <a href="CreateUser"><img src="images/house.JPG" height="100" width="200" border="1"/></a>
                     <br>
                     Create User
                     
                 </td>
                 <td width="25%" align="center">
                     <a href="Uploadheader"><img src="images/connector.GIF" height="100" width="200" border="1"/></a>
                     <br>
                     Setup Header
                 </td>
                 <td width="25%" align="center">
                     <a href="Viewallusers"><img src="images/allu.gif" height="100" width="200" border="1"/></a>
                     <br>
                     View All Users
                 </td>
                 <td width="25%" align="center">
                     <a href="Changepassword"><img src="images/changeu.gif" height="100" width="200" border="1"/></a>
                     <br>
                     Change Password
                 </td>
             </tr>
             <tr>
                 <td width="25%" align="center">
                     <a href="CreateInvoiceType"><img src="images/in.gif" height="100" width="200" border="1"/></a>
                     <br>
                     Create Invoice Type
                 </td>
                 <td width="25%" align="center">
                     <a href="CreateInvoiceItems"><img src="images/inv.gif" height="100" width="200" border="1"/></a>
                     <br>
                     Create Invoice Items
                 </td>
                 <td width="25%" align="center">
                     <a href="DesignatedInvoice"><img src="images/invoice1.jpg" height="100" width="200" border="1"/></a>
                     <br>
                     Designated Invoice
                 </td>
                 <td width="25%" align="center">
                     <a href="GenInvoice"><img src="images/invoice2.jpg" height="100" width="200" border="1"/></a>
                     <br>
                     General Invoice
                 </td>
             </tr>
             <tr>
                 <td width="25%" align="center">
                     <a href="CompanyInfo"><img src="images/vdi.gif" height="100" width="200" border="1"/></a>
                     <br>
                     Create Company Information.
                 </td>
                 <td width="25%" align="center">
                     <a href="InvoicebyName"><img src="images/vgi.gif" height="100" width="200" border="1"/></a>
                     <br>
                     View Invoice By Name.
                 </td>
                 <td width="25%" align="center">
                     <a href="DateRangeInvoice"><img src="images/datein.gif" height="100" width="200" border="1"/></a>
                     <br>
                     View Date Report
                 </td>
                 <td width="25%" align="center">
                     <a href="InvoicebyTransid"><img src="images/searchinv.gif" height="100" width="200" border="1"/></a>
                     <br>
                     Search Invoice By Transid.
                 </td>
             </tr>
         </table>
     </div>
    </center>
    </body>
</html>
