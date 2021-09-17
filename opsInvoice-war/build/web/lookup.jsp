<%-- 
    Document   : lookup
    Created on : 27-Jul-2014, 06:12:31
    Author     : OLIDAN
--%>    
        <link rel="shortcut icon" href="images/olidanlo.gif" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="resource/jeasyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="resource/jeasyui/themes/icon.css">
	<!--<link rel="stylesheet" type="text/css" href="resources/jeasyui/demo/demo.css">-->
	<script type="text/javascript" src="resource/jeasyui/jquery.min.js"></script>
	<script type="text/javascript" src="resource/jeasyui/jquery.easyui.min.js"></script>
         <link rel="stylesheet" href="css/documentation.css" />
<%@page import="javax.ejb.*,java.lang.*,javax.naming.InitialContext,javax.naming.Context,javax.rmi.PortableRemoteObject,java.util.*" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Calendar"%>
<%@page import ="java.text.SimpleDateFormat" %>
<%@page import="com.ops.sessions.*,com.ops.entities.*,com.ops.helpers.*" %>
<%!InvoiceLocal iL = null; %>
<%
try {
            Context c = new InitialContext();
            InvoiceLocalHome rv = (InvoiceLocalHome) c.lookup("java:comp/env/Invoice");
             iL=rv.create();
        } catch (Exception ne) {
            
        }
%>
<style type="text/css">
            body{
                background-image:url(images/pattern.png);
                background-color: #434040;
                margin-top:0pt;
                margin-left: 0pt;
                margin-right: 0pt;
                margin-bottom: 0pt;
            }
            :focus{outline:0}
            .right386 .entry{margin-bottom:12px;
             padding-bottom:18px}
        </style>
         <script type="text/javascript">
             
                 $(document).bind("contextmenu",function(e){
                     return false;
                 });
             
         </script>