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
                        <a href="#">Платежи клиентов</a>
                    </h2>


                    <form action="Controller" method="post"
                          enctype="multipart/form-data" name="myform">
                        <input type="hidden" value="${idClient}" name="idClient"></input
                    <input type="hidden" value="${idProvider}" name="idProvider"></input>
                    <table id="results">
                        <tr>
                            <td align="center" bgcolor="#F8F8FF">№ платежа</td>
                            <td align="center" bgcolor="#F8F8FF">ФИО клиента</td>
                            <td align="center" bgcolor="#F8F8FF">Серия паспорта</td>
                            <td align="center" bgcolor="#F8F8FF">Номер паспорта</td>

                            <td align="center" bgcolor="#F8F8FF">Логин клиента</td>
                            <td align="center" bgcolor="#F8F8FF">Сумма платежа</td>
                            <td align="center" bgcolor="#F8F8FF">Дата платежа</td>
                            <td align="center" bgcolor="#F8F8FF">Номер лицевого счета</td>
                            <!-- <td align="center" bgcolor="#A9BD47">Обновить</td> -->
                        </tr>

                        <c:forEach items="${paysList}" var="pays"
                                   varStatus="counter">
                            <tr>
                                <td><input type='text' value='${pays.numPays}'
                                           size='2' name="count" readonly /></td>
                                <td><input type='text' value='${pays.client.fullName}'
                                           size='10' name="fullName" readonly /></td>
                                <td><input type='text' value='${pays.client.seriaPassport}'
                                           size='10' name="seriaPassport" readonly /></td>
                                <td><input type='text' value='${pays.client.numPassport}'
                                           size='10' name="numPassport" readonly /></td>

                                <td><input type='text' value='${pays.client.login}'
                                           size='10' name="nameUser" readonly /></td>

                                <td><input type='text' value='${pays.sumPay}'
                                           size='10' name="nameUser" readonly /></td>
                                <td><input type='text' value='${pays.datePay}'
                                           size='10' name="nameUser" readonly /></td>
                                <td><input type='text' value='${pays.personalAccount.numPersAccount}'
                                           size='10' name="nameUser" readonly /></td>
                            </tr>

                        </c:forEach>
                             <tr><b><a href="service.jsp"><FONT face="Comic Sans MS">Назад</font></a></b></tr>
                    </table>

                </form>



            </div>
        </div>
        <div id="rightcontent">
            <img src="images/pays.jpg"  width="60%" height="500px" align="right">
        </div>



        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>
</html>