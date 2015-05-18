<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="client" scope="request"
             class="entity.Client" />
<!DOCTYPE >
<html>

    <head>

        <link href="sty.css" rel="stylesheet" media="all" /> 
        <link rel="stylesheet" href="style.css" type="text/css"
              media="screen" />
        <link rel="stylesheet" href="table.css" type="text/css"
              media="screen" />
    </head>
    <script type="text/javascript" src="jquery-1.5.1.js"></script>
    <script type="text/javascript" src="j.js">
    </script>
    <body>
        <form action="Controller" method="post" enctype="multipart/form-data">
            <input type="hidden" value="${idProvider}" name="idProvider"></input>
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
                    <input type="hidden" value="${idProvider}" name="idProvider"></input>
                    <input type="hidden" value="${idClient}" name="idClient"></input>
                    <p align="left">BelNetInter открывает новые возможности для своих будущих абонентов. Оставить заявку на подключение к интернету можно на сайте BelNetInter.by . 
                        Подключение online – это экономия вашего времени, ведь сделать это можно в интернет-кафе, на работе или в гостях у друзей, не посещая центры подключения.</p>

                    <c:if test="${not empty login or not empty loginProvider  }"><button align="left" class="but" type="submit" value="logoutUser" name="command"><FONT face="Comic Sans MS">Выход</font></button></c:if>

                    </form> 
                </div>
                <div id="menu">
                    <h2>
                        <a href="#">Клиенты</a>
                    </h2>


                    <form action="Controller" method="post"
                          enctype="multipart/form-data" name="myform">
                        <input type="hidden" value="${idProvider}" name="idProvider"></input>
                    <table id="results">
                        <tr>
                            <td align="center" bgcolor="#F8F8FF">№</td>
                            <td align="center" bgcolor="#F8F8FF">ФИО</td>
                            <td align="center" bgcolor="#F8F8FF">Серия</td>
                            <td align="center" bgcolor="#F8F8FF">Номер</td>
                            <td align="center" bgcolor="#F8F8FF">Адрес</td>
                            <td align="center" bgcolor="#F8F8FF">Email</td>
                            <td align="center" bgcolor="#F8F8FF">Логин</td>
                            <td align="center" bgcolor="#F8F8FF">Пароль</td>
                        </tr>

                        <c:forEach items="${clientList}" var="client"
                                   varStatus="counter">
                            <tr>
                                <td><input type='text' value='${counter.count}'
                                           size='2' name="count" readonly /></td>
                                <td><input type='text' value='${client.fullName}'
                                           size='10' name="fullName" readonly /></td>
                                <td><input type='text' value='${client.seriaPassport}'
                                           size='10' name="seriaPassport" readonly /></td>
                                <td><input type='text' value='${client.numPassport}'
                                           size='10' name="numPassport" readonly /></td>
                                <td><input type='text' value='${client.adress}'
                                           size='10' name="adress" readonly /></td>
                                <td><input type='text' value='${client.email}'
                                           size='10' name="nameUser" readonly /></td>
                                <td><input type='text' value='${client.login}'
                                           size='10' name="nameUser" readonly /></td>
                                <td><input type='text' value='${client.password}'
                                           size='5' name="nameUser" readonly /></td>
                            </tr>
                           
                        </c:forEach> 
                            <tr><b><a href="service.jsp"><FONT face="Comic Sans MS">Назад</font></a></b></tr>
                    </table>

                </form>

            </div>
        </div>
        <div id="rightcontent">
            <img src="images/client.jpg"  width="65%" height="500px" align="right">
        </div>



        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>
</html>