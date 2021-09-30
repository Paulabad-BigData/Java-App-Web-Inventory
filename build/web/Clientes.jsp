<%-- 
    Document   : Clientes
    Created on : 09-sep-2021, 8:41:14
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
        <title>Clientes</title>

    </head>
    <body>
        <div class="container ml-4 mt-4">
            <form action="Controlador?menu=Cliente" method="POST">
                <div class="form-row">
                    <div class="col-1">
                        <label>DNI</label>
                        <input type="text" value="${cliente.getDni()}" name="txtdni" class="form-control">
                    </div>
                    <div class="col-6">
                        <label>NOMBRES</label>
                        <input type="text" value="${cliente.getNombres()}" name="txtnom" class="form-control">
                    </div>
                    <div class="col-2">
                        <label>DIRECCION</label>
                        <input type="text" value="${cliente.getDirec()}" name="txtdirec" class="form-control">
                    </div>
                    <div class="col-2">
                        <label>TELEFONO</label>
                        <input type="text" value="${cliente.getTel()}" name="txttel" class="form-control">
                    </div>
                    <div class="col-1">
                        <label>ESTADO</label>
                        <input type="text" value="${cliente.getEstado()}" name="txtesta" class="form-control">
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
       
        <br>
        <br>
        <div class="d-flex" style="align-items: center; justify-content: center;">
            <div class="col-sm-12" >

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>NOMBRES</th>
                            <th>DIRECCION</th>
                            <th>TELEFONO</th>
                            <th>ESTADO</th>
                            <th>ACCION</th>

                        </tr>
                    </thead>
                    <tbody>
                        <!--Se define variable em(recibe el parametro empleados del controlador)-->
                        <c:forEach var="cli" items="${clientes}">
                            <tr>
                                <td>${cli.getId()}</td>
                                <td>${cli.getDni()}</td>
                                <td>${cli.getNombres()}</td>
                                <td>${cli.getDirec()}</td>
                                <td>${cli.getTel()}</td>
                                <td>${cli.getEstado()}</td>


                                <td>
                                    <a class="btn btn-success" href="Controlador?menu=Cliente&accion=carga&id=${cli.getId()}">
                                        <i class="fas fa-edit"></i>Editar
                                    </a>
                                    <a class="btn btn-secondary" href="Controlador?menu=Cliente&accion=elimina&id=${cli.getId()}">
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
