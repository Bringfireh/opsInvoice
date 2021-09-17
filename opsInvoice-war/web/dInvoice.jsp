<%-- 
    Document   : dInvoice
    Created on : 01-Aug-2014, 08:25:35
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Designated Invoice Generation</title>
        <%@include file="lookup.jsp" %>
        <script type="text/javascript">
            function submitForm(gt){
			$(gt).form('submit');
                        
		}
        </script>
    </head>
    <body>
        <%
        String invoicecode=request.getParameter("invoicecode");
        String transid = request.getParameter("transid");
        %>
         <center>
         <img src="Header" height="100" width="100%" alt="header" border="0"/>
     <div style="background-color:whitesmoke;width:100%;height:550px;padding-top:0px;  ">
         <div class="easyui-panel" style="padding:5px;">
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-back'" onclick="history.go(-1)">Back</a>
		<a href="#" class="easyui-linkbutton" data-options="plain:true" onclick="history.go(-2)">Board</a>
	</div>
         <b><%=iL.getInvoiceName(invoicecode).toUpperCase() %></b>
         <div width="80%">
             <form action="" method="post" name="frm" id="frm" >
                <table>
                    <tr><td>Transaction Id </td>
                    <td><%=transid %> </td>
                </tr>
                <tr><td>Customer Name </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="cusname" style="width:300px;"  data-options="required:true"></input> </td>
                </tr>
                <tr><td valign='top'>Address </td>
                    <td><textarea class="easyui-validatebox textarea" name="cusaddress" data-options="required:true" rows="3" cols="36"></textarea></td>
                </tr>
                    </table>
                     <table class="easyui-datagrid" title="PRODUCTS AND SERVICES" style="width:420px;height:250px"
			data-options="singleSelect:true,collapsible:true,method:'get'">
		<thead>
			<tr>
				<th data-options="field:'sno',width:40">S/NO.</th>
				<th data-options="field:'itemcode',width:80">ITEM CODE</th>
				<th data-options="field:'itemdesc',width:200,align:'right'">ITEM DESCRIPTION</th>
				<th data-options="field:'amount',width:80,align:'right'">AMOUNT</th>
				
			</tr>
		</thead>
	

                <tbody>
                    <%
                    ArrayList al = iL.viewAllTransDetailDitemp(transid);
                    Iterator it = al.iterator();
                    int c=0;
                    while(it.hasNext()){
                        TransactionDetailDITemp tdt =(TransactionDetailDITemp)it.next();
                        c++;
                    %>
                    <tr>
                        <td><%=c %></td>
                        <td><%=tdt.getItemcode() %></td>
                        <td><%=tdt.getItemdesc() %></td>
                        <td><%=tdt.getAmount() %></td>
                    </tr>
                    <% 
                    }
                    %>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>Total =
                        </td>
                        <td><%=iL.getDITotal(transid) %></td>
                    </tr>
                </tbody>
	</table>
                
             </form>
                    <div style="margin-top: 0px;padding-top:5px;">
                        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm('#frm')" style='width:100px; '>Process</a> 
                        <a href="InVoice?transid=<%=transid%>"   style='width:100px; '>Print Invoice</a> 
                    </div>
              
         </div>
         
     </div>
         </center>
                        <% 
                        String cusname = request.getParameter("cusname");
                        String cusaddress = request.getParameter("cusaddress");
                        TimeZone tzone =TimeZone.getTimeZone("Africa/Lagos");
                        Calendar callen =Calendar.getInstance(tzone);
                        SimpleDateFormat st = new SimpleDateFormat("dd-MM-yyyy");
                        SimpleDateFormat stf = new SimpleDateFormat("hh:mm:ss");
                        String transdate = st.format(callen.getTime());
                        String transtime = stf.format(callen.getTime());
                        if(cusname!=null && cusname!="" && cusaddress!=null && cusaddress!=""){
                            boolean isMoved =iL.moveTransDIdetailtemp(transid);
                            if(isMoved==true){
                                iL.createTransaction(transid, cusname, cusaddress, transdate, transtime, invoicecode, "DI"); 
                                iL.deleteTransactionDetailDITemp(transid);
                                out.println("<script type=\"text/javascript\">alert(\"Invoice Transaction successfully processed. Proceed to print invoice.\");</script>");
                            }else{
                                out.println("<script type=\"text/javascript\">alert(\" Could not process Invoice.\");</script>");
                            }
                           
                           
                        }
                        
                        %>

    </body>
</html>
