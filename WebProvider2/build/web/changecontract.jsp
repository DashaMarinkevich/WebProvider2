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
                <form action="Controller" method="post"
                      enctype="multipart/form-data" name="myform">
                    <input type="hidden" value="${idClient}" name="idClient"></input>
                    <input type="hidden" value="${idProvider}" name="idProvider"></input>
                    <p align="left">BelNetInter открывает новые возможности для своих будущих абонентов. Оставить заявку на подключение к интернету можно на сайте BelNetInter.by . 
                        Подключение online – это экономия вашего времени, ведь сделать это можно в интернет-кафе, на работе или в гостях у друзей, не посещая центры подключения.</p>

                    <c:if test="${not empty login or not empty loginProvider  }"><button align="left" class="but" type="submit" value="logoutUser" name="command"><FONT face="Comic Sans MS">Выход</font></button></c:if>

                    </form> 
                </div>
                <div id="menu">
                    <h2>
                        <a href="#">Изменение договора</a>
                    </h2>

                    <form action="Controller" method="post"
                          enctype="multipart/form-data" name="myform">
                        <input type="hidden" value="${idClient}" name="idClient"></input>

                    <h2></h2>
                    <table>
                        <tr>
                            <td style="  color:  #000000;"><FONT face="Comic Sans MS">Номер договора :</font></td>
                        </tr>
                        <tr>
                            <td><input type="numContract" name='numContract' pattern="\-?\d+(\.\d{0,})?"   title="Вводите только цифры!" size='20'
                                       required="required"     /></td>
                        </tr>
                        <tr>
                            <td style="  color:  #000000;"><FONT face="Comic Sans MS">Номер лицевого счета :</font></td>
                        </tr>
                        <tr>
                            <td><input type="numPersonalAccount" name='numPersonalAccount' pattern="\-?\d+(\.\d{0,})?"  title="Вводите только цифры!"size='20'
                                       required="required"     /></td>
                        </tr>
                        <tr>
                            <td style="  color:  #000000;"><FONT face="Comic Sans MS">Логин:</font></td>
                        </tr>
                        <tr>
                            <td><input type="login" name='login'  pattern="^[а-яА-ЯёЁa-zA-Z0-9]+$"   title="Пример:login"
                                       size='20' required="required" /></td>
                        </tr>
                        <tr>
                            <td style="  color:  #000000;"><FONT face="Comic Sans MS">Пароль:</font></td>
                        </tr>
                        <tr>
                            <td><input type="password" name='password' pattern="^(?=.*\d)(?=.*[a-z])(?!.*\s).*$"  title="Пример :111as"
                                       size='20' required="required" /></td>
                        </tr>
                        <tr>
                            <td><button style=" background: #F5F5F5; color: black;" type="submit" value='changeContract'
                                        name='command'><FONT face="Comic Sans MS">Изменить</font></button></td>
                            <td><a style=" background: #F5F5F5; color: black;" href="service.jpg"><FONT face="Comic Sans MS">Назад</font></a></td>
                        </tr>

                    </table>

                </form>

            </div>
        </div>
        <div id="rightcontent">
            <img src="images/change.jpg"  width="80%"height="500px"/>  
        </div>
        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>




</html>

