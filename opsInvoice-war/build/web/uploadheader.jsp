<%-- 
    Document   : uploadheader
    Created on : 28-Jul-2014, 06:58:19
    Author     : OLIDAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
        <%@include file="lookup.jsp" %>
        <script type="text/javascript">
            function submitForm(){
			//$(gt).form('submit');
                        
                        
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
         <div class="easyui-panel" title="UPLOAD HEADER" style="width:400px;height:200px;padding-top:5px; ">
             <center>
         <form method="post" action="UploadHeader" name="frm" enctype="multipart/form-data" id="frm">
                    <table width="80%">
                        
                        <tr>
                            <td>Image File</td>
                            <td><input class="easyui-validatebox file" type="file" name="file" data-options="required:true"></input></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                </form>
             <a href="javascript:void(0)" class="easyui-linkbutton" onclick="frm.submit()" style='width:100px; '>Upload</a> 
             </center>
         </div>
         
     </div>
        </center>
    </body>
</html>
