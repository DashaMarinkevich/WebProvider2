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
        <link rel="stylesheet" href="button.css" type="text/css"
              />
    </head>
    <script type="text/javascript" src="jquery-1.5.1.js"></script>
    <script type="text/javascript" src="j.js">
    </script>

    <body>
        <form action="Controller" method="post" enctype="multipart/form-data">
            <input type="hidden" value="${idClient}" name="idClient">
            <input type="hidden" value="${idProvider}" name="idProvider">
            <div id="left" >
                <ul>
                    <li><button class="current" type="button" onclick="location.href = '/index.jsp'"><span>Главная</span></button></li>
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
            <div class="curvebox">
                <form action="Controller" method="post"
                      enctype="multipart/form-data" name="myform">
                    <input type="hidden" value="${idClient}" name="idClient"></input>
                    <input type="hidden" value="${numPersonalAccount}" name="idProvider"></input>
                    <input type="hidden" value="${idProvider}" name="idProvider"></input>
                    <p align="left">BelNetInter открывает новые возможности для своих будущих абонентов. Оставить заявку на подключение к интернету можно на сайте BelNetInter.by . 
                        Подключение online – это экономия вашего времени, ведь сделать это можно в интернет-кафе, на работе или в гостях у друзей, не посещая центры подключения.</p>

                    <c:if test="${not empty login or not empty loginProvider  }"><br><br><button align="left" class="but" type="submit" value="logoutUser" name="command"><FONT face="Comic Sans MS">Выход</font></button></c:if>

                    </form>   
                </div>
                <div id="menu">
                    <form action="Controller" method="post"
                          enctype="multipart/form-data" name="myform">
                        <input type="hidden" value="${idClient}" name="idClient"></input>
                    <input type="hidden" value="${idProvider}" name="idProvider"></input>
                    <input type="hidden" value="${numPersonalAccount}" name="idProvider"></input>
                    <c:if test="${empty loginProvider and not empty login}">
                        <button   class="button2" type="submit" value="persAccount" name="command">Получить информацию о лицевом счете</button>
                        <button class="button2" type="button" onclick="location.href = 'changecontract.jsp'">Изменение текущего договора</button>
                        <button class="button2" type="button" onclick="location.href = 'pays.jsp'">Просмотреть историю платежей</button>
                        <button class="button2" type="button" onclick="location.href = 'fpay.jsp'">Оформить обещанный платеж</button>
                    </c:if>
                    <c:if test="${not empty loginProvider }">
                        <ul><li><button   class="button2" type="submit" value="viewClient" name="command"><span>Клиенты</span></button></li>
                            <li><button   class="button2"  type="submit" value="viewContract" name="command"><span>Контракты</span></button></li>
                            <li><button   class="button2" type="submit" value="viewPays" name="command"><span>Все платежы</span></button></li>
                            <li><button   class="button2" type="button" onclick="location.href = 'addService.jsp'"><span>Добавить услугу</span></button><button   class="button2" type="button" onclick="location.href = 'deleteService.jsp'"><span>Удалить услугу</span></button></li>
                            <li><button   class="button2" type="button" onclick="location.href = 'addTarif.jsp'"><span>Добавить тариф</span></button><button   class="button2" type="button" onclick="location.href = 'deleteTarif.jsp'"><span>Удалить тариф</span></button></li></ul>
                    </c:if></form>
            </div>
        </div>
        <div id="rightcontent">
            <img src="images/serviceId.jpg">
        </div>

        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>

</html>
