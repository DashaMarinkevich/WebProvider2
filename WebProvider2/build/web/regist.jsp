<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="client" scope="request"
             class="entity.Client" />
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
                    <img src="images/registr.jpg" width="100%" height="360px">
                </div>
            </div>
            <div id="rightcontent">
                <h2>
                    <a href="#">Регистрация</a>
                </h2>

                <form action="Controller" method="post"
                      enctype="multipart/form-data" name="myform">
                    <input type="hidden" value="${idClient}" name="idClient"></input>
                <h2>

                </h2>							
                <table>
                    <tr>
                        <td style="  color:  #000000;">ФИО</td>
                    </tr>
                    <tr>
                        <td><input type='text' name='fullName'  value ="${fullName}" size='20' pattern="[а-яА-ЯёЁ\s]+$"  title="ВВодите только русские символы "
                                   required="required" /></td>
                    </tr>
                    <tr>
                        <td style="  color:  #000000;">Серия паспорта</td>
                    </tr>
                    <tr>
                        <td><input type='text' name='seriaPassport'  value ="${seriaPassport}" pattern="^[a-zA-Z]{2}$" size='20'  title="Пример:mc"
                                   required="required" /></td>
                    </tr>
                    <tr>
                        <td style="  color:  #000000;">Номер паспорта</td>
                    </tr>
                    <tr>
                        <td><input type='numPassport' name='numPassport' value ="${numPassport}"  pattern="\-?\d+(\.\d{0,})?" size='20' title="ВВодите только цифры!!"
                                   required="required" /></td>
                    </tr>
                    <tr>
                        <td style="  color:  #000000;">Адрес</td>
                    </tr>
                    <tr>
                        <td><input type=text' name='adress'  value ="${adress}"pattern="[а-яА-ЯёЁ0-9\s,.]+$" size='20'  title="Пример:ул.Ленина 21"
                                   required="required" /></td>
                    </tr>
                    <tr>
                        <td style="  color:  #000000;">Email</td>
                    </tr>
                    <tr>
                        <td><input type="email" name='email' value ="${email}" size='20'  title="Пример:dasha@ru"
                                   required="required" /></td>
                    </tr>
                    <tr>
                        <td style="  color:  #000000;">Логин</td>
                    </tr>
                    <tr>
                        <td><input type="login" name='login'  value ="${login}"pattern="^[а-яА-ЯёЁa-zA-Z0-9]+$" title="Пример:login"
                                   size='20' required="required" /></td>
                        <c:if test="${flag eq '1'}" >  <td>
                                <input type="text" name='loginCheck'  value ="Измените логин!!!" 
                                       size='20'  >

                            </td></c:if>
                        </tr>
                        <tr>
                            <td style="  color:  #000000;">Пароль</td>
                        </tr>
                        <tr>
                            <td><input type="password" name='password' value ="${password}" pattern="^(?=.*\d)(?=.*[a-z])(?!.*\s).*$"  title="Пример:111as"
                                   size='20' required="required" /></td>
                    </tr>
                    <tr>
                        <td><button style=" background: #F5F5F5; color: black; width: 157px" type="submit" value='addClient'
                                    name='command'>Зарегистрироваться</button></td>
                        <td align="right"><a href="index.jsp">Назад</a></td>
                    </tr>
                </table>
                <input type="hidden" id="flag" name="flag" value="${flag}">
            </form>  

        </div>
        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>


</html>