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
        <link rel="stylesheet" href="table.css" type="text/css"
              media="screen" />
    </head>
    <script type="text/javascript" src="jquery-1.5.1.js"></script>
    <script type="text/javascript" src="j.js">
    </script>
    <body >
        <form action="Controller" method="post" >
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
                <form action="Controller" method="post" name="myform">
                    <input type="hidden" value="${idClient}" name="idClient"></input>
                    <input type="hidden" value="${idProvider}" name="idProvider"></input>
                    <p align="left">BelNetInter открывает новые возможности для своих будущих абонентов. Оставить заявку на подключение к интернету можно на сайте BelNetInter.by . 
                        Подключение online – это экономия вашего времени, ведь сделать это можно в интернет-кафе, на работе или в гостях у друзей, не посещая центры подключения.</p>

                    <c:if test="${not empty login or not empty loginProvider  }"><button align="left" class="but" type="submit" value="logoutUser" name="command"><FONT face="Comic Sans MS">Выход</font></button></c:if>

                    </form> 
                </div>
                <div id="menu">
                    <h2>
                        <a href="#">Информация о лицевом счете</a>
                    </h2>


                    <form action="Controller" method="post" name="myform">
                        <input type="hidden" value="${idClient}" name="idClient"></input>

                    <table id="results">
                        <c:forEach items="${serviceList}" var="contract"
                                   varStatus="counter">          
                            <tr>
                                <td>Номер лицевого счета</td><td><c:out value="${contract.personalAccount.numPersAccount}"/></td> 
                            <input type="hidden" value="${contract.personalAccount.numPersAccount}" name="numPersAccount"></input>
                            </tr>
                            <tr>
                                <td>ФИО</td><td><c:out value="${contract.client.fullName}"/></td>
                            </tr>
                            <tr>
                                <td>Состояние счета</td><td><c:out value="${contract.personalAccount.statusPersAccount}"/></td>
                            </tr>
                            <tr>
                                <td>Сумма на  счету</td><td><c:out value="${contract.personalAccount.sumPersAccount}"/></td>
                            </tr>
                            <tr>
                                <td>Tарифный план</td><td><c:out value="${contract.tarifPlan.nameTarif}"/></td>
                            </tr>
                            <tr>
                                <td>Email</td><td><c:out value="${contract.client.email}"/></td>
                            </tr>
                        </c:forEach>

                    </table>

                    <button class="but" type="button" onclick="location.href = 'addSumAccount.jsp'">Пополнить лицевой счет</button>       
                    <a href="service.jsp">Назад</a>
                </form>

            </div>
        </div>
        <div id="rightcontent">
            <img src="images/persacc.png" height="500px" align="right" width="90%"/>  
        </div>
        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>
</html>