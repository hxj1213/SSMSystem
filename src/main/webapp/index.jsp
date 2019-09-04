<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/4
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>添加员工</h3>
    <form action="/emp/add" method="post">
        <input type="text" name="empno"><br>
        <input type="text" name="ename"><br>
        <input type="text" name="job"><br>
        <input type="text" name="hiredate"><br>
        <input type="text" name="sal"><br>
        <input type="submit" value="添加员工">
    </form>

    <button id="findEmp">点击发送json</button>

    <script src="js/jquery.min.js"></script>
   <script>

       $(document).ready(function () {

           $("#findEmp").click(function () {

               $.ajax({
                   type:'POST',
                   url:'/emp/findByJson',
                   contentType:'application/json;charset=UTF-8',
                   data:'{"pageNow":2,"pageCount":5}',
                   success:function (data) {
                       console.log(data);
                   }
               })

           })

       })

   </script>
</body>
</html>
