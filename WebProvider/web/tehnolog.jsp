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

                <p align="left">Программное обеспечение
                    Версия для печати
                    Программа my-byfly представляет собой разработку, выполненную специально для byfly. Эта программа позволит вам получить качественно новый уровень сервиса.

                    В первую очередь это касается процедуры контроля за статистикой работы и состоянием лицевого счета. Теперь вам не придется постоянно заходить в кабинет пользователя только для того, чтобы узнать, сколько денег на счету. Программа проста и удобна в использовании. После установки она загружается в системный трей (небольшая часть панели задач в правом нижнем углу экрана). Вам достаточно «кликнуть» по значку программы, чтобы вызвать ее главное окно на экран и получить нужную вам информацию.

                    Помимо удобства контроля за статистикой, my-byfly будет незаменимым помощником при возникновении каких-либо проблем с настройками подключения. Вам больше не придется самостоятельно (или под руководством специалиста службы поддержки) обновлять какие-либо настройки. После установки my-byfly вам достаточно будет сообщить службе технической поддержки о том, что у вас есть проблема. После этого необходимые настройки будут сделаны на вашем модеме автоматически.

                    Программа my-byfly перепрошивает (то есть перепрограммирует) следующие типы модемов:

                    Промсвязь М-101B
                    Промсвязь М-101А
                    Промсвязь УА-200Б
                    Промсвязь УА-200А
                    Huawei EchoLife HG510
                    Huawei EchoLife HG520 B
                    Huawei EchoLife HG520 I
                    ZTE ZXDSL 831 Annex A
                    ZTE ZXDSL 832 Annex B
                    ZTE ZXV10 W300
                    ZTE ZXV W300B
                    Обратите внимание! После установки программы часть настроек сохранится, однако некоторые настройки после установки программы вам потребуется восстановить в ручном режиме. В первую очередь, это касается настроек беспроводного соединения по технологии Wi-Fi. Поэтому рекомендуем в обязательном  порядке ознакомиться с информацией о настройке Wi-Fi,
                    которая находится в справке программы-установщика новой прошивки модема.</p>

            </div>
        </div>
        <div id="rightcontent">
            <img src="images/teh.jpg" />  
        </div>
        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>


</html>
