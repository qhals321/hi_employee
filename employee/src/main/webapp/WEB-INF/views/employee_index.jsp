<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hello Employee</title>
    <link rel="stylesheet" type="text/css" href="/resources/sj/css/employee_index.css">
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Roboto&display=swap" rel="stylesheet">
    <script src="http://code.jquery.com/jquery.min.js"></script>      
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="sidebar">
            <header>
                <a href="#"><h1 class="header-logo">Hello Employee</h1></a>
            </header>
            <nav class="check">
                <ul>
                    <li class="checkIn" style="cursor:pointer;">출근</li>
                    <li class="checkOut" style="cursor:pointer;">퇴근</li>
                </ul>
            </nav>
            
            <div class="employeeSelectAll"><!--employee_chart-->
                <p>직원을 선택해주세요.
                    <select class="employeeSelect" name="select"><!--select-->
                        <option></option>
                        <!-- <option>김수진</option>
                        <option>윤보민</option>
                        <option>이재혁</option>
                        <option>박성광</option> -->
                    </select>
                </p>
            </div>
            
            <nav>
                <ul class="globalnav">
                    <li><a href="/sjtodo">일정확인</a></li>
                    <li><a href="#">근태확인</a></li>
                    <li><a href="#">급여확인</a></li>
                    <li><a href="#">휴가신청</a></li>
                    <li><a href="#">월차신청</a></li>
                </ul>
            </nav>
        </div>
        
        
        <div class="maincontents">
            <div class="keyvisual"><img src="/resources/sj/images/keyvisual.jpg" alt="">
            </div>
            
            
            <div class="notice">
                <p>
                    <mark>김 수진</mark> 님 반갑습니다. 현재 <mark>직원 페이지</mark>에 접근하셨습니다. 
                     <a href="/index"><span class="notice-btn">관리자 모드</span></a>
                    <a href="/logout"><span class="notice-btn">로그아웃</span></a>
                </p>
            </div>
         
            <script>
                const employeeSelectForm =document.querySelector(".employeeSelect"); // employeeSelectForm는, 쿼리셀렉터라는 돔함수를 가지고 넣을 곳을 데려온것. 넣을 곳을 찾는다.
                console.log(employeeSelectForm);

                $.ajax({
                    url:'/employee',// 요청 할 주소
                    type:'GET',
                    // dataType:'html',// xml, json, script, html
                    success:res => { 
                        console.log(res); 
                        for(let i=0;i<res.data.length;i++){ 

                            let employeeOption = document.createElement("option"); //넣을 태그(것)

                            employeeOption.innerText=res.data[i].emName; //넣을 것에 대한 내용 설정
                            employeeSelectForm.appendChild(employeeOption); //넣을곳.appendchild(넣을 것)을 하면 넣을 곳에 넣을 것이 들어간다.
                        }
                    },// 요청 완료 시
                    error:err => console.log(err),// 요청 실패.
                });
                
                
                document.querySelector('.checkIn').addEventListener('click', ()=> postCommute());
                function postCommute(){ 
                $.ajax({    //출근
                    url: '/commute',
                    type: 'POST',
                    success: res=>{
                        console.log(res);
                        alert("출근 완료!");
                    }
                });
                }
                document.querySelector('.checkOut').addEventListener('click', ()=> putCommute());
                function putCommute(){
                $.ajax({    //퇴근
                    url: '/commute',
                    type: 'PUT',
                    success: res=>{
                        console.log(res);
                        alert("퇴근 완료!");
                    }
                });
                }   
                
    </script>
</body>
</html>