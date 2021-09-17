<%-- 
    Document   : viewallusers
    Created on : 29-Jul-2014, 02:45:35
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Users</title>
        <%@include file="lookup.jsp" %>
    </head>
    <body>
        <center>
         <img src="Header" height="100" width="100%" alt="header" border="0"/>
     <div style="background-color:whitesmoke;width:100%;height:550px;padding-top:0px;  ">
         <div class="easyui-panel" style="padding:5px;">
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-back'" onclick="history.go(-1)">Back</a>
	</div>
         <table id="tg" class="easyui-treegrid" title="VIEW ALL USERS" style="width:700px;height:500px"
			data-options="
				iconCls: 'icon-ok',
				rownumbers: false,
				animate: true,
				collapsible: true,
				fitColumns: true,
				idField: 'id',
				treeField: 'name',
				loadFilter: pagerFilter,
				pagination: true,
				pageSize: 20,
				pageList: [20,40,60,80,100]
			">
		<thead>
			<tr>
                            <th data-options="field:'id',width:20">ID</th>
				<th data-options="field:'name',width:280">NAME</th>
                                <th data-options="field:'sex',width:60">SEX</th>
                                <th data-options="field:'username',width:100">USERNAME</th>
				<th data-options="field:'password',width:160,align:'right'">PASSWORD</th>
				<th data-options="field:'role',width:80">ROLE</th>
				
			</tr>
		</thead>
                <tbody>
                    <% int c=0;
                    ArrayList al = iL.viewAllUsers();
                    Iterator it = al.iterator();
                    while(it.hasNext()){
                        User us =(User)it.next();
                        c++;
                    
                    %>
                    <tr>
                        <td><%=c  %></td>
                        <td><%=us.getName()  %></td>
                        <td><%=us.getSex()  %></td>
                        <td><%=us.getUsername()  %></td>
                        <td><%=us.getPassword()  %></td>
                        <td><%=us.getRole()  %></td>
                    </tr>
                    <% 
                                       }
                    %>
                </tbody>
	</table>
         <script type="text/javascript">
		function formatProgress(value){
	    	if (value){
		    	var s = '<div style="width:100%;border:1px solid #ccc">' +
		    			'<div style="width:' + value + '%;background:#cc0000;color:#fff">' + value + '%' + '</div>'
		    			'</div>';
		    	return s;
	    	} else {
		    	return '';
	    	}
		}
		
		function pagerFilter(data){
            if ($.isArray(data)){    // is array  
                data = {  
                    total: data.length,  
                    rows: data  
                }  
            }
            var dg = $(this);  
			var state = dg.data('treegrid');
            var opts = dg.treegrid('options');  
            var pager = dg.treegrid('getPager');  
            pager.pagination({  
                onSelectPage:function(pageNum, pageSize){  
                    opts.pageNumber = pageNum;  
                    opts.pageSize = pageSize;  
                    pager.pagination('refresh',{  
                        pageNumber:pageNum,  
                        pageSize:pageSize  
                    });  
                    dg.treegrid('loadData',data);  
                }  
            });  
            if (!data.topRows){  
            	data.topRows = [];
            	data.childRows = [];
            	for(var i=0; i<data.rows.length; i++){
            		var row = data.rows[i];
            		row._parentId ? data.childRows.push(row) : data.topRows.push(row);
            	}
				data.total = (data.topRows.length);
            }  
            var start = (opts.pageNumber-1)*parseInt(opts.pageSize);  
            var end = start + parseInt(opts.pageSize);  
			data.rows = $.extend(true,[],data.topRows.slice(start, end).concat(data.childRows));
			return data;
		}
	</script>

     </div>
        </center>
    </body>
</html>
