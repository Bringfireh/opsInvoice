<%-- 
    Document   : reportbydate
    Created on : 06-Aug-2014, 11:02:59
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Report By Date</title>
         <%@include file="lookup.jsp" %>
         <script type="text/javascript">
             function myformatter(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return (d<10?('0'+d):d)+'-'+(m<10?('0'+m):m)+'-'+y;
		}
		function myparser(s){
			if (!s) return new Date();
			var ss = (s.split('-'));
			var y = parseInt(ss[0],10);
			var m = parseInt(ss[1],10);
			var d = parseInt(ss[2],10);
			if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
				return new Date(d,m-1,y);
			} else {
				return new Date();
			}
		}
                $.extend($.fn.validatebox.defaults.rules, {
			md: {
				validator: function(value, param){
					var d1 = $.fn.datebox.defaults.parser(param[0]);
					var d2 = $.fn.datebox.defaults.parser(value);
					return d2<=d1;
				},
				message: 'The date must be less than or equals to {0}.'
			}
		});
               

         </script>
    </head>
    <body>
    <center>
        <center>
         <img src="Header" height="100" width="100%" alt="header" border="0"/>
     <div style="background-color:whitesmoke;width:100%;height:550px;padding-top:0px;  ">
         <div class="easyui-panel" style="padding:5px;">
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-back'" onclick="history.go(-1)">Back</a>
		
	</div>
         <div class="easyui-panel" title="VIEW TRANSACTION BY DATE RANGE." style="width:500px;height:150px;padding-top:5px; ">
         
             <center>
        <form method="post" action="" name="frm" id="frm" >
            
            <table width="90%" >
                
                <tr><td>Start Date </td>
                    <td><input name="startdate" class="easyui-datebox" data-options="sharedCalendar:'#cc',formatter:myformatter,parser:myparser" ></input> </td>
                </tr>
                <tr><td>End Date </td>
                    <td><input name="enddate" class="easyui-datebox" data-options="sharedCalendar:'#cc',formatter:myformatter,parser:myparser"></td>
                </tr>
                                
            </table>
               
            
        </form>
                 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="frm.submit();" style='width:100px; '>Submit</a> 
               </center>
         </div>
          <%
            String startdate =request.getParameter("startdate");
            String enddate =request.getParameter("enddate");
            if(startdate!=null && startdate!="" && enddate!=null && enddate!=""){
                
            if(iL.checkExistenceDateRange(startdate, enddate) ==true){
                
                out.println("<font color='green'>Record Found.</font><br>");
                %>
                <table class="easyui-datagrid" title="SEARCH RESULT" style="width:460px;height:350px"
			data-options="singleSelect:true,collapsible:true,method:'get'">
                    <thead>
			<tr>
				<th data-options="field:'transid',width:150">TRANSACTION ID</th>
				<th data-options="field:'name',width:240">CUSTOMER NAME</th>
                                <th data-options="field:'detail',width:50,align:'right'">DETAIL</th>
				
				
			</tr>
		</thead>
                <tbody>
                    <%
                    ArrayList al =iL.viewAllRecByDateRange(startdate, enddate);
                    Iterator it =al.iterator();
                    while(it.hasNext()){
                    com.ops.helpers.Transaction tx =(com.ops.helpers.Transaction)it.next();
                    
                    %>
                    <tr>
                        
                        <td><%=tx.getTransid() %></td>
                       
                        <td><%=tx.getCusname() %></td>
                        
                        <td><a href="<%=(tx.getTranstype().equalsIgnoreCase("DI"))? "InVoice?transid="+tx.getTransid() :"InVoiceRep?transid="+tx.getTransid() %>" style="text-decoration: none" target="_blank"> Detail</a></td>
                    </tr>
                    <%
                                       }
                    %>
                </tbody>
                    
                </table>
                <%
                
            }else{
                out.println("<font color='red'>Record Not Found.</font>");
            }
                       }
         %>
     </div>
    

    </center>
     <div id="cc" class="easyui-calendar"></div>
    </body>
</html>
