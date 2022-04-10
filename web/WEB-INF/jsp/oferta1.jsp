<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oferta1</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </head>

    <body>
        <div class="card-header bg-dark text-white">
            <h2 style="font-family: cursive">CHEVROLET _</h2>
        </div>
        <br/> 
        <br/> 
        <div class="container">
            <a href="menu1.htm"  style="font-family: cursive" class="btn btn-success">MENÚ</a> 
            <a href="contacto1.htm" style="margin-left: 10px;font-family: cursive" class="btn btn-warning ">COTIZACIÓN</a>
        </div>
        <div class="container mt-4">
            <div class="card border-dark"> 
                <div class="card-body bg-dark text-white">
                    <table class="table table-hover">
                        <div class="text-white">
                            <h4 style="font-family: cursive">OFERTA CHEVROLET </h4>
                        </div>
                        <thead>
                            <tr>
                                <th style="font-family: cursive" class="text-white">NºPRODUCTO</th>
                                <th style="font-family: cursive" class="text-white">MODELO</th>
                                <th style="font-family: cursive" class="text-white">COLOR</th>
                                <th style="font-family: cursive" class="text-white">PRECIO</th>
                                <th style="font-family: cursive" class="text-white">CUOTAS</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${lista}">
                                <tr>
                                    <td style="font-family: cursive" class="text-white">${dato.id}</td>
                                    <td style="font-family: cursive" class="text-white">${dato.modelo}</td>
                                    <td style="font-family: cursive" class="text-white">${dato.color}</td>
                                    <td style="font-family: cursive" class="text-white">${dato.precio}</td>
                                    <td style="font-family: cursive" class="text-white">${dato.cuota}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>  
        </div>  
    </body>
</html>
