<%-- 
    Document   : ginvoice
    Created on : 10-Aug-2014, 08:31:37
    Author     : OLIDAN
--%>
<%!int itc=0; %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>General Invoice Generation.</title>
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
        String itemdesc=request.getParameter("itemdesc");
        String qnty = request.getParameter("qnty");
        String rate =request.getParameter("rateamt");
        
        if(itemdesc!=null && itemdesc!="" && qnty!=null && qnty!="" && rate!=null && rate!=""){
            itc++;
            String tdid = transid + itc;
            double amount =new Integer(qnty).intValue() * new Double(rate).doubleValue();
            
            boolean isAdded = iL.createTransDetailtemp(tdid, new Integer(qnty), itemdesc, new Double(rate), new Double(amount), transid);
            if(isAdded==true){
                
            }else{
                out.println("<script type=\"text/javascript\">alert(\"Unable to Add Item.\");</script>");
            }
        }
        String cusname = request.getParameter("cusname");
        String cusaddress = request.getParameter("cusaddress");
        TimeZone tzone =TimeZone.getTimeZone("Africa/Lagos");
        Calendar callen =Calendar.getInstance(tzone);
        SimpleDateFormat st = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat stf = new SimpleDateFormat("hh:mm:ss");
        String transdate = st.format(callen.getTime());
        String transtime = stf.format(callen.getTime());
        if(cusname!=null && cusname!="" && cusaddress!=null && cusaddress!=""){
            boolean isMoved = iL.moveTransdetailtempToTransDetail(transid);
            if(isMoved==true){
               iL.createTransaction(transid, cusname, cusaddress, transdate, transtime, invoicecode, "GEN");
               iL.deleteTransDetailTemp(transid);
               out.println("<script type=\"text/javascript\">alert(\"Processed Successfully.\");</script>");
            }else if(isMoved==false){
               out.println("<script type=\"text/javascript\">alert(\"Could not process Successfully.\");</script>");
            }
        }
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
                 </form>
                <div style="border: 1px #af9494 solid; width: 550px;height:auto">
                    <form action="" method="post" name="frmadd" id="frmadd">
                        <table>
                            <tr>
                                <td>Item Desc</td>
                                <td><input class="easyui-validatebox textbox" type="text" name="itemdesc" style="width:200px;"  data-options="required:true"></input> </td>
                                <td>Qnty</td>
                                <td><input class="easyui-numberbox" name="qnty" data-options="precision:0,groupSeparator:',',required:true" style="width:100px;"></input></td>
                                <td>Rate</td>
                                <td><input class="easyui-numberbox" name="rateamt" data-options="precision:2,groupSeparator:',',required:true" style="width:100px;"></input></td>
                                
                                
                            </tr>
                        </table>
                        
                    </form>
                    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="frmadd.submit()" style='width:100px; '>Add Item</a>
                </div>
                     <table class="easyui-datagrid" title="PRODUCTS AND SERVICES" style="width:550px;height:250px"
			data-options="singleSelect:true,collapsible:true,method:'get'">
		<thead>
			<tr>
				<th data-options="field:'sno',width:40">S/NO.</th>
				<th data-options="field:'itemdesc',width:250">ITEM DESCRIPTION</th>
				<th data-options="field:'qnty',width:80,align:'right'">QUANTITY</th>
				<th data-options="field:'rate',width:80,align:'right'">RATE</th>
                                <th data-options="field:'amount',width:80,align:'right'">AMOUNT</th>
				
			</tr>
		</thead>
	

                <tbody>
                    <%
                    ArrayList al = iL.viewTransDetailtemp(transid);
                    Iterator it = al.iterator();
                    int c=0;
                    while(it.hasNext()){
                        TransDetailTemp tdt =(TransDetailTemp)it.next();
                        c++;
                    %>
                    <tr>
                        <td><%=c %></td>
                        <td><%=tdt.getItemdesc() %></td>
                        <td><%=tdt.getQnty() %></td>
                        <td><%=tdt.getRate() %></td>
                         <td><%=tdt.getAmount() %></td>
                    </tr>
                    <% 
                    }
                    %>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>Total =
                        </td>
                        <td><%=iL.getTotalSumTransDetailTemp(transid) %></td>
                    </tr>
                </tbody>
	</table>
                
            
                    <div style="margin-top: 0px;padding-top:5px;">
                        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm('#frm')" style='width:100px; '>Process</a> 
                        <a href="InVoiceRep?transid=<%=transid%>"   style='width:100px; '>Print Invoice</a> 
                    </div>
              
         </div>
         
     </div>
         </center>
    </body>
</html>
