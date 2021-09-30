<%-- 
    Document   : Productos
    Created on : 09-sep-2021, 8:41:04
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
        <title>Productos</title>
    </head>
    <body>
        <div class="container ml-4 mt-4">
            <form action="Controlador?menu=Producto" method="POST">

                <div class="form-row">
                    <div class="col-2">
                        <label>SERIAL</label>
                        <input type="text" value="${producto.getSerial()}" name="txtser" class="form-control">
                    </div>
                    <div class="col-6">
                        <label>DESCRIPCION</label>
                        <input type="text" value="${producto.getDescrip()}" name="txtdescrp" class="form-control">
                    </div>
                    <div class="col-1">
                        <label>PRECIO</label>
                        <input type="text" value="${producto.getPrecio()}" name="txtpre" class="form-control">
                    </div>
                    <div class="col-1">
                        <label>STOCK</label>
                        <input type="text" value="${producto.getStock()}" name="txtstock" class="form-control">
                    </div>
                    <div class="col-1">
                        <label>ESTADO</label>
                        <input type="text" value="${producto.getEstado()}" name="txtest" class="form-control">
                    </div>
                </div>
                    <br>
      
                <button type="submit" name="accion" value="insertar" class="btn btn-secondary">
                    <i class="fas fa-user-plus"></i>Agregar
                </button>
                <button type="submit" name="accion" value="modifica" class="btn btn-warning">
                    <i class="fas fa-edit"></i>Actualizar
                </button>
            </form>
        </div>

        <!--<div class="form-group">
            <label>SERIAL</label>
            <input type="text" value="${producto.getSerial()}" name="txtser" class="form-control">
        </div>
        <div class="form-group">
            <label>DESCRIPCION</label>
            <input type="text" value="${producto.getDescrip()}" name="txtdescrp" class="form-control">
        </div>
        <div class="form-group">
            <label>PRECIO</label>
            <input type="text" value="${producto.getPrecio()}" name="txtpre" class="form-control">
        </div>
        <div class="form-group">
            <label>STOCK</label>
            <input type="text" value="${producto.getStock()}" name="txtstock" class="form-control">
        </div>
        <div class="form-group">
            <label>ESTADO</label>
            <input type="text" value="${producto.getEstado()}" name="txtest" class="form-control">
        </div>-->
        
        <br>
        <br>

        <div class="col-sm-12">
            
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>SERIAL</th>
                        <th>DESCRIPCION</th>
                        <th>PRECIO</th>
                        <th>STOCK</th>
                        <th>ESTADO</th>
                        <th>ACCION</th>


                    </tr>
                </thead>
                <tbody>
                    <!--Se define variable em(recibe el parametro empleados del controlador)-->
                    <c:forEach var="pro" items="${productos}">
                        <tr>
                            <td>${pro.getId()}</td>
                            <td>${pro.getSerial()}</td>
                            <td>${pro.getDescrip()}</td>
                            <td>${pro.getPrecio()}</td>
                            <td>${pro.getStock()}</td>
                            <td>${pro.getEstado()}</td>


                            <td>
                                <a class="btn btn-success" href="Controlador?menu=Producto&accion=carga&id=${pro.getId()}">
                                    <i class="fas fa-edit"></i>Editar
                                </a>
                                <a class="btn btn-secondary" href="Controlador?menu=Producto&accion=elimina&id=${pro.getId()}">
                                    <i class="far fa-trash-alt"></i>Borrar
                                </a>
                            </td>

                        </tr>


                    </c:forEach>
                </tbody>
            </table>


        </div>

    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

</body>
</html>
