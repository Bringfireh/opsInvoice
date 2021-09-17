<%-- 
    Document   : geninvoice
    Created on : 05-Aug-2014, 02:35:06
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>General Invoice</title>
         <%@include file="lookup.jsp" %>
    </head>
    <body>
        <%
        String invoicecode = request.getParameter("invoicetype");
            if(invoicecode!=null && !invoicecode.equalsIgnoreCase("")){
                TimeZone tzone =TimeZone.getTimeZone("Africa/Lagos");
        
                Calendar cal = new GregorianCalendar(tzone);
                long tt = cal.getTimeInMillis();
                Calendar callen =Calendar.getInstance(tzone);
                SimpleDateFormat st = new SimpleDateFormat("yyyy");
                String trans = new Long(tt).toString();
                String yed = st.format(callen.getTime());
                String transid =yed + trans;
                response.sendRedirect("ginvoice?transid="+transid+"&invoicecode="+invoicecode);
                
                
            }
        %>
        <center>
         <img src="Header" height="100" width="100%" alt="header" border="0"/>
     <div style="background-color:whitesmoke;width:100%;height:550px;padding-top:0px;  ">
         <div class="easyui-panel" style="padding:5px;">
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-back'" onclick="history.go(-1)">Back</a>
		
	</div>
         <div class="easyui-panel" title="GENERAL INVOICE" style="width:500px;height:200px;padding-top:5px; ">
         
             <center>
        <form method="post" action="" name="frm" id="frm" >
            
            <table width="90%" >
                <tr>
                    <td>Invoice</td>
                    <td>
                        <select class="easyui-combobox" name="invoicetype" style="width:200px;" data-options="required:true">
                            <% 
                            ArrayList al = iL.viewAllInvoiceTypes("GEN");
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
                 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="frm.submit();" style='width:100px; '>Submit</a> 
               </center>
         </div>
     </div>
    </center>
    </body>
</html>
