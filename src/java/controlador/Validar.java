/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EmpleadoDAO;
import modelo.EmpleadoM;

/**
 *
 * @author Usuario
 */
public class Validar extends HttpServlet {

   
        //se instancia la clase que contiene las variables
        EmpleadoM empM = new EmpleadoM();
        //se instancia la clase que contiene los metodos crud y de validación
        EmpleadoDAO empDao = new EmpleadoDAO();
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
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
       
        String acc = request.getParameter("accion");
        if(acc.equals("ingresar")){
            String us = request.getParameter("txtuser");
            String pas = request.getParameter("txtpass");
            
            empM = empDao.valida(us, pas);
            if(empM.getUsua()!=null)
            {   
                //Se envia parametro al formulario(dropdown)con el usuario actual
                request.setAttribute("usuario", empM);
                request.getRequestDispatcher("Controlador?menu=MenuPrincipal").forward(request, response);
            }
            else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
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
