<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript"src="jquery-3.3.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	  $("input").change(function(){
		  //获取count中的值
		  var count=$("#count").val();
		
		  //获取price中的值
		  var price=$("#price").val();
		  //赋值sum中的值
		  $("#sum").val(count*price);
		
	  });
	});
</script>
<body>
 数量：<input type="text"  id ="count" name="icount"  /><br>
 单价：<input type="text" id="price" name="iprice" /><br>
总价: <input type="text" id="sum"  name="isum" /><br>

</body>
</html>