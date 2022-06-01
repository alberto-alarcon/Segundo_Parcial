<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 1 jun. de 2022, 02:47:17
    Author     : ALBERTO
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.participantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <br>
    <center>
        <h1>SEGUNDO PARCIAL - TEM-742</h1> <br>
        <h1>NOMBRE: ALBERTO ALARCON MAMANI</h1> <br>
        <h1>CI: 8296768</h1>
    </center>
    <br>
    <br>
    <form action="MainController" method="post">
        <centro><table border = "1">
                <input type="hidden" name="id" value="${lib.id}">
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellidos" value="${lib.apellidos}"></td>
                </tr>
                <tr>
                    <td>nombres</td>
                    <td><input type="text" name="nombres" value="${lib.apellidos}"></td>
                </tr>
                <tr>
                    <td>id_seminario</td>
                    <td><input type="text" name="id_seminarios" value="${lib.apellidos}"></td>
                </tr>
                <tr>
                    <td>confirmado</td>
                    <td><input type="text" name="confirmado" value="${lib.apellidos}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="enviar"></td>
                </tr>          
            </table></centro>


    </form>

</body>
</html>
