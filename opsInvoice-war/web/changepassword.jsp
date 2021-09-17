<%-- 
    Document   : changepassword
    Created on : 29-Jul-2014, 02:46:03
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <%@include file="lookup.jsp" %>
        <script type="text/javascript">
    function checkPass(){
                if (frm.password.value!=frm.conpassword.value){
                    //alert("The confirm password is not the same with password entered. pls enter a valid password.");
                    $.messager.alert('WRONG PASSWORD','The confirm password is not the same with password entered. pls enter a valid password.!','error');
                    frm.conpassword.value="";
                   
                    return false;

                }
            }
             function submitForm(gt){
			$(gt).form('submit');
                        
		}
   </script>
   
    </head>
    <%
    String username="bringfireh";//enter the session value later
    String oldpassword = request.getParameter("oldpassword");
    String password = request.getParameter("password");
    if(oldpassword!=null && oldpassword!="" && password!=null && password!=""){
        if(iL.checkExistence(username)==true){
            if(iL.getPassword(username).equals(iL.encryptPassword(oldpassword))){
                boolean isChanged = iL.changePassword(username, iL.encryptPassword(password));
                if(isChanged==true){
                    out.println("<script type=\"text/javascript\">alert(\" Password Successfully Changed.\");</script>"); 
                }else if(isChanged==false){
                   out.println("<script type=\"text/javascript\">alert(\"Could Not Change Password.\");</script>");  
                }
            }else{
              out.println("<script type=\"text/javascript\">alert(\"Wrong old password.\");</script>");   
            }
        }else{
          out.println("<script type=\"text/javascript\">alert(\"You were not on the system before.\");</script>");  
        }
    }
    %>
    <body>
        <center>
         <img src="Header" height="100" width="100%" alt="header" border="0"/>
     <div style="background-color:whitesmoke;width:100%;height:550px;padding-top:0px;  ">
         <div class="easyui-panel" style="padding:5px;">
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-back'" onclick="history.go(-1)">Back</a>
	</div>
         <div class="easyui-panel" title="CHANGE PASSWORD" style="width:400px;height:200px;padding-top:5px; ">
             <center>
         <form action="" method="post" name="frm" id="frm" >
            <table width="80%">
                
                <tr>
                    <td>Username</td>
                    <td><input class="easyui-validatebox textbox" type="text" name="username" style="width:200px;" data-options="required:true" value="<%=username %>"readonly></input></td>
                </tr>
                <tr>
                    <td>Old Password</td>
                    <td><input class="easyui-validatebox textbox" type="password" name="oldpassword" style="width:200px;" data-options="required:true"></input> </td>
                </tr>
                <tr><td>New Password </td>
                    <td><input class="easyui-validatebox textbox" type="password" name="password" style="width:200px;" data-options="required:true"></input> </td>
                </tr>
                </tr><tr><td>Confirm New Password </td>
                    <td><input class="easyui-validatebox textbox" type="password" name="conpassword" style="width:200px;" data-options="required:true" onchange="checkPass()"></input> </td>
                </tr>
                 
            </table>
        </form>
             <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm('#frm')" style='width:100px; '>Change</a> 
             </center>
         </div>
     </div>
        </center>
    </body>
</html>
