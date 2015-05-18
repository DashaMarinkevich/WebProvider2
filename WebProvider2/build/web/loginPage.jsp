<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="contract" scope="request"
             class="entity.Contract" />
<!DOCTYPE >
<html>
    <head>

        <link href="sty.css" rel="stylesheet" media="all" /> 
        <link rel="stylesheet" href="style.css" type="text/css"
              media="screen" />
    </head>
    <script type="text/javascript" src="jquery-1.5.1.js"></script>
    <script type="text/javascript" src="j.js">
    </script>
    <body >
        <form action="Controller" method="post" enctype="multipart/form-data">
            <input type="hidden" value="${idClient}" name="idClient"></input>
            <div id="left" >
                <ul>
                    <li><button class="current" type="button" onclick="location.href = 'index.jsp'"><span>Главная</span></button></li>
                    <li><button  type="button" onclick="location.href = 'belnet.jsp'"><span>О BelNetInter</span></button></li>
                    <li><button type="button" onclick="location.href = 'client.jsp'"><span>Клиентам</span></button></li>
                    <li><button  type="submit" value="viewService" name="command"><span>Услуги</span></button></li>
                    <li><button type="submit" value="viewTarifPlan" name="command"><span>Тарифы</span></button></li>

                </ul>
                <div class="curvebox2">
                    BelNetInter
                </div>
            </div>
        </form>
        <div id="leftcontent">
            <div class="curvebox3">

                <h2>
                    <a href="#">Вход</a>
                </h2>



                <form action="Controller" method="get"
                      enctype="multipart/form-data" name="myform">
                    <h2></h2>
                    <c:if test="${not empty login and not empty password}"><button class="but" type="submit" value="logoutUser" name="command"><FONT face="Comic Sans MS">Выход</font></button></c:if></li>
                    <c:if test="${empty login or empty password}"><button class="but" type="button" onclick="location.href = 'loginPage.jsp'"><FONT face="Comic Sans MS">Войти в кабинет пользователя</font></button></c:if>

                    </form>

                </div>
                <div id="menu">
                    <form action="Controller" method="post"
                          enctype="multipart/form-data" name="myform">
                        <input type="hidden" value="${idClient}" name="idClient"></input>
                    <h2></h2>
                    <table>
                        <tr>
                            <td style="  color:  #000000;"><FONT face="Comic Sans MS">Логин :</font></td>
                        </tr>
                        <tr>
                            <td><input type="login" name='login' size='20'  pattern="^[а-яА-ЯёЁa-zA-Z0-9]+$"  title="Пример:login"
                                       /></td>
                        </tr>
                        <tr>
                            <td style="  color:  #000000;"><FONT face="Comic Sans MS">Пароль:</font></td>
                        </tr>
                        <tr>
                            <td><input type="password" name='password' pattern="^(?=.*\d)(?=.*[a-z])(?!.*\s).*$" title="Пример:111as"
                                       size='20' required="required" /></td>
                        </tr>
                        <tr>
                            <td><c:if test="${ empty login}"><button style=" background: #F5F5F5; color: black;" type="submit" value='login'
                                                                     name='command'><FONT face="Comic Sans MS">Вход</font></button></c:if></td>
                        </tr>
                        <tr>
                            <td><b><a href="regist.jsp"><FONT face="Comic Sans MS">Зарегистрироваться</font></a></b></td>
                        </tr>
                    </table>
                </form> 

            </div>
        </div>
        <div id="rightcontent">
            <img src="images/login.jpg"  height="500" width="85%"/>  
        </div>
        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>


</html>

