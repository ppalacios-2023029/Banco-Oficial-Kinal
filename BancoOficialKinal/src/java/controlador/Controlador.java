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
import modelo.CargoEmpleadoDAO;
import modelo.TipoCuenta;
import modelo.TipoCuentaDAO;
import modelo.Clientes;
import modelo.ClienteDAO;
import modelo.DetalleCuenta;
import modelo.DetalleCuentaDAO;
import modelo.Seguro;
import modelo.SeguroDAO;
import modelo.Sucursales;
import modelo.SucursalesDAO;
/**
 *
 * @author neryd
 */
public class Controlador extends HttpServlet {
    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    
    CargoEmpleadoDAO cargoEmpleadoDAO = new CargoEmpleadoDAO();
    
    Seguro seguro = new Seguro();
    SeguroDAO seguroDAO = new SeguroDAO();
    int numSeguro;
    
    Prestamos prestamos = new Prestamos();
    PrestamosDAO prestamosDAO = new PrestamosDAO();
    
    TipoCuenta tipoCuenta = new TipoCuenta();
    TipoCuentaDAO tipoCuentaDAO = new TipoCuentaDAO();
    
    Clientes cliente = new Clientes();
    ClienteDAO clienteDao = new ClienteDAO();
    
    DetalleCuenta detalleCuenta = new DetalleCuenta();
    DetalleCuentaDAO detalleCuentaDAO = new DetalleCuentaDAO();
    int codDetalleCuenta;
    
    Sucursales sucursal = new Sucursales();
    SucursalesDAO sucursalDAO = new SucursalesDAO();
    int codSucursal;
    
    int numeroSeguro;
    int numSeg;
    int codCli;
    int codigoCargoEmpleado;
    double salario;
    int codigoEmpleado;
    int codPrestamos;
    double montoAsegurado;
    double primaMensual;
    String barraBuscar;
    List listaEmp;
    List listaSuc;
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
        }else if(menu.equals("System")){
            request.getRequestDispatcher("System.jsp").forward(request, response);
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
            
            //Cliente
            
        }else if (menu.equals("Cliente")){
            switch (accion) {
                case "Listar":
                    List listaClientes = clienteDao.listar();
                    List listaTipoCuenta = tipoCuentaDAO.listar();
                    request.setAttribute("clientes", listaClientes);
                    request.setAttribute("tipoCuentas", listaTipoCuenta);
                break;

                case "Agregar":
                    
                break;

                case "Editar":
                    codCli = Integer.parseInt(request.getParameter("codigoCliente"));
                    Clientes cl = clienteDao.listaCodigoClientes(codCli);
                    request.setAttribute ("empleado", cl) ;
                    request.getRequestDispatcher ("Controlador?menu=Empleado&accion=Listar") . forward(request, response);
                break;

                case "Actualizar":
                break;

                case "Eliminar":
                break;
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }else if (menu.equals("Producto")){
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }else if (menu.equals("Seguro")){
            switch(accion){
                case "Listar":
                    List listaSeguro = seguroDAO.listar();
                    List listaCliente = clienteDao.listar();
                    request.setAttribute("seguros", listaSeguro);
                    request.setAttribute("clientesLista", listaCliente);
                    break;
                case "Agregar":
                    String numeroPoliza = request.getParameter("txtNumeroPoliza");
                    String tipoSeguro = request.getParameter("txtTipoSeguro");
                    montoAsegurado = Double.parseDouble(request.getParameter("txtMontoAsegurado"));
                    primaMensual = Double.parseDouble(request.getParameter("txtPrimaMensual"));
                    String fechaExpiracion = request.getParameter("txtFechaExpiracion");
                    String estado = request.getParameter("txtEstado");
                    int codigoCliente = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    seguro.setNumeroPoliza(numeroPoliza);
                    seguro.setTipoSeguro(tipoSeguro);
                    seguro.setMontoAsegurado(montoAsegurado);
                    seguro.setPrimaMensual(primaMensual);
                    seguro.setFechaExpiracion(fechaExpiracion);
                    seguro.setEstado(estado);
                    seguro.setCodigoCliente(codigoCliente);
                    seguroDAO.agregar(seguro);
                    request.getRequestDispatcher("Controlador?menu=Seguro&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    numSeguro = Integer.parseInt(request.getParameter("numeroSeguro"));
                    Seguro s = seguroDAO.listarNumeroSeguro(numSeguro);
                    request.setAttribute("seguro", s);
                    request.getRequestDispatcher("Controlador?menu=Seguro&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String numPo = request.getParameter("txtNumeroPoliza");
                    String tipSeg = request.getParameter("txtTipoSeguro");
                    montoAsegurado = Double.parseDouble(request.getParameter("txtMontoAsegurado"));
                    primaMensual = Double.parseDouble(request.getParameter("txtPrimaMensual"));
                    String fechEx = request.getParameter("txtFechaExpiracion");
                    String estad = request.getParameter("txtEstado");
                    seguro.setNumeroPoliza(numPo);
                    seguro.setTipoSeguro(tipSeg);
                    seguro.setMontoAsegurado(montoAsegurado);
                    seguro.setPrimaMensual(primaMensual);
                    seguro.setFechaExpiracion(fechEx);
                    seguro.setEstado(estad);
                    seguro.setNumeroSeguro(numeroSeguro);
                    seguroDAO.actualizar(seguro);
                    request.getRequestDispatcher("Controlador?menu=Seguro&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    numSeguro = Integer.parseInt(request.getParameter("numeroSeguro"));
                    seguroDAO.eliminar(numSeguro);
                    request.getRequestDispatcher("Controlador?menu=Seguro&accion=Listar").forward(request, response);
                    break;
                    
            }
            request.getRequestDispatcher("Seguro.jsp").forward(request, response);
        }else if (menu.equals("Sucursal")){
            switch(accion){
                case "Listar":
                    List listaSucursal = sucursalDAO.listar();
                    List listaEmpleado = empleadoDAO.listar();
                    request.setAttribute("sucursales", listaSucursal);
                    request.setAttribute("empleadoLista", listaEmpleado);
                    break;
                case "Agregar":
                    String nombreSucursal = request.getParameter("txtNombreSucursal");
                    String direccionSucursal = request.getParameter("txtDireccionSucursal");
                    String telefono = request.getParameter("txtTelefono");
                    String correoSucursal = request.getParameter("txtCorreoSucursal");
                    String estado = request.getParameter("txtEstado");
                    int codigoEmpleado = Integer.parseInt(request.getParameter("txtCodigoEmpleado"));
                    sucursal.setNombreSucursal(nombreSucursal);
                    sucursal.setDireccionSucursal(direccionSucursal);
                    sucursal.setTelefono(telefono);
                    sucursal.setCorreoSucursal(correoSucursal);
                    sucursal.setEstado(estado);
                    sucursal.setCodigoEmpleado(codigoEmpleado);
                    sucursalDAO.agregar(sucursal);
                    request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codSucursal = Integer.parseInt(request.getParameter("codigoSucursal"));
                    Sucursales ss = sucursalDAO.listarCodigoSucursales(codSucursal);
                    request.setAttribute("sucursal", ss);
                    request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nomSucursal = request.getParameter("txtNombreSucursal");
                    String direSucursal = request.getParameter("txtDireccionSucursal");
                    String tele = request.getParameter("txtTelefono");
                    String corSucursal = request.getParameter("txtCorreoSucursal");
                    String estad = request.getParameter("txtEstado");
                    codigoEmpleado = Integer.parseInt(request.getParameter("txtCodigoEmpleado"));
                    sucursal.setNombreSucursal(nomSucursal);
                    sucursal.setDireccionSucursal(direSucursal);
                    sucursal.setTelefono(tele);
                    sucursal.setCorreoSucursal(corSucursal);
                    sucursal.setEstado(estad);
                    sucursal.setCodigoEmpleado(codigoEmpleado);
                    sucursal.setCodigoSucursal(codSucursal);
                    sucursalDAO.actualizar(sucursal);
                    request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codSucursal = Integer.parseInt(request.getParameter("codigoSucursal"));
                    sucursalDAO.eliminar(codSucursal);
                    request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
                    break;
                case "Buscar":
                    barraBuscar = request.getParameter("txtBuscar");
                    listaSuc = sucursalDAO.barraBusqueda(barraBuscar);
                    request.setAttribute("sucursal", listaSuc);
                break;
                case "Cancelar":
                    request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
                break;
                    
            }
            request.getRequestDispatcher("Sucursal.jsp").forward(request, response);
        }else if (menu.equals("DetalleCuenta")){
            switch(accion){
                case "Listar":
                    List listaDetalleCuenta = detalleCuentaDAO.listar();
                    List listaCliente = clienteDao.listar();
                    List listaEmpleado = empleadoDAO.listar();
                    List listaSucursales = sucursalDAO.listar();
                    request.setAttribute("detalleCuentas", listaDetalleCuenta);
                    request.setAttribute("clienteLista", listaCliente);
                    request.setAttribute("empleadoLista", listaEmpleado);
                    request.setAttribute("sucursalLista", listaSucursales);
                    break;
                case "Agregar":
                    String fechaDetalle = request.getParameter("txtFechaDetalle");
                    String tipoOperacion = request.getParameter("txtTipoOperacion");
                    String estado = request.getParameter("txtEstado");
                    int codigoCliente = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    int codigoEmpleado = Integer.parseInt(request.getParameter("txtCodigoEmpleado"));
                    int codigoSucursal = Integer.parseInt(request.getParameter("txtCodigoSucursal"));
                    detalleCuenta.setFechaDetalle(fechaDetalle);
                    detalleCuenta.setTipoOperacion(tipoOperacion);
                    detalleCuenta.setEstadoCuenta(estado);
                    detalleCuenta.setCodigoCliente(codigoCliente);
                    detalleCuenta.setCodigoEmpleado(codigoEmpleado);
                    detalleCuenta.setCodigoSucursal(codigoSucursal);
                    detalleCuenta.setCodigoDetalleCuenta(codDetalleCuenta);
                    detalleCuentaDAO.agregar(detalleCuenta);
                    request.getRequestDispatcher("Controlador?menu=DetalleCuenta&accion=Listar").forward(request, response);
                    break;
                    case "Editar":
                    codDetalleCuenta = Integer.parseInt(request.getParameter("codigoDetalleCuenta"));
                    DetalleCuenta dc = detalleCuentaDAO.listarCodigoDetalleCuenta(codDetalleCuenta);
                    request.setAttribute("detalleCuenta", dc);
                    request.getRequestDispatcher("Controlador?menu=DetalleCuenta&accion=Listar").forward(request, response);
                    break;
                    case "Actualizar":
                    String fecDetalle = request.getParameter("txtFechaDetalle");
                    String tipOpe = request.getParameter("txtTipoOperacion");
                    String estad = request.getParameter("txtEstado");
                    codigoCliente = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    codigoEmpleado = Integer.parseInt(request.getParameter("txtCodigoEmpleado"));
                    codigoSucursal = Integer.parseInt(request.getParameter("txtCodigoSucursal"));
                    detalleCuenta.setFechaDetalle(fecDetalle);
                    detalleCuenta.setTipoOperacion(tipOpe);
                    detalleCuenta.setEstadoCuenta(estad);
                    detalleCuenta.setCodigoCliente(codigoCliente);
                    detalleCuenta.setCodigoEmpleado(codigoEmpleado);
                    detalleCuenta.setCodigoSucursal(codigoSucursal);
                    detalleCuenta.setCodigoDetalleCuenta(codDetalleCuenta);
                    detalleCuentaDAO.actualizar(detalleCuenta);
                    request.getRequestDispatcher("Controlador?menu=DetalleCuenta&accion=Listar").forward(request, response);
                    break;
                    case "Eliminar":
                    codDetalleCuenta = Integer.parseInt(request.getParameter("codigoDetalleCuenta"));
                    detalleCuentaDAO.eliminar(codDetalleCuenta);
                    request.getRequestDispatcher("Controlador?menu=DetalleCuenta&accion=Listar").forward(request, response);
                    break;
                    case "Buscar":
                    barraBuscar = request.getParameter("txtBuscar");
                    listaSuc = sucursalDAO.barraBusqueda(barraBuscar);
                    request.setAttribute("sucursal", listaSuc);
                    break;
                    case "Cancelar":
                        request.getRequestDispatcher("Controlador?menu=DetalleCuenta"
                                + ""
                                + ""
                                + "&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("DetalleCuenta.jsp").forward(request, response);
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
