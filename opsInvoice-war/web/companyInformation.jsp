<%-- 
    Document   : companyInformation
    Created on : 06-Aug-2014, 13:44:48
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Information</title>
         <%@include file="lookup.jsp" %>
         <script type="text/javascript">
             function submitForm(gt){
			$(gt).form('submit');
                        
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
         <div class="easyui-panel" title="CREATE COMPANY INFORMATION" style="width:500px;height:350px;padding-top:5px; ">
         
             <center>
        <form method="post" action="" name="frm" id="frm" >
            <table width="90%" >
                
                <tr><td>Company Name </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="companyname" style="width:200px;"  data-options="required:true"></input> </td>
                </tr>
                <tr><td>Company Address </td>
                    <td><textarea class="easyui-validatebox textarea" name="address" data-options="required:true" rows="5" cols="36"></textarea></td>
                </tr>
                <tr><td>Company Phone Number </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="phone" style="width:200px;" data-options="required:true"></input>  </td>
                </tr>
                <tr><td>Company Email </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="email" style="width:200px;" data-options="required:true,validType:'email'"></input> </td>
                </tr>
                <tr><td>Company website. </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="websiteadd" style="width:200px;" data-options="required:false"></input> </td>
                </tr>
               
                
                
            </table>
               
            
        </form>
                 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm('#frm')" style='width:100px; '>Create</a> 
                 
         </div>
         <%
         String companyname = request.getParameter("companyname");
         String address = request.getParameter("address");
         String phone = request.getParameter("phone");
         String email = request.getParameter("email");
         String website =request.getParameter("websiteadd");
            if(companyname!=null && companyname!=""){
                if(iL.checkCompanyInfoExistence()!=true){
                    boolean iscreated=iL.createCompanyInfo(companyname, address, phone, email, website);
                    if(iscreated==true){
                        out.println("<script type=\"text/javascript\">alert(\"Company Information created successfully\");</script>");
                    }else{
                        out.println("<script type=\"text/javascript\">alert(\"Cannot create Company Info.\");</script>");
                    }
                }else{
                    out.println("<script type=\"text/javascript\">alert(\"Company Info. Already Created.\");</script>");
                }
                
            }
                 
         %>
         
     </div>
        </center>
    </body>
</html>
