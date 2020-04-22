<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hello Employee</title>
    <link rel="stylesheet" href="/resources/sj/css/employee_login.css">
    <link rel="stylesheet" href="/resources/sj/css/employee_login_style.css">
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Roboto&display=swap" rel="stylesheet">
    <script src="http://code.jquery.com/jquery.min.js"></script>
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <header>
        <div class="header-container">
            <h1>Hello Employee Login</h1>
        </div>
    </header>
    <div class="contents">
        <div class="contents-container">
            <form action="/login" method="POST" id="login_form">
                <h1 class="login_title">로그인</h1>
                <p class="login_line">
                    <label>아이디<br>
                    <input type="shopID" name="shopID"></label>
                </p>
                <p class="login_line">
                    <label>비밀번호<br>
                    <input type="shopPw" name="shopPw"></label>
                </p>
                <p class="login_line"><input type="submit" class="j" value="로그인"></p>
            </form>
        </div><!--/contents-container-->
    </div><!--/contents-->

    <footer>
        <div class="footer-container">
            <p>©Hello Employee</p>
        </div>
    </footer>
<!-- 
    <script type="text/javescript">
        $(function(){
            $("submit").click(function(){
                val value1 = $("Id").val();
                val value2 = $("password").val();

                $.get("employee_index.html",{id:value1, password:value2},
                    function(args){     get방식으로 보낸 데이터(employee_index.html)결과값 처리된걸 args에서 받음-->
                        
                        <!--결과값 받아서 복잡한 작업을 추가해야하면 여기 사이에 해주면된당-->
                        <!-- $("#select").html(args);
                    }); -->

                    <!--GET과 POST방식 둘다 기재할 수 없어서 주석처리함-->
                    <!--POST방식-->
                    <!-- $.get("employee_index.html",{id:value1,password:value2},
                        function(args){
                        $(#select).html(args);
                    }); -->

                    <!-- $("submit").click(function(){
                        $("#select").empty();
                    });
            });
        }); -->

  <!--  </script> -->
  

</body>
</html>