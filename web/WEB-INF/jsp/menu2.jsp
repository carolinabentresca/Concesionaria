<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú2</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </head>

    <body>
        <div class="card-header bg-dark text-white">
            <h2 style="font-family: cursive">FORD _ </h2>
        </div>
        <br/> 
        <div class="container">
            <a href="index.htm"  style="font-family: cursive" class="btn btn-success">INICIO</a> 
            <a href="venta2.htm" style="margin-left: 10px;font-family: cursive" class="btn btn-warning">DESTACADOS</a>
        </div>
        <div class="container mt-4">
            <div class="card border-dark"> 
                <div class="card-body bg-dark text-white">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th style="font-family: cursive" class="text-white">NºPRODUCTO</th>
                                <th style="font-family: cursive" class="text-white">MARCA</th>
                                <th style="font-family: cursive" class="text-white">MODELO</th>
                                <th style="font-family: cursive" class="text-white">PRECIO</th>
                                <th style="font-family: cursive" class="text-white">OFERTA</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${lista}">
                                <tr>
                                    <td style="font-family: cursive" class="text-white">${dato.id}</td>
                                    <td style="font-family: cursive" class="text-white">${dato.marca}</td>
                                    <td style="font-family: cursive" class="text-white">${dato.modelo}</td>
                                    <td style="font-family: cursive" class="text-white">${dato.precio}</td>
                                    <td>
                                        <a href="oferta2.htm?id=${dato.id}"  style="font-family: cursive" class="btn btn-danger text-white">VER</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>  
        </div>         
    </body>
</html>
