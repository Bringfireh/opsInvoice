<%-- 
    Document   : Logout
    Created on : 28-Jul-2014, 02:53:39
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
        <%@include file="lookup.jsp" %>
    </head>
    <body onload="start()">
        <div id="p" class="easyui-progressbar" style="width:400px;"></div>
	<script>
		function start(){
			var value = $('#p').progressbar('getValue');
			if (value < 100){
				value += Math.floor(Math.random() * 10);
				$('#p').progressbar('setValue', value);
				setTimeout(arguments.callee, 200);
			}else if(value==100){
                            document.location='../';
                        }
		};
	</script>
        <%
        if (session!=null){
                

                try{
                    session.invalidate();
                    
                  }catch (Exception e){
                  System.out.println(e.getMessage());    
                  }
                }
        %>
    </body>
</html>
