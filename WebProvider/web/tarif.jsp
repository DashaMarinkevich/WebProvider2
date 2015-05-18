<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<jsp:useBean id="tarifplan" scope="request"
             class="entity.TarifPlan"/>
<jsp:useBean id="service" scope="request"
             class="entity.Service"/>
<!DOCTYPE>
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
            <input type="hidden" value="${numPersAccount}" name="numPersAccount"></input>
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
                    <img src="images/chts.jpg" width="100%" height="350px">
                </div>
            </div>
            <div id="rightcontent">
                <h2>
                    <a href="#">Изменение тарифного плана и услуг</a>
                </h2>


                <form action="Controller" method="post" enctype="multipart/form-data" name="myform">
                    <input type="hidden" value="${idClient}" name="idClient"></input>
                <input type="hidden" value="${numPersAccount}" name="numPersAccount"></input>

                <h2></h2>
                <table id="results">
                    <tr>

                        <td align="center" bgcolor="#F8F8FF">Название</td>
                        <td align="center" bgcolor="#F8F8FF">Трафик</td>
                        <td align="center" bgcolor="#F8F8FF">Скорость</td>
                        <td align="center" bgcolor="#F8F8FF">Цена</td>
                    </tr>

                    <c:forEach items="${tarifList}" var="tarifplan"
                               varStatus="counter">
                        <tr>

                            <td><label><input type='radio' value='${tarifplan.nameTarif}'
                                              size='10' name="tarif" readonly />${tarifplan.nameTarif}</label></td>
                            <td><input type='text' value='${tarifplan.trafic}'
                                       size='10' name="trafic" readonly /></td>
                            <td><input type='text' value='${tarifplan.speed}'
                                       size='10' name="speed" readonly /></td>
                            <td><input type='text' value='${tarifplan.price}'
                                       size='10' name="price" readonly /></td>


                        </tr>

                    </c:forEach>
                </table>

                <table id="results">
                    <tr>

                        <td align="center" bgcolor="#F8F8FF">Описание</td>
                        <td align="center" bgcolor="#F8F8FF">Цена</td>
                        <td align="center" bgcolor="#F8F8FF">Примечания</td>



                    </tr>

                    <c:forEach items="${serviceList}" var="service"
                               varStatus="counter">
                        <tr>

                            <td><label><input type='checkbox' value='${service.descripService}'
                                              size='10' name="descripService" readonly />${service.descripService}</label></td>
                            <td><input type='text' value='${service.priceService}'
                                       size='10' name="priceService" readonly /></td>
                            <td><input type='text' value='${service.note}'
                                       size='10' name="note" readonly /></td>

                        </tr>

                    </c:forEach>
                </table>
                <table>

                    <tr>
                        <td style="  color:  #000000;">Состояние договора</td>
                        <td>
                            <select name="statusContract">
                                <option value="Заключен">Заключен</option>
                                <option value="Изменен">Изменен</option>
                                <option value="Расторгнут">Расторгнут</option>
                                ></select></td>
                    </tr>
                </table>

                <button style=" background: #F5F5F5; color: black;" type="submit" value='updateContract'
                        name='command'><FONT face="Comic Sans MS">Готово</font></button>

                <b><a href="contract.jsp"><FONT face="Comic Sans MS">Отмена</font></a></b>


            </form>


        </div>
        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>

    <script>
        var d = new Date();
        var curr_date = d.getDate();
        var curr_month = d.getMonth() + 1;
        var curr_year = d.getFullYear();
        if (curr_date < 10) {
            curr_date = "0" + curr_date;
        }
        if (curr_month < 10) {
            curr_month = "0" + curr_month;
        }
        document.getElementById("data").value = curr_date + "." + curr_month + "." + curr_year;
    </script>
</html>
