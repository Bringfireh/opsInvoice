<%-- 
    Document   : createUser
    Created on : 28-Jul-2014, 08:09:18
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User.</title>
        <%@include file="lookup.jsp" %>
        <script type="text/javascript">
            
            
                function alert4(){
			$.messager.alert('WRONG PASSWORD','The confirm password is not the same with password entered. pls enter a valid password.!','error');
		}
		
               
    function checkPass(){
                if (frm.password.value!=frm.conpassword.value){
                    //alert("The confirm password is not the same with password entered. pls enter a valid password.");
                    alert4();
                    frm.conpassword.value="";
                   
                    return false;

                }
            }
    function submitForm(gt){
			$(gt).form('submit');
                        
		}
                
   </script>
   
		
	</script>

    </head>
    <body>
        <% 
         String username = request.getParameter("username");
         String surname = request.getParameter("surname");
         String firstname = request.getParameter("firstname");
         String othernames = request.getParameter("othernames");
         String sex = request.getParameter("sex");
         String phone = request.getParameter("phone");
         String email = request.getParameter("email");
         String password = request.getParameter("password");
         String address = request.getParameter("address");
         
        %>
        <center>
         <img src="Header" height="100" width="100%" alt="header" border="0"/>
     <div style="background-color:whitesmoke;width:100%;height:550px;padding-top:0px;  ">
         <div class="easyui-panel" style="padding:5px;">
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-back'" onclick="history.go(-1)">Back</a>
		
	</div>
         <div class="easyui-panel" title="CREATE USER" style="width:500px;height:450px;padding-top:5px; ">
         
             <center>
        <form method="post" action="" name="frm" id="frm" >
            <table width="90%" >
                
                <tr><td>Username </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="username" style="width:200px;"  data-options="required:true"></input> </td>
                </tr>
                <tr><td>Surname </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="surname" style="width:200px;" data-options="required:true"></input> </td>
                </tr>
                <tr><td>First Name </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="firstname" style="width:200px;" data-options="required:true"></input> </td>
                </tr>
                <tr><td>Other Names </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="othernames" style="width:200px;" data-options="required:false"></input> </td>
                </tr>
                <tr><td>Sex </td>
                <td><select class="easyui-combobox" name="sex" style="width:200px;" data-options="required:true"><option value="Male">Male</option><option value="Female">Female</option></select></td>
                </tr>
                <tr><td>Phone Number </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="phone" style="width:200px;" data-options="required:true"></input> </td>
                </tr>
                <tr><td>Email Address </td>
                    <td><input class="easyui-validatebox textbox" type="text" name="email" style="width:200px;" data-options="required:true,validType:'email'"></input></td>
                </tr>
                <tr><td>Password </td>
                    <td><input class="easyui-validatebox textbox" type="password" name="password" style="width:200px;" data-options="required:true"></input> </td>
                </tr>
                <tr><td>Confirm Password </td>
                    <td><input class="easyui-validatebox textbox" type="password" name="conpassword" style="width:200px;" data-options="required:true" onblur="checkPass()"></input> </td>
                </tr>
                
                <tr><td valign='top'>Address </td>
                    <td><textarea class="easyui-validatebox textarea" name="address" data-options="required:true" rows="5" cols="36"></textarea></td>
                </tr>
                
                
            </table>
               
            
        </form>
                 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm('#frm')" style='width:100px; '>Create</a> 
                 
         </div>
         <%
                 if(username!=null && username!="" && address!=null && address!=""){
             boolean isCreated=iL.createUserInfo(username, surname, firstname, othernames, sex, phone, email, address, password);
             if(isCreated==true){
                 out.println("<script type=\"text/javascript\">alert(\"User created successfully\");</script>");
             }else if (isCreated==false){
                 
                 out.println("<script type=\"text/javascript\">alert(\"Could Not Create user!\");</script>");
             }
         }
                 
                %>
     </div>
        </center>
     
    </body>
</html>
