<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="UTF-8" />
<jsp:useBean id="contract" scope="request"
             class="entity.Contract" />
<jsp:useBean id="contract_service" scope="request"
             class="entity.Contract_Service" />
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
                    <img src="images/sotrud.jpg" width="100%" height="350px">
                </div>
            </div>
            <div id="rightcontent">
                <h2>
                    <a href="#">Информация о договоре клиента</a>
                </h2>
                <form action="Controller" method="post"
                      enctype="multipart/form-data" name="myform">
                    <input type="hidden" value="${idClient}" name="idClient"></input>
                <input type="hidden" value="${numPersAccount}" name="numPersAccount"></input>
                <input type="hidden" value="${numContract}" name="numContract"></input>
                <table id="results">

                    <c:forEach items="${contractList}" var="contract"
                               varStatus="counter">
                        <tr>
                            <td align="center" bgcolor="#F8F8FF">№ договора</td>
                            <td><input type='text' value='${contract.numContract}'
                                       size='20' name="numContract" readonly /></td>
                        </tr>
                        <tr>
                            <td align="center" bgcolor="#F8F8FF">Дата заключения</td>
                            <td><input type='text' value='${contract.dateContract}'
                                       size='20' name="dateContract" readonly /></td>

                        </tr>
                        <tr>
                            <td align="center" bgcolor="#F8F8FF">Клиент:</td>

                        </tr>
                        <tr>   <td align="center" bgcolor="#F8F8FF">ФИО клиента</td>
                            <td><input type='text' value='${contract.client.fullName}'
                                       size='20' name="client.fullName" readonly /></td></tr>
                        <tr>
                            <td align="center" bgcolor="#F8F8FF">Паспортные данные</td>
                            <td><input type='text' value='${contract.client.seriaPassport}  ${contract.client.numPassport}'
                                       size='20' name="client.seriaPassport" readonly />
                            </td>    
                        </tr>
                        <tr>
                            <td align="center" bgcolor="#F8F8FF">Тарифный план </td>
                            <td><input type='text' value='${contract.tarifPlan.nameTarif}'
                                       size='20' name="tarifPlan.nameTarif" readonly />

                            </td>

                        </tr>
                        <tr>
                            <td align="center" bgcolor="#F8F8FF">Услуги</td>
                            <c:forEach items="${contract_serviceList}" var="contract_service">
                                <td><input type='text' value='${contract_service.service.descripService}'
                                           size='20' name="service.descripService" readonly /></td></c:forEach>
                            </tr>
                            <tr>
                                <td align="center" bgcolor="#F8F8FF">Состояние договора </td>
                                <td><input type='text' value='${contract.statusContract}'
                                       size='20' name="statusContract" readonly /></td>


                        </tr>

                    </c:forEach>
                </table>
                <button  type="submit" value="changeTarifService" name="command"><span>Изменить</span></button>
                <a style=" background: #F5F5F5; color: black;" href="service.jpg"><FONT face="Comic Sans MS">Назад</font></a>
            </form>

        </div>
        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>

</html>
