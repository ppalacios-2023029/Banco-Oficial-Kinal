/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Prestamos;
import modelo.PrestamosDAO;
import modelo.CargoEmpleadoDAO;
import modelo.Carrito;
import modelo.NuevaTarjeta;
import modelo.NuevaTarjetaDAO;
/**
 *
 * @author neryd
 */

@MultipartConfig
public class Controlador extends HttpServlet {
    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    CargoEmpleadoDAO cargoEmpleadoDAO = new CargoEmpleadoDAO();
    Prestamos prestamos = new Prestamos();
    PrestamosDAO prestamosDAO = new PrestamosDAO();
    NuevaTarjeta nt = new NuevaTarjeta();
    NuevaTarjetaDAO ntDAO = new NuevaTarjetaDAO();
    int codigoCargoEmpleado;
    double salario;
    int codigoEmpleado;
    int codPrestamos;
    String barraBuscar;
    List listaEmp;
    List<NuevaTarjeta> listaNuevaTarjeta = new ArrayList<>();
    List<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalPagar = 0.0;
    int cantidad = 1;
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
        listaNuevaTarjeta = ntDAO.listar();
        if(menu.equals("home")){
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }else if(menu.equals("System")){
            request.getRequestDispatcher("System.jsp").forward(request, response);
        }else if(menu.equals("NuevaTarjeta")){
            switch(accion){
                case "Listar":
                    List <NuevaTarjeta> lista = ntDAO.listar();
                    request.setAttribute("listaNuevaTarjeta", lista);
                    
                break;
                case "AgregarCarrito":
                    int idp=Integer.parseInt(request.getParameter("id"));
                break;
                
                case "Guardar":
                    String titulo = request.getParameter("txtTitulo");
                    Part part = request.getPart("imagen");
                    String descripcion = request.getParameter("txtDescripcion");
                    InputStream inputStream = part.getInputStream();
                    double monto = Double.parseDouble(request.getParameter("txtMonto"));
                    nt.setTitulo(titulo);
                    nt.setImagen(inputStream);
                    nt.setDescripcion(descripcion);
                    nt.setMonto(monto);
                    ntDAO.agregar(nt);
                    request.getRequestDispatcher("Controlador?menu=ProductoTarjeta&accion=Listar").forward(request, response);
                break;
                default:
                    request.setAttribute("nuevaTarjeta", listaNuevaTarjeta);
            }
            request.getRequestDispatcher("NuevaTarjeta.jsp").forward(request, response);
        }else if(menu.equals("BancoTarjetas")){
            switch(accion){
                case "Listar":
                    List <NuevaTarjeta> lista = ntDAO.listar();
                    request.setAttribute("listaNuevaTarjeta", lista);
                    
                break;
                case "AgregarCarrito":
                     int idp=Integer.parseInt(request.getParameter("id"));
                     nt = ntDAO.listarId(idp);
                     item = item+1;
                     Carrito car = new Carrito();
                     car.setItem(item);
                     car.setIdNuevaTargeta(nt.getCodigoNuevaTarjeta());
                     car.setTitulo(nt.getTitulo());
                     car.setDescripcion(nt.getDescripcion());
                     car.setMonto(nt.getMonto());
                     car.setCantidad(cantidad);
                     car.setSubTotal(cantidad*nt.getMonto());
                     listaCarrito.add(car);
                     request.setAttribute("contador", listaCarrito.size());
                     request.getRequestDispatcher("Controlador?accion=BancoTarjetas").forward(request, response);                   
                break;
                case "Carrito":
                break;
                case "Guardar":
                    String titulo = request.getParameter("txtTitulo");
                    Part part = request.getPart("imagen");
                    String descripcion = request.getParameter("txtDescripcion");
                    InputStream inputStream = part.getInputStream();
                    double monto = Double.parseDouble(request.getParameter("txtMonto"));
                    nt.setTitulo(titulo);
                    nt.setImagen(inputStream);
                    nt.setDescripcion(descripcion);
                    nt.setMonto(monto);
                    ntDAO.agregar(nt);
                    request.getRequestDispatcher("Controlador?menu=ProductoTarjeta&accion=Listar").forward(request, response);
                break;
                default:
                    request.setAttribute("nuevaTarjeta", listaNuevaTarjeta);
            }
            request.getRequestDispatcher("BancoTarjetas.jsp").forward(request, response);
        }else if(menu.equals("Empleado")){
            switch(accion){
                case "Listar":
                    List listaEmpleado = empleadoDAO.listar();
                    List listaCargoEmpleado = cargoEmpleadoDAO.listar();
                    request.setAttribute("empleados", listaEmpleado);
                    request.setAttribute("cargoEmpleados", listaCargoEmpleado);
                break;
                case "Agregar":
                    String nombreEmpleado = request.getParameter("txtNombreEmpleado");
                    String apellidoEmpleado = request.getParameter("txtApellidoEmpleado");
                    String usuario = request.getParameter("txtUsuario");
                    String contrasena = request.getParameter("txtContrasena");
                    String cargo = request.getParameter("txtCargo");
                    salario = Double.parseDouble(request.getParameter("txtSalario"));
                    String oficina = request.getParameter("txtOficina");
                    String estado = request.getParameter("txtEstado");
                    codigoCargoEmpleado = Integer.parseInt(request.getParameter("ddlCargoEmpleado"));
                    empleado.setNombreEmpleado(nombreEmpleado);
                    empleado.setApellidoEmpleado(apellidoEmpleado);
                    empleado.setUsuario(usuario);
                    empleado.setContrasena(contrasena);
                    empleado.setCargo(cargo);
                    empleado.setSalario(salario);
                    empleado.setOficina(oficina);
                    empleado.setEstado(estado);
                    empleado.setCodigoCargoEmpleado(codigoCargoEmpleado);
                    empleadoDAO.agregar(empleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    
                break;
                case "Editar":
                    codigoEmpleado = Integer.parseInt(request.getParameter("codigoEmpleado"));
                    Empleado emd = empleadoDAO.listarCodigoEmpleado(codigoEmpleado);
                    request.setAttribute("empleado", emd);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                break;
                case "Actualizar":
                    String nomEmp = request.getParameter("txtNombreEmpleado");
                    String apellEmp = request.getParameter("txtApellidoEmpleado");
                    String user = request.getParameter("txtUsuario");
                    String contra = request.getParameter("txtContrasena");
                    String carg = request.getParameter("txtCargo");
                    salario = Double.parseDouble(request.getParameter("txtSalario"));
                    String oficinaEmp = request.getParameter("txtOficina");
                    String estEmp = request.getParameter("txtEstado");
                    codigoCargoEmpleado = Integer.parseInt(request.getParameter("ddlCargoEmpleado"));
                    empleado.setNombreEmpleado(nomEmp);
                    empleado.setApellidoEmpleado(apellEmp);
                    empleado.setUsuario(user);
                    empleado.setContrasena(contra);
                    empleado.setCargo(carg);
                    empleado.setSalario(salario);
                    empleado.setOficina(oficinaEmp);
                    empleado.setEstado(estEmp);
                    empleado.setCodigoCargoEmpleado(codigoCargoEmpleado);
                    empleado.setCodigoEmpleado(codigoEmpleado);
                    empleadoDAO.actualizar(empleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                break;
                case "Eliminar":
                    codigoEmpleado = Integer.parseInt(request.getParameter("codigoEmpleado"));
                    empleadoDAO.eliminar(codigoEmpleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                break;
     
                case "Buscar":
                    barraBuscar = request.getParameter("txtBuscar");
                    listaEmp = empleadoDAO.barraBusqueda(barraBuscar);
                    request.setAttribute("empleados", listaEmp);
                break;
                case "Cancelar":
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request,response);
        }else if (menu.equals("Prestamo")){
            
            
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
