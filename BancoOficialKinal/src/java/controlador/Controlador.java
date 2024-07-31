/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Prestamos;
import modelo.PrestamosDAO;

/**
 *
 * @author neryd
 */
public class Controlador extends HttpServlet {
    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    
    Prestamos prestamos = new Prestamos();
    PrestamosDAO prestamosDAO = new PrestamosDAO();
    
    int codPrestamos;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        if(menu.equals("home")){
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }else if (menu.equals("Prestamo")){
            
            switch(accion){
                case "Listar":
                    List listaPrestamo = prestamosDAO.listar();
                    request.setAttribute("Prestamos", listaPrestamo);
                    break;
                case "Agregar":
                    String monto = request.getParameter("txtMonto");
                    String tPrestamo = request.getParameter("txtTipoPrestamo");
                    String tasaInteres = request.getParameter("txtTasaInteres");
                    String fechaInicio = request.getParameter("txtFechaInicio");
                    String fechaVencimiento = request.getParameter("txtFechaVencimiento");
                    String estado = request.getParameter("txtEstado");
                    prestamos.setMonto(Double.parseDouble(monto));
                    prestamos.setTipoPrestamo(tPrestamo);
                    prestamos.setTasaInteres(Double.parseDouble(tasaInteres));
                    //prestamos.setFechaInicio(new java.sql.Date(fechaInicio));
                    //prestamos.setFechaVencimiento(fechaVencimiento);
                    prestamos.setEstado(estado);
                    prestamosDAO.agregar(prestamos);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codPrestamos = Integer.parseInt(request.getParameter("codigoPretamo"));
                    Prestamos e = prestamosDAO.listarPrestamos(codPrestamos);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String mont = request.getParameter("txtMonto");
                    String tPrest = request.getParameter("txtTipoPrestamo");
                    String tInteres = request.getParameter("txtTasaInteres");
                    String fechaIni = request.getParameter("txtFechaInicio");
                    String fechaVen = request.getParameter("txtFechaVencimiento");
                    String estad = request.getParameter("txtEstado");
                    prestamos.setMonto(Double.parseDouble(mont));
                    prestamos.setTipoPrestamo(tPrest);
                    prestamos.setTasaInteres(Double.parseDouble(tInteres));
                    //prestamos.setFechaInicio(new java.sql.Date(fechaIni));
                    //prestamos.setFechaVencimiento(fechaVen);
                    prestamos.setEstado(estad);
                    prestamosDAO.agregar(prestamos);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codPrestamos = Integer.parseInt(request.getParameter("codigoPrestamo"));
                    prestamosDAO.eliminar(codPrestamos);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
            }
            
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }else if (menu.equals("Cliente")){
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }else if (menu.equals("Producto")){
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }else if (menu.equals("NuevaVenta")){
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
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
