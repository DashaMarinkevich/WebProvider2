<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="pays" scope="request"
             class="entity.Pays" />
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
                <form action="Controller" method="get"
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
                        <a href="#">Информация о платежах клиента</a>
                    </h2>


                    <form action="Controller" method="get"
                          enctype="multipart/form-data" name="myform">
                        <input type="hidden" value="${idClient}" name="idClient"></input>
                    <input type="hidden" value="${numPersAccount}" name="numPersAccount"></input>
                    <table id="results">
                        <tr>
                            <td align="center" bgcolor="#F8F8FF">№ платежа</td>
                            <td align="center" bgcolor="#F8F8FF">Клиент</td>
                            <td align="center" bgcolor="#F8F8FF">Дата оплаты</td>
                            <td align="center" bgcolor="#F8F8FF">Сумма</td>
                        </tr>

                        <c:forEach items="${serviceList}" var="pays"
                                   varStatus="counter">
                            <tr>
                                <td><input type='text' value='${pays.numPays}'
                                           name="count" readonly /></td>
                                <td><input type='text' value='${pays.client.fullName}'
                                           name="descripService" readonly /></td>
                                <td><input type='text' value='${pays.datePay}'
                                           name="priceService" readonly /></td>
                                <td><input type='text' value='${pays.sumPay}'
                                           name="note" readonly /></td>


                                <td align="center"></td>
                                <%-- <td align="center"><input type="radio"
                                        value='${user.idUser}' name='updUser' /></td> --%>
                            </tr>

                        </c:forEach>
                    </table>

                    <a href="service.jsp">Назад</a>
                </form>

            </div>
        </div>
        <div id="rightcontent">
            <img src="images/payhistory.jpg" height="500px" align="right" width="75%"/>  
        </div>
        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>
</html>
