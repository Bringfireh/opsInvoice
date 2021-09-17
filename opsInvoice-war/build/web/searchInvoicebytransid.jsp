<%-- 
    Document   : searchInvoicebytransid
    Created on : 05-Aug-2014, 03:05:40
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice By Transaction Id</title>
        <%@include file="lookup.jsp" %>
        <script type="text/javascript">
            
                function doSearch(value){
                        var tarina= value;
                        $('#search').val(value);
                       // alert(frm.search.value);
                        frm.submit();
                       
		}
        </script>
        
    </head>
    <body>
        <center>
         <img src="Header" height="100" width="100%" alt="header" border="0"/>
     <div style="background-color:whitesmoke;width:100%;height:550px;padding-top:0px;  ">
         <div class="easyui-panel" style="padding:5px;">
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-back'" onclick="history.go(-1)">Back</a>
		
	</div>
         <div class="easyui-panel" title="INVOICE SEARCH BY TRANSID" style="width:500px;height:100px;padding-top:5px; ">
         
             <center>
        <form method="post" action="" name="frm" id="frm" >
            
            <table width="90%" >
                
                <tr><td>Transaction Id </td>
                    <td><input class="easyui-searchbox" data-options="prompt:'enter transid.',searcher:doSearch" type="text" name="transid" style="width:200px;" ></input> </td>
                </tr>
                             
            </table>
               
            
        </form>
                 
               </center>
         </div>
         <%
            String transid =request.getParameter("transid");
            if(transid!=null && transid!=""){
            if(iL.checkTransactionExistence(transid)==true){
                com.ops.helpers.Transaction tx =iL.viewInvoiceTransaction(transid);
                out.println("<font color='green'>Record Found.</font><br>");
                %>
                <table class="easyui-datagrid" title="SEARCH RESULT" style="width:370px;height:250px"
			data-options="singleSelect:true,collapsible:true,method:'get'">
                    <thead>
			<tr>
				<th data-options="field:'transid',width:150">TRANSACTION ID</th>
				<th data-options="field:'name',width:150">NAME</th>
				<th data-options="field:'detail',width:50,align:'right'">DETAIL</th>
				
				
			</tr>
		</thead>
                <tbody>
                    <tr>
                        
                        <td><%=tx.getTransid() %></td>
                       
                        <td><%=tx.getCusname() %></td>
                        <td><a href="<%=(tx.getTranstype().equalsIgnoreCase("DI"))? "InVoice?transid="+tx.getTransid() :"InVoiceRep?transid="+tx.getTransid() %>" style="text-decoration: none" target="_blank"> Detail</a></td>
                    </tr>
                </tbody>
                    
                </table>
                <%
                
            }else{
                out.println("<font color='red'>Record Not Found. Invalid Transaction Id</font>");
            }
                       }
         %>
         <!-- class="easyui-validatebox searchbox-prompt"-->
     </div>
    </center>
    </body>
</html>
