<%-- 
    Document   : designatedInvoice
    Created on : 31-Jul-2014, 11:11:10
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Designated Invoice</title>
        <%@include file="lookup.jsp" %>
        <!--<script type="text/javascript">
            function submitForm(gt){
			$(gt).form('submit');
                        
		}
        </script>-->
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
                String transid =yed+ trans;
                boolean isProcessed = iL.prepareDInvoice(invoicecode, transid);
                if(isProcessed==true){
                    //session.setAttribute("transid", transid);
                    response.sendRedirect("DInvoice?transid="+transid+"&invoicecode="+invoicecode);
                }else if(isProcessed==false){
                    out.println("<script type=\"text/javascript\">alert(\" Could not process Invoice.\");</script>");
                }
                
            }
        %>
        <center>
         <img src="Header" height="100" width="100%" alt="header" border="0"/>
     <div style="background-color:whitesmoke;width:100%;height:550px;padding-top:0px;  ">
         <div class="easyui-panel" style="padding:5px;">
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-back'" onclick="history.go(-1)">Back</a>
		
	</div>
         <div class="easyui-panel" title="DESIGNATED INVOICE GENERATION" style="width:500px;height:200px;padding-top:5px; ">
         
             <center>
        <form method="post" action="" name="frm" id="frm" >
            
            <table width="90%" >
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
                 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="frm.submit();" style='width:100px; '>Submit</a> 
               </center>
         </div>
     </div>
    </center>
    </body>
</html>
