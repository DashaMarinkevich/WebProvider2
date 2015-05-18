<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="contract" scope="request"
             class="entity.Contract" />
<jsp:useBean id="contr_serv" scope="request"
             class="entity.Contract_Service" />
<!DOCTYPE >
<html>

    <head>

        <link href="sty.css" rel="stylesheet" media="all" /> 
        <link rel="stylesheet" href="style.css" type="text/css"
              media="screen" /><link rel="stylesheet" href="table.css" type="text/css"
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
                    <input type="hidden" value="${idClient}" name="idClient"></input>
                    <input type="hidden" value="${idProvider}" name="idProvider"></input>
                    <p align="left">BelNetInter открывает новые возможности для своих будущих абонентов. Оставить заявку на подключение к интернету можно на сайте BelNetInter.by . 
                        Подключение online – это экономия вашего времени, ведь сделать это можно в интернет-кафе, на работе или в гостях у друзей, не посещая центры подключения.</p>

                    <c:if test="${not empty login or not empty loginProvider  }"><button align="left" class="but" type="submit" value="logoutUser" name="command"><FONT face="Comic Sans MS">Выход</font></button></c:if>

                    </form> 
                </div>
                <div id="menu">
                    <h2>
                        <a href="#">Контракты</a>
                    </h2>


                    <form action="Controller" method="post"
                          enctype="multipart/form-data" name="myform">
                        <input type="hidden" value="${idProvider}" name="idProvider"></input>
                    <table id="results">
                        <tr>
                            <td align="center" bgcolor="#F8F8FF">№ договора</td>
                            <td align="center" bgcolor="#F8F8FF">Дата договора</td>
                            <td align="center" bgcolor="#F8F8FF">ФИО клиента</td>
                            <td align="center" bgcolor="#F8F8FF">Логин клиента</td>
                            <td align="center" bgcolor="#F8F8FF">Номер лицевого счета </td>
                            <td align="center" bgcolor="#F8F8FF">Тариф </td>
                            <td align="center" bgcolor="#F8F8FF">Услуги </td>
                        </tr>

                        <c:forEach items="${contractList}" var="contract"
                                   varStatus="counter">
                            <tr>
                                <td><input type='text' value='${contract.numContract}'
                                           size='2' name="count" readonly /></td>
                                <td><input type='text' value='${contract.dateContract}'
                                           size='2' name="count" readonly /></td>
                                <td><input type='text' value='${contract.client.fullName}'
                                           size='10' name="fullName" readonly /></td>
                                <td><input type='text' value='${contract.client.login}'
                                           size='10' name="login" readonly /></td>

                                <td><input type='text' value="${contract.personalAccount.numPersAccount}"
                                           size='10' name="numPersAccount" readonly /></td>

                                <td><input type='text' value='${contract.tarifPlan.nameTarif}'
                                           size='10' name="nameTarif" readonly /></td>
                                    <c:forEach items="${service_contractList}" var="contr_serv">
                                        <c:if test="${contract.numContract==contr_serv.contract.numContract}"> 
                                        <td><input type='text' value='${contr_serv.service.descripService}'
                                                   name="service.descripService" readonly /></td></c:if></c:forEach>
                                    </tr>

                        </c:forEach>
                        <tr><b><a href="service.jsp"><FONT face="Comic Sans MS">Назад</font></a></b></tr>
                    </table>


                </form>


            </div>
        </div>
        <div id="rightcontent">
            <img src="images/prov.jpg"  width="50%" height="500px" align="right">
        </div>



        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>
</html>