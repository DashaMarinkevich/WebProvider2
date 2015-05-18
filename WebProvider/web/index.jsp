<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="contract" scope="request"
             class="entity.Contract" />
<!DOCTYPE >
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"
              media="screen" />
        <link rel="stylesheet" href="button.css" type="text/css"
              />
    </head>
    <script type="text/javascript" src="jquery-1.5.1.js"></script>
    <script type="text/javascript" src="j.js">
    </script>

    <body >
        <form action="Controller" method="post" enctype="multipart/form-data">
            <input type="hidden" value="${idClient}" name="idClient"></input>
            <div id="left" >
                <ul>
                    <li><button class="current" type="button" onclick="location.href = '/index.jsp'"><span>Главная</span></button></li>
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
            <div class="curvebox">

                <h4>
                    <a href="#">Кабинет пользователя</a>
                </h4>

                <form action="Controller" method="post"
                      enctype="multipart/form-data" name="myform">
                    <input type="hidden" value="${idClient}" name="idClient"></input>
                    <table>
                        <tr>
                            <td style="  color:  #000000;"><FONT face="Comic Sans MS">Логин :</font></td>
                        </tr>
                        <tr>
                            <td><input type="login" name='login' pattern="^[а-яА-ЯёЁa-zA-Z0-9]+$"  title="Пример:login" size='20'
                                       /></td>
                        </tr>
                        <tr>
                            <td style="  color:  #000000;"><FONT face="Comic Sans MS">Пароль:</font></td>
                        </tr>
                        <tr>
                            <td><input type="password" name='password' pattern="^(?=.*\d)(?=.*[a-z])(?!.*\s).*$" title="Пример:111as"
                                       size='20' required="required" /></td>
                        </tr>
                        <tr>
                            <td><button style=" background: #F5F5F5; color: black;" type="submit" value='login'
                                        name='command'><FONT face="Comic Sans MS">Вход</font></button></td>

                            <c:if test="${ empty login or empty idClient and not empty loginProvider  }"><td><b><a href="regist.jsp"><FONT face="Comic Sans MS">Зарегистрироваться</font></a></b></td></c:if>
                            </tr>
                        </table>
                    </form>


                </div>              


                <div id="menu">
                    <form action="Controller" method="post" enctype="multipart/form-data" name="myform">    
                        <input type="hidden" value="${idClient}" name="idClient"></input>  
                    <ul>
                        <li> <button  type='submit' class="button2" value='inter'   name='command'>Подключение</button> </li>
                        <li>  <button   class="button2" type="button" onclick="location.href = 'using.jsp'">Обслуживание</button> </li>
                        <li>  <button   class="button2" type="button" onclick="location.href = 'tehnolog.jsp'">Использование</button> </li>
                    </ul>    
                </form>    
            </div>
        </div>
        <div id="rightcontent">
            <img src="images/47.jpg" >
        </div>
        <div id="footer" > BelNetInter РУП "Белтелеком" Республика Беларусь</div>
    </body>

</html>
