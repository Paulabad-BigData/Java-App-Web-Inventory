
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ClienteDAO;
import modelo.ClienteM;
import modelo.EmpleadoDAO;
import modelo.EmpleadoM;
import modelo.Movimiento;
import modelo.ProductoDAO;
import modelo.ProductoM;

/**
 *
 * @author PERSONAL
 */
public class Controlador extends HttpServlet {

    EmpleadoDAO empDao = new EmpleadoDAO();
    EmpleadoM emp = new EmpleadoM();

    ClienteDAO cliDao = new ClienteDAO();
    ClienteM cli = new ClienteM();

    ProductoDAO proDao = new ProductoDAO();
    ProductoM pro = new ProductoM();

    Movimiento mov = new Movimiento();

    List<Movimiento> listaM = new ArrayList<>();

    int item, cod, cant;
    String descrip;
    double precio;
    double subt;

    int idEmp;
    int idCli;
    int idPro;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String opc = request.getParameter("accion");
        if (menu.equals("MenuPrincipal")) {
            request.getRequestDispatcher("Ppal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (opc) {
                case "mostrar":
                    List lista = empDao.mostrar();
                    request.setAttribute("empleados", lista);
                    break;
                case "insertar":
                    // se definen los valores que reciben los datos de los campos
                    String dni = request.getParameter("txtdni");
                    String nom = request.getParameter("txtnom");
                    String tel = request.getParameter("txttel");
                    String esta = request.getParameter("txtestado");
                    String usr = request.getParameter("txtusua");

                    // agregar los valores a emp
                    emp.setDni(dni);
                    emp.setNombres(nom);
                    emp.setTel(tel);
                    emp.setEstado(esta);
                    emp.setUsua(usr);

                    //llamer el metodo insertar de empleado
                    empDao.insertar(emp);

                    //recargar la pagina
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=mostrar").forward(request, response);

                    break;
                case "carga":
                    idEmp = Integer.parseInt(request.getParameter("id"));
                    EmpleadoM em = empDao.cargar(idEmp);

                    request.setAttribute("empleado", em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=mostrar").forward(request, response);
                    break;

                case "modifica":
                    // se definen los valores que reciben los datos de los campos
                    String dni_ = request.getParameter("txtdni");
                    String nom_ = request.getParameter("txtnom");
                    String tel_ = request.getParameter("txttel");
                    String esta_ = request.getParameter("txtestado");
                    String usr_ = request.getParameter("txtusua");

                    // agregar los valores a emp
                    emp.setDni(dni_);
                    emp.setNombres(nom_);
                    emp.setTel(tel_);
                    emp.setEstado(esta_);
                    emp.setUsua(usr_);

                    //llamer el metodo insertar de empleado
                    emp.setId(idEmp);
                    empDao.modificar(emp);

                    //recargar la pagina
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=mostrar").forward(request, response);

                    break;
                case "elimina":

                    idEmp = Integer.parseInt(request.getParameter("id"));

                    empDao.eliminar(idEmp);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=mostrar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleados.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            switch (opc) {
                case "mostrar":
                    List lista = cliDao.mostrar();
                    request.setAttribute("clientes", lista);
                    break;
                case "insertar":

                    String dni = request.getParameter("txtdni");
                    String nom = request.getParameter("txtnom");
                    String direc = request.getParameter("txtdirec");
                    String tel = request.getParameter("txttel");
                    String est = request.getParameter("txtesta");

                    cli.setDni(dni);
                    cli.setNombres(nom);
                    cli.setDirec(direc);
                    cli.setTel(tel);
                    cli.setEstado(est);

                    cliDao.insertar(cli);

                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=mostrar").forward(request, response);

                    break;

                case "carga":
                    idCli = Integer.parseInt(request.getParameter("id"));
                    ClienteM cl = cliDao.cargar(idCli);

                    request.setAttribute("cliente", cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=mostrar").forward(request, response);
                    break;

                case "modifica":

                    String dni_ = request.getParameter("txtdni");
                    String nom_ = request.getParameter("txtnom");
                    String direc_ = request.getParameter("txtdirec");
                    String tel_ = request.getParameter("txttel");
                    String est_ = request.getParameter("txtesta");

                    // agregar los valores a emp
                    cli.setDni(dni_);
                    cli.setNombres(nom_);
                    cli.setDirec(direc_);
                    cli.setTel(tel_);
                    cli.setEstado(est_);
                    //llamer el metodo insertar de empleado
                    cli.setId(idCli);
                    cliDao.modificar(cli);

                    //recargar la pagina
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=mostrar").forward(request, response);

                    break;

                case "elimina":

                    idCli = Integer.parseInt(request.getParameter("id"));

                    cliDao.eliminar(idCli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=mostrar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            switch (opc) {
                case "mostrar":
                    List lista = proDao.mostrar();
                    request.setAttribute("productos", lista);
                    break;
                case "insertar":
                    // se definen los valores que reciben los datos de los campos
                    String serial = request.getParameter("txtser");
                    String descrip = request.getParameter("txtdescrp");
                    String precio = request.getParameter("txtpre");
                    String stock = request.getParameter("txtstock");
                    String estado = request.getParameter("txtest");

                    double pre = Double.parseDouble(precio);
                    int stc = Integer.parseInt(stock);

                    // agregar los valores a emp
                    pro.setSerial(serial);
                    pro.setDescrip(descrip);
                    pro.setPrecio(pre);
                    pro.setStock(stc);
                    pro.setEstado(estado);

                    //llamer el metodo insertar de empleado
                    proDao.insertar(pro);

                    //recargar la pagina
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=mostrar").forward(request, response);

                    break;

                case "carga":

                    idPro = Integer.parseInt(request.getParameter("id"));
                    ProductoM pr = proDao.cargar(idPro);

                    request.setAttribute("producto", pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=mostrar").forward(request, response);
                    break;

                case "modifica":

                    String serial_ = request.getParameter("txtser");
                    String descrip_ = request.getParameter("txtdescrp");
                    String precio_ = request.getParameter("txtpre");
                    String stock_ = request.getParameter("txtstock");
                    String estado_ = request.getParameter("txtest");

                    double pre_ = Double.parseDouble(precio_);
                    int stc_ = Integer.parseInt(stock_);

                    // agregar los valores a emp
                    pro.setSerial(serial_);
                    pro.setDescrip(descrip_);
                    pro.setPrecio(pre_);
                    pro.setStock(stc_);
                    pro.setEstado(estado_);
                    //llamer el metodo insertar de empleado
                    pro.setId(idPro);
                    proDao.modificar(pro);

                    //recargar la pagina
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=mostrar").forward(request, response);

                    break;

                case "elimina":
                    idPro = Integer.parseInt(request.getParameter("id"));

                    proDao.eliminar(idPro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=mostrar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Productos.jsp").forward(request, response);
        }
        if (menu.equals("Movimiento")) {

            switch (opc) {
                case "buscaC":
                    //Se trae el parametro del campo codigo, Movimiento.jsp
                    String dni = request.getParameter("codCliente");
                    cli.setDni(dni);
                    cli = cliDao.buscar(dni);
                    // Se asigna los valores del objeto cli, a la variable cliente
                    request.setAttribute("cliente", cli);
                    break;
                case "buscaP":
                    //Se trae el parametro del campo codigo, Movimiento.jsp
                    String serial = request.getParameter("codProducto");
                    pro.setSerial(serial);
                    pro = proDao.buscar(serial);
                    // Se asigna los valores del objeto cli, a la variable cliente
                    request.setAttribute("producto", pro);

                    request.setAttribute("listaM", listaM);
                    break;

                case "cargar":
                    item = item + 1;
                    cod = pro.getId();
                    descrip = request.getParameter("nombreProducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cantidad"));
                    subt = precio * cant;
                    // Se inicializa  el objeto mov
                    mov = new Movimiento();
                    mov.setItem(item);
                    mov.setIdM(cod);
                    mov.setDescr(descrip);
                    mov.setPrecio(precio);
                    mov.setCant(cant);
                    mov.setSubt(subt);

                    listaM.add(mov);
                    request.setAttribute("listM", listaM);
                    
                

                default:
                    request.getRequestDispatcher("Movimientos.jsp").forward(request, response);

            }
            request.getRequestDispatcher("Movimientos.jsp").forward(request, response);
        }

        /*
            switch(opc)
            {
                case "MenuPrincipal": 
                    request.getRequestDispatcher("Ppal.jsp").forward(request, response);
                    break;
                    
                case "Empleado": 
                    request.getRequestDispatcher("Empleados.jsp").forward(request, response);
                    break;
                    
                case "Cliente": 
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                    break;
                    
                case "Producto": 
                    request.getRequestDispatcher("Productos.jsp").forward(request, response);
                    break;
                    
                    
                case "Movimiento": 
                    request.getRequestDispatcher("Movimientos.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            
        }
         */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
