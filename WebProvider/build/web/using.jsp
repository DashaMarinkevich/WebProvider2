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

                <p align="left">Уважаемый абонент!
                    <br>
                    Чтобы упростить для вас пользование услугами byfly, предлагаем вам воспользоваться Памятками для абонентов:
                    <br>
                    1. Памятка по подключению к byfly по технологии ADSL
                    <br>
                    2. Памятка по подключению к byfly по технологии Wi-Fi (для настройки доступа по предоплаченным картам)
                    <br>
                    3. Памятка по подключению к byfly по технологии WiMax
                    <br>
                    4. Памятка по контролю за состоянием лицевого счета
                    <br>
                    Важно! С того момента, как Вы впервые воспользовались услугой доступа к сети Интернет, Вы стали участником сетевого сообщества. Как и в любом сообществе в сети Интернет существуют свои правила поведения, с которыми можно ознакомиться здесь.

                    <br>
                    Информацию о настройках операционной системы и оконечного оборудования для настройки доступа к сети Интернет можно скачать здесь.

                    <br>

                    Техническая поддержка абонентов byfly всех регионов страны осуществляется по номеру 123.
                </p>
            </div>
        </div>
        <div id="rightcontent">
            <img src="images/using.jpg" align="center" width="80%" height="100%"/>  
        </div>
        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>


</html>
