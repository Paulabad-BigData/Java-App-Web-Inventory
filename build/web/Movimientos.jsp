<%-- 
    Document   : Movimientos
    Created on : 29/09/2021, 09:41:32 PM
    Author     : paulabad
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/aa768af1b4.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container ml-4 mt-4">
            <h1>Datos del Cliente</h1>
            <form action="Controlador?menu=Movimiento" method="POST">
                <div class="form-row">
                    <div class="col-4">
                        <input type="text" value="${cliente.getDni()}" name="codCliente" class="form-control" placeholder="Dni">
                    </div>
                    <div class="col-4 ml-2">
                        <input type="text" value="${cliente.getNombres()}" name="nombreCliente" class="form-control" placeholder="Nombre cliente">
                    </div>
                    <button type="submit" name="accion" value="buscaC" class="btn btn-success">
                        Buscar<i class="fas fa-search ml-1"></i>
                    </button>
                </div>
            </form>
        </div>




        <div class="container mt-4 ml-4">
            <h1>Productos</h1>
            <form action="Controlador?menu=Movimiento" method="POST">

                <div class="form-row">
                    <div class="col-2">

                        <input type="text" value="${producto.getSerial()}" name="codProducto" class="form-control" placeholder="Serial">
                    </div>
                    <div class="col-2">

                        <input type="text" value="${producto.getDescrip()}" name="nombreProducto" class="form-control" placeholder="Descripcion">
                    </div>
                    <div class="col-2">

                        <input type="text" value="${producto.getPrecio()}" name="precio" class="form-control" placeholder="Precio">
                    </div>
                    <div class="col-2">

                        <input type="text" value="${producto.getStock()}" name="cantidad" class="form-control" placeholder="Stock">
                    </div>
                    <div class="col-2">

                        <input type="text" value="${producto.getEstado()}" name="estado" class="form-control" placeholder="Estado">
                    </div>
                    <button type="submit" name="accion" value="buscaP" class="btn btn-success">
                        Buscar<i class="fas fa-search"></i>
                    </button>
                </div>
                <br>

                <button type="submit" name="accion" value="cargar" class="btn btn-secondary">
                    Cargar<i class="fas fa-search"></i>
                </button>
            </form>
        </div>

        <br>
        <br>
        <div class="d-flex" style="align-items: center; justify-content: center;">
            <div class="col-sm-12" >

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Codigo</th>
                            <th>Descripcion</th>
                            <th>Precio</th>
                            <th>Cantidad</th>
                            <th>Subtotal</th>
                            <th>Acciones</th>

                        </tr>
                    </thead>
                    <tbody>
                        <!--Se define variable em(recibe el parametro empleados del controlador)-->
                        <c:forEach var="movi" items="${listM}">
                        <tr>
                            <td>${movi.getItem()}</td>
                            <td>${movi.getIdM()}</td>
                            <td>${movi.getDescr()}</td>
                            <td>${movi.getPrecio()}</td>
                            <td>${movi.getCant()}</td>
                            <td>${movi.getSubt()}</td>


                            <td>
                                <a class="btn btn-success" href="Controlador?menu=Producto&accion=carga&id=">
                                    <i class="fas fa-edit"></i>Editar
                                </a>
                                <a class="btn btn-secondary" href="Controlador?menu=Producto&accion=elimina&id=">
                                    <i class="far fa-trash-alt"></i>Borrar
                                </a>
                            </td>

                        </tr>


                    </c:forEach>

                    </tbody>
                </table>


            </div>
        </div>

        <div class="container mt-5 ml-1">

            <button type="submit" name="accion" value="salida" class="btn btn-success col-2">
                Salida<i class="fas fa-sign-out-alt ml-1"></i>
            </button>
            <button type="submit" name="accion" value="cancela" class="btn btn-warning col-2">
                Cancela<i class=""></i>
            </button>


        </div>



        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

    </body>
</html>
