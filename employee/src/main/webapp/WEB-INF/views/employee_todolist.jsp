<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hello Employee</title>
    <link rel="stylesheet" type="text/css" href="/resources/sj/css/employee_todolist.css">
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
                    <li class="checkIn">출근</li>
                    <li class="checkOut">퇴근</li>
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
                    <li><a href="/WEB-INF/views/employee_todolist.jsp">일정확인</a></li>
                    <li><a href="#">근태확인</a></li>
                    <li><a href="#">급여확인</a></li>
                    <li><a href="#">휴가신청</a></li>
                    <li><a href="#">월차신청</a></li>
                </ul>
            </nav>
        </div>
        
        
        <div class="maincontents">
            <div class="profile"><img src="/resources/sj/images/profile.jpg" alt="">
            </div><!--/profile-top-->

            <div class="todolist_contents">
               <div class="calendar-wrapper">
				   <table class="calendar">
				      <caption>2020년4월</caption>
				      <thead>
				         <tr>
				            <th>일</th>
				            <th>월</th>
				            <th>화</th>
				            <th>수</th>
				            <th>목</th>
				            <th>금</th>
				            <th>토</th>
				         </tr>
				      </thead>
				      <tbody>
				         <tr>
				            <td></td>
				            <td class="holiday">1</td>
				            <td class="holiday">2</td>
				            <td>3</td>
				            <td>4</td>
				            <td>5</td>
				            <td>6</td>
				         </tr>
				         <tr>
				            <td>7</td>
				            <td>8</td>
				            <td>9</td>
				            <td>10</td>
				            <td class="holiday">11</td>
				            <td>12</td>
				            <td>13</td>
				         </tr>
				         <tr>
				            <td>14</td>
				            <td>15</td>
				            <td>16</td>
				            <td>17</td>
				            <td>18</td>
				            <td>19</td>
				            <td>20</td>
				         </tr>
				         <tr>
				            <td>21</td>
				            <td>22</td>
				            <td>23</td>
				            <td>24</td>
				            <td>25</td>
				            <td>26</td>
				            <td>27</td>
				         </tr>
				         <tr>
				            <td>28</td>
				            <td>29</td>
				            <td>30</td>
				            <td>31</td>
				            <td></td>
				            <td></td>
				            <td></td>
				         </tr>
				      </tbody>
				   </table>
				</div>
               
				<div class="todolist-wrapper">
				   <table class="todolist">
				      <caption>To Do LIST</caption>
				      <thead>
				         <tr>
				            <th>시작할 일</th>
				            <th>끝마친 일</th>
				         </tr>
				      </thead>
				      <tbody>
				         <tr>
				            <td>
				               <div>
				                  <input type="checkbox" id="check_test_box" />
				                  <label for="check_test_box"><span>청소 하기</span></label>
				               </div>
				            </td>
				            <td></td>
				         </tr>
				      </tbody>
				   </table>
				</div>	
	
            </div><!--/todolist_contents-->

            <div class="notice">
                <p>
                    <mark>김 수진</mark> 님 반갑습니다. 현재 <mark>직원 페이지</mark>에 접근하셨습니다. 
                    <a href="#a"><span class="notice-btn">로그아웃</span></a>
                </p>
            </div>
        </div>
            <script>
                const employeeSelectForm =document.querySelector(".employeeSelect"); // employeeSelectForm는, 쿼리셀렉터라는 돔함수를 가지고 넣을 곳을 데려온것. 넣을 곳을 찾는다.
                console.log(employeeSelectForm);

                $('button').click(function(){

                })

                $.ajax({
                    url:'/WEB-INF/views/employee_todolist.jsp',// 요청 할 주소  8090/toDo/25
                    type:'GET',
                    // dataType:'html',// xml, json, script, html
                    success:res => { 
                        console.log(res); 
                        for(let i=0;i<res.data.data.length;i++){ 
                            let employeeOption = document.createElement("option"); //넣을 태그(것)
                            employeeOption.innerText=res.data.data[i].emName; //넣을 것에 대한 내용 설정
                            employeeSelectForm.appendChild(employeeOption); //넣을곳.appendchild(넣을 것)을 하면 넣을 곳에 넣을 것이 들어간다.
                        }
                    },// 요청 완료 시
                    error:err => console.log(err),// 요청 실패.
                });

                $.ajax({
                    url:'/todolist',
                    type: 'PUT',
                    data: [
                            {toDoID:7, toDo: "내일은 정말 뭐하냐", toDoDate: "2020-03-08", todoCheck: 0},
                            {toDoID:2, toDo: "자바공부하자", toDoDate: "2020-03-11", todoCheck: 0},
                            {toDoID:3, toDo: "421", toDoDate: "2020-03-11", todoCheck: 0},
                            {toDoID:4, toDo: "어려워", toDoDate: "2020-03-12", todoCheck: 0},
                        ],
                    success: function(result){
                        
                    },
                })

                // 서버가 데이터를 받는 방식 Nodejs에서!
                // app.get('/todolist',function(req,res){
                //     let data1 = req.body.data[0].toDoID
                // })
    </script>
</body>
</html>