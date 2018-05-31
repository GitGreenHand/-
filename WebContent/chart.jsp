<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
.img{
width:800px;
height:600px;
border: 0;
color: gray;
} 
</style>
<div  style="text-align:center">  
                    柱状图 <br><br>  
     <br><br>  
     <img src="${chartColumnURL}" >  
  </div>
  <div  style="text-align:center">  
                饼状图 <br><br>  
     <br><br>  
     <img src="${pieChartURI}" >  
  </div>  
   <div  style="text-align:center">  
               折线图 <br><br>  
                     点击生成折线图<a href="getLineChart.do">getMajorChart</a>  
     <br><br>  
     <img src="${chartLineURL}" >  
  </div>  
</body>
</html>