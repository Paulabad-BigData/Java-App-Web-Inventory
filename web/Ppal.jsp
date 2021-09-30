<%-- 
    Document   : Ppal
    Created on : 2/09/2021, 10:25:11 AM
    Author     : paulabad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <title>Menu Principal</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-secondary">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a style="margin-left: 12px; border : none" class= "btn btn-outline-light" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 12px; border : none" class= "btn btn-outline-light" href="Controlador?menu=Empleado&accion=mostrar" target="myframe">Empleados</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 12px; border : none" class= "btn btn-outline-light" href="Controlador?menu=Cliente&accion=mostrar" target="myframe">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 12px; border : none" class= "btn btn-outline-light" href="Controlador?menu=Producto&accion=mostrar" target="myframe">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 12px; border : none" class= "btn btn-outline-light" href="Controlador?menu=Movimiento&accion=default" target="myframe">Movimientos</a>
                    </li>
                </ul>
            </div>
            <div class="dropdown">
                <button style="margin-right: 120px; border: none; "class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${usuario.getUsua()}
                </button>
                <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">
                        <img src="img/Logo.jpeg" alt="" style="height:60px"/>
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getNombres()}</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar"method="POST">
                        <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                    </form>
                </div>
            </div>
</nav>
<div class="ms-4" style="height: 600px">
    <iframe name="myframe" style="height: 100%; width: 100%; border: none"></iframe>
</div>            



<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

</body>
</html>
