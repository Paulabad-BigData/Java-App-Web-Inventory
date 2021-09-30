<%--
    Document   : Empleados
    Created on : 09-sep-2021, 8:40:48
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
        <title>Empleados</title>
    </head>
    <body>


        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Empleado" method="POST">

                        <div class="form-group">
                            <label>DNI</label>
                            <input type="text" value="${empleado.getDni()}" name="txtdni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>NOMBRES</label>
                            <input type="text"value="${empleado.getNombres()}" name="txtnom" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>TELEFONO</label>
                            <input type="text" value="${empleado.getTel()}" name="txttel" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>ESTADO</label>
                            <input type="text" value="${empleado.getEstado()}" name="txtestado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>USUARIO</label>
                            <input type="text" value="${empleado.getUsua()}" name="txtusua" class="form-control">
                        </div>

                        <button type="submit" name="accion" value="insertar" class="btn btn-secondary">
                            <i class="fas fa-user-plus"></i>Agregar
                        </button>
                        <button type="submit" name="accion" value="modifica" class="btn btn-warning">
                            <i class="fas fa-edit"></i>Actualizar
                        </button>

                    </form>
                </div>
            </div>
            <div class="col-sm-8">

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>NOMBRES</th>
                            <th>TELEFONO</th>
                            <th>ESTADO</th>
                            <th>USUARIO</th>
                            <th>ACCION</th>

                        </tr>
                    </thead>
                    <tbody>
                        <!--Se define variable em(recibe el parametro empleados del controlador)-->
                        <c:forEach var="em" items="${empleados}">
                            <tr>
                                <td>${em.getId()}</td>
                                <td>${em.getDni()}</td>
                                <td>${em.getNombres()}</td>
                                <td>${em.getTel()}</td>
                                <td>${em.getEstado()}</td>
                                <td>${em.getUsua()}</td>


                                <td>
                                    <a class="btn btn-success" href="Controlador?menu=Empleado&accion=carga&id=${em.getId()}">
                                        <i class="fas fa-edit"></i>Editar
                                    </a>
                                    <a class="btn btn-secondary" href="Controlador?menu=Empleado&accion=elimina&id=${em.getId()}">
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
