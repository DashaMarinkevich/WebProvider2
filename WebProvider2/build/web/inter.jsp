<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:useBean id="client" scope="request"
             class="entity.Client"/>
<jsp:useBean id="tarifplan" scope="request"
             class="entity.TarifPlan"/>
<jsp:useBean id="service" scope="request"
             class="entity.Service"/>
<!DOCTYPE >
<html>
    <head>


        <link rel="stylesheet" href="style.css" type="text/css"
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



                <form action="Controller" method="post"
                      enctype="multipart/form-data" name="myform">
                    <h2></h2>
                    <c:if test="${not empty login and not empty password}"><button class="but" type="submit" value="logoutUser" name="command"><FONT face="Comic Sans MS">Выход</font></button></c:if></li>
                    <c:if test="${empty login or empty password}"><button class="but" type="button" onclick="location.href = 'loginPage.jsp'"><FONT face="Comic Sans MS">Войти в кабинет пользователя</font></button></c:if>

                    </form>

                </div>
                <div id="menu">
                    <img src="images/sotrud.jpg" width="100%" height="680px">
                </div>
            </div>
            <div id="rightconract">
                <h2>
                    <a href="#">Заключение договора</a>
                </h2>



                <form action="Controller" method="post" enctype="multipart/form-data" name="myform">
                    <input type="hidden" value="${idClient}" name="idClient"></input>
                <input type="hidden" value="${idTarif}" name="idTarif"></input>
                <h2></h2>
                <table>

                    <tr>
                        <td style="  color:  #000000;"><FONT face="Comic Sans MS">Дата заключения:</font></td>
                    </tr>
                    <tr>
                        <td><input type="dataContract"  name='dateContract'
                                   id="data" size='20' required="required" /></td>
                    </tr>
                    <tr>
                        <td style="  color:  #000000;"><FONT face="Comic Sans MS">Клиент:</font></td>
                    </tr>

                    <c:if test="${not empty login}">
                        <c:forEach items="${clientList}" var="client"
                                   varStatus="counter">

                            <tr>

                            </tr>

                            <tr>
                                <td style="  color:  #000000;">Логин</td>
                            </tr>
                            <tr>
                                <td><input type="login" name='login' value='${client.login}'
                                           size='20' required="required" /></td>
                            </tr>
                            <tr>
                                <td style="  color:  #000000;">Номер лицевого счета</td>
                            </tr>
                            <tr>
                                <td><input  name='numPersonalAccount' value="${numPersAccount}" size='20'
                                            required="required" /></td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty login}">
                        <tr>
                            <td style="  color:  #000000;">ФИО</td>
                        </tr>
                        <tr>
                            <td><input type='text' name='fullName' size='20' pattern="[а-яА-ЯёЁ\s]+$"   title="Пример :Иванов Иван .."
                                       required="required" /></td>
                        </tr>
                        <tr>
                            <td style="  color:  #000000;">Серия паспорта</td>
                        </tr>
                        <tr>
                            <td><input type='text' name='seriaPassport'  pattern="^[a-zA-Z]{2}$" size='20' title="Вводите только 2 символа"
                                       required="required" /></td>
                        </tr>
                        <tr>
                            <td style="  color:  #000000;">Номер паспорта</td>
                        </tr>
                        <tr>
                            <td><input type='numPassport' name='numPassport'  pattern="\-?\d+(\.\d{0,})?" size='20' title="Вводите только цифры!"
                                       required="required" /></td>
                        </tr>
                        <tr>
                            <td style="  color:  #000000;">Адрес</td>
                        </tr>
                        <tr>
                            <td><input type=text' name='adress' pattern="[а-яА-ЯёЁ0-9\s,.]+$" size='20'  title="Пример : ул.Ленина 21"
                                       required="required" /></td>
                        </tr>
                        <tr>
                            <td style="  color:  #000000;">Email</td>
                        </tr>
                        <tr>
                            <td><input type="email" name='email' size='20'title="Пример:dasha@ru"
                                       required="required" /></td>
                        </tr>
                        <tr>
                            <td style="  color:  #000000;">Логин</td>
                        </tr>
                        <tr>
                            <td><input type="login" name='login' pattern="^[а-яА-ЯёЁa-zA-Z0-9]+$"   title="Пример : login"
                                       size='20' required="required" /></td>
                        </tr>
                        <tr>
                            <td style="  color:  #000000;">Пароль</td>
                        </tr>
                        <tr>
                            <td><input type="password" name='password' pattern="^(?=.*\d)(?=.*[a-z])(?!.*\s).*$"  title="Пример :111as"
                                       size='20' required="required" /></td>
                        </tr>
                        <tr>
                            <td style="  color:  #000000;">Номер лицевого счета</td>
                        </tr>
                        <tr>

                            <td><input  name='numPersonalAccount' value="${numPersAccount}" pattern="\-?\d+(\.\d{0,})?" size='20' title="Вводите только цифры!" 
                                        required="required" /></td>
                        </tr>
                    </c:if>


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

                    <tr>
                        <td style="  color:  #000000;">Состояние договора</td>
                    </tr>
                    <tr>
                        <td><select name="statusContract">
                                <option value="Заключен">Заключен</option>
                                <option value="Изменен">Изменен</option>
                                <option value="Расторгнут">Расторгнут</option>
                                ></select></td>
                    </tr>
                    <tr>
                        <td><button style=" background: #F5F5F5; color: black;" type="submit" value='addContract'
                                    name='command'><FONT face="Comic Sans MS">Готово</font></button></td>

                        <td><b><a href="index.jsp"><FONT face="Comic Sans MS">Отмена</font></a></b></td>
                    </tr>
                </table>
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
