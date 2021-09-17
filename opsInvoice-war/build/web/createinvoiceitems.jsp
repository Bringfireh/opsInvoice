<%-- 
    Document   : createinvoiceitems
    Created on : 29-Jul-2014, 02:48:01
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Invoice Items</title>
        <%@include file="lookup.jsp" %>
        <script type="text/javascript">
            function submitForm(gt){
			$(gt).form('submit');
                        
		}
        </script>
    </head> 
    <body>
        <%
        String itemcode = request.getParameter("itemcode");
        String itemdesc = request.getParameter("itemdesc");
        String amt = request.getParameter("amount");
        String invoicecode = request.getParameter("invoicetype");
        if(itemcode!=null && itemcode!="" && itemdesc!=null && itemdesc!=""){
            boolean isCreated=iL.createInvoiceItems(itemcode, itemdesc, new Double(amt), invoicecode);
            if(isCreated==true){
                out.println("<script type=\"text/javascript\">alert(\"Invoice Item created successfully\");</script>");
            }else if(isCreated==false){
                out.println("<script type=\"text/javascript\">alert(\"Could Not create Invoice Item\");</script>");
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
         <div class="easyui-panel" title="CREATE INVOICE ITEM" style="width:500px;height:250px;padding-top:5px; ">
         
             <center>
        <form method="post" action="" name="frm" id="frm" >
            
            <table width="90%" >
                
                <tr><td>Item Code </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="itemcode" style="width:200px;"  data-options="required:true"></input> </td>
                </tr>
                <tr><td>Item Description </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="itemdesc" style="width:200px;"  data-options="required:true"></input> </td>
                </tr>
                <tr><td>Amount </td>
                    <td><input class="easyui-numberbox" name="amount" data-options="precision:2,groupSeparator:',',required:true" style="width:200px;"></input></td>
                </tr>
                <tr>
                    <td>Invoice</td>
                    <td>
                        <select class="easyui-combobox" name="invoicetype" style="width:200px;" data-options="required:true">
                            <% 
                            ArrayList al = iL.viewAllInvoiceTypes("DI");
                            Iterator it =al.iterator();
                            while(it.hasNext()){
                                InvoiceType ite=(InvoiceType)it.next();
                                
                            
                            
                            %>
                            <option value="<%=ite.getInvoicecode() %>"><%=ite.getInvoicedesc() %></option>
                            <%
                               }
                            %>
                           
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
