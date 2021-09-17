<%-- 
    Document   : index
    Created on : 25-Jul-2014, 03:59:00
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice Generation Software.</title>
        <link rel="shortcut icon" href="images/olidanlo.gif" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="resource/jeasyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="resource/jeasyui/themes/icon.css">
	<!--<link rel="stylesheet" type="text/css" href="resources/jeasyui/demo/demo.css">-->
	<script type="text/javascript" src="resource/jeasyui/jquery.min.js"></script>
	<script type="text/javascript" src="resource/jeasyui/jquery.easyui.min.js"></script>
         <!--<link rel="stylesheet" href="css/documentation.css" />-->
    </head>
    <body onLoad="progress()" >
    <center>
        <img src="images/olidanlogo.gif" height="120" width="350" alt="Powered by OPS" style="margin-top: 150px;"/>
    </center>
    <script type="text/javascript">
		
		function progress(){
			var win = $.messager.progress({
				title:'Please wait',
				msg:'Loading data...'
			});
			setTimeout(function(){
				$.messager.progress('close');
                                document.location='Logon';
			},5000)
		}
	</script>

    </body>
</html>
