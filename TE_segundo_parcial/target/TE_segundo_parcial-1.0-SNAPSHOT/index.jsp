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
        <h3>SEGUNDO PARCIAL - TEM-742</h3> <br>
        <h3>NOMBRE: ALBERTO ALARCON MAMANI</h3> <br>
        <h3>CI: 8296768</h3>
    </center>
    <br>
    <a href="index.jsp"><input type="button" value="Participantes"></a>
    <a href="index_1.jsp"><input type="button" value="Seminarios"></a>

    <br>
    <center><h1>REGISTRO DE PARTICIPANTES</h1></center>
    <br>
    <a href="MainController?op=nuevo">Nuevo</a>
    <br><br>
    <center><table border = "1">
            <tr>
                <th>Id</th>
                <th>Apellidos</th>
                <th>Nombres</th>
                <th>Id_Seminario</th>
                <th>Confirmado</th> 
            </tr>

            <c:forEach var="item" items="${lista}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.apellidos}</td>
                    <td>${item.nombres}</td>
                    <td>${item.id_seminario}</td>
                    <td>${item.confirmado}</td>
                    <td><a href ="MainController?op=eliminar&id=${item.id}"
                           onclick='return confirm("esta seguro de eliminar el registro?");'>Eliminar</a></td>
                </tr>
            </c:forEach>            
        </table></center>   

</body>
</html>
