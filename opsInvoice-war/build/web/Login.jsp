<%-- 
    Document   : Login
    Created on : 27-Jul-2014, 07:52:27
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="resource/jsImgSlider/themes/8/js-image-slider.css" rel="stylesheet" type="text/css" />
    <script src="resource/jsImgSlider/themes/8/js-image-slider.js" type="text/javascript"></script>
    <!--<link href="resource/jsImgSlider/themes/8/tooltip.css" rel="stylesheet" type="text/css" />-->
    <script src="resource/jsImgSlider/themes/8/tooltip.js" type="text/javascript"></script>
    <link href="resource/jsImgSlider/generic.css" rel="stylesheet" type="text/css" />
    <!--<script type="text/javascript">
        imageSlider.thumbnailPreview(function (thumbIndex) { return "<img src='images/thumb" + (thumbIndex + 1) + ".jpg' style='width:70px;height:44px;' />"; });
    </script>-->

        <%@include file="lookup.jsp" %>
        
    </head>
    <body

     
     <center>
         <img src="Header" height="100" width="100%" alt="header" border="0"/>
     <div style="background-color:whitesmoke;width:100%;height:550px;padding-top:0px;  ">
    <table width="70%" align="center">
        <tr>
            <td><div id="sliderFrame">

        <div id="slider">
            
                <img src="images/office1.jpg" alt="Office processes" />
            
            <img src="images/office2.jpg" alt="Decoration of office buildings" />
            <img src="images/office3.jpg" alt="Automation of office processes" />
            <img src="images/office4.jpg" alt="Invoice generation process" />
            <img src="images/office5.jpg" alt="Accounting processes in office" />
            <img src="images/office6.jpg" alt="Office structure layout." />
        </div>
    </div> </td>
        </tr>
        <tr>
            <td align="center"> 
                
                <div class="easyui-panel" title="LOGIN" style="width:400px;height:200px;padding:5px 5px 5px 5px; ">
                    <center>
		<form method="post" action="" name="frm" onsubmit="gizzup();">
            <table width="80%" style="margin-top:20px;">
                
                <tr><td>Username </td>
                    <td><input type="text" name="username" id="username" style="width:200px;
		display:block;
                margin:0px;
                border-color:white;
		background-color:#fefef0;
		color:blue;" required/> </td>
                </tr>
                <tr><td>Password </td>
                    <td><input type="password" name="password" id="password" style="width:200px;
		display:block;
                margin:0px;
                border-color:white;
		background-color:#fefef0;
		color:blue;" required/> </td>
                </tr>
                <tr><td>&nbsp; </td>
                    <td><input type="submit" style="width:100px;
		margin-left:35px;
		display:block;
		background-color:whitesmoke;
		color:black;
                -webkit-box-shadow:0 0 7px skyblue;
                -moz-box-shadow: 0 0 7px skyblue;
                box-shadow:0 0 7px skyblue;" name="signin" id="Login" value="Login" /> </td>
                </tr>
                <tr>
                    <td>&nbsp;</td><td>&nbsp;</td>
                </tr>
            </table>
            
        </form>
                        </center>
                </div>
            </td>
        </tr>
   
    
    </table>
    </div>
         <center>
             <span style="color:white;text-align:center ">
             powered by:Olidan Projects Services Limited (<a href="http://www.olidanprojects.com" style="text-decoration:none; ">www.olidanprojects.com</a>)
         </span>
         </center>
         
</center>
        
    </body>
</html>
