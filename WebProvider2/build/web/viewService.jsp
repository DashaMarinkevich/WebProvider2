<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="service" scope="request"
             class="entity.Service" />
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

                    <h2>
                        <a href="#">Услуги</a>
                    </h2>

                    <form action="Controller" method="post"
                          enctype="multipart/form-data" name="myform">
                        <table>
                            <tr>
                                <td align="center" bgcolor="#F8F8FF">№</td>
                                <td align="center" bgcolor="#F8F8FF">Описание</td>
                                <td align="center" bgcolor="#F8F8FF">Цена</td>
                                <td align="center" bgcolor="#F8F8FF">Примечания</td>


                                <!-- <td align="center" bgcolor="#A9BD47">Обновить</td> -->
                            </tr>

                        <c:forEach items="${serviceList}" var="service"
                                   varStatus="counter">
                            <tr>
                                <td><input type='text' value='${counter.count}'
                                           name="count" readonly /></td>
                                <td><input type='text' value='${service.descripService}'
                                           name="descripService" readonly /></td>
                                <td><input type='text' value='${service.priceService}'
                                           name="priceService" readonly /></td>
                                <td><input type='text' value='${service.note}'
                                           name="note" readonly /></td>
                            </tr>

                        </c:forEach>
                    </table>


                </form> 
            </div>
        </div>
        <div id="rightcontent">
            <img src="images/service.jpg"  width="75%" height="500px" align="right">
        </div>



        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>
</html>