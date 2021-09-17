<%-- 
    Document   : createinvoice
    Created on : 29-Jul-2014, 02:47:03
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Invoice type.</title>
        <%@include file="lookup.jsp" %>
        <script type="text/javascript">
            function submitForm(gt){
			$(gt).form('submit');
                        
		}
        </script>
    </head>
    <body
        <%
        TimeZone tzone =TimeZone.getTimeZone("Africa/Lagos");
        
        Calendar cal = new GregorianCalendar(tzone);
        long tt = cal.getTimeInMillis();
        
         String invoicedesc = request.getParameter("invoicedesc");
         String invoicetype = request.getParameter("invoicetype");
         String type=invoicetype;
         String invoicecode= new Long(tt).toString();
         if(invoicedesc!=null && invoicedesc!=""){
             boolean isCreated = iL.createInvoiceType(invoicedesc.substring(0, 2).toUpperCase() +invoicecode, invoicedesc, type);
             if(isCreated==true){
                 out.println("<script type=\"text/javascript\">alert(\"Invoice created successfully\");</script>");
             }else if(isCreated==false){
                 out.println("<script type=\"text/javascript\">alert(\"Invoice Not Created.\");</script>");
             }
         }
        %>
        <center>
         <img src="Header" height="100" width="100%" alt="header" border="0"/>
     <div style="background-color:whitesmoke;width:100%;height:550px;padding-top:0px;  ">
         <div class="easyui-panel" style="padding:5px;">
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-back'" onclick="history.go(-1)">Back</a>
	</div>
         <center>
         <div class="easyui-panel" title="CREATE INVOICE" style="width:500px;height:250px;padding-top:5px; ">
         
             <center>
        <form method="post" action="" name="frm" id="frm" >
            
            <table width="90%" >
                
                <tr><td>Invoice Description </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="invoicedesc" style="width:200px;"  data-options="required:true"></input> </td>
                </tr>
                <tr><td>Type </td>
                    <td>
                    <select class="easyui-combobox" name="invoicetype" style="width:200px;" data-options="required:true">
                        <option value="DI">DESIGNATED INVOICE</option>
                        <option value="GEN">GENERAL INVOICE</option>
                    </select> 
                    </td>
                </tr>
                
                                
            </table>
               
            
        </form>
                 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm('#frm')" style='width:100px; '>Create</a> 
               </center>
         </div>
         </center>
     </div>
        </center>
    </body>
</html>
