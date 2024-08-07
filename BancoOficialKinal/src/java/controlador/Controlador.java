/*
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
import modelo.CargoEmpleado;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Prestamo;
import modelo.PrestamoDAO;
import modelo.CargoEmpleadoDAO;
import modelo.Carrito;
import modelo.NuevaTarjeta;
import modelo.NuevaTarjetaDAO;

import modelo.TipoCuenta;
import modelo.TipoCuentaDAO;
import modelo.Clientes;
import modelo.ClienteDAO;
import modelo.TipoCuenta;
import modelo.TipoCuentaDAO;
import modelo.TipoCuenta;
import modelo.TipoCuentaDAO;
import modelo.Clientes;
import modelo.ClienteDAO;
import modelo.Seguro;
import modelo.SeguroDAO;
import modelo.Sucursales;
import modelo.SucursalesDAO;
import modelo.Transaccion;
import modelo.TransaccionDAO;
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
@MultipartConfig
public class Controlador extends HttpServlet {

    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    CargoEmpleado cargoempleado = new CargoEmpleado();
    
    
    CargoEmpleadoDAO cargoEmpleadoDAO = new CargoEmpleadoDAO();
    Prestamo prestamos = new Prestamo();
    PrestamoDAO prestamosDAO = new PrestamoDAO();
    NuevaTarjeta nt = new NuevaTarjeta();
    NuevaTarjetaDAO ntDAO = new NuevaTarjetaDAO();
    
    Seguro seguro = new Seguro();
    SeguroDAO seguroDAO = new SeguroDAO();
    int numSeguro;
    
    Prestamos prestamos = new Prestamos();
    PrestamosDAO prestamosDAO = new PrestamosDAO();
    
    TipoCuenta tipoCuenta = new TipoCuenta();
    TipoCuentaDAO tipoCuentaDAO = new TipoCuentaDAO();
    
    Clientes cliente = new Clientes();
    ClienteDAO clienteDao = new ClienteDAO();
    
    int codCli;
    // -- Cambios de Tipo Cuenta --
    double saldoMin;
    double interes;
    double impuestos;
    int codigoTipoCuenta;
    List listaTipoC;
    // ----------------------------
    
    Seguro seguro = new Seguro();
    SeguroDAO seguroDAO = new SeguroDAO();
    int numSeguro;
    
    Prestamos prestamos = new Prestamos();
    PrestamosDAO prestamosDAO = new PrestamosDAO();
    
    TipoCuenta tipoCuenta = new TipoCuenta();
    TipoCuentaDAO tipoCuentaDAO = new TipoCuentaDAO();
    
    Clientes cliente = new Clientes();
    ClienteDAO clienteDao = new ClienteDAO();
    
    Sucursales sucursal = new Sucursales();
    SucursalesDAO sucursalDAO = new SucursalesDAO();
    int codSucursal;
    
    int numeroSeguro;
    int numSeg;
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
    double montoAsegurado;
    double primaMensual;
    String barraBuscar;
    List listaEmp;
    List<NuevaTarjeta> listaNuevaTarjeta = new ArrayList<>();
    List<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalPagar = 0.0;
    int cantidad = 1;
    int idp;
    Carrito car;

    List listaPres;
    
    List listCargoEmpleado;
    List listaSuc;
    
    Transaccion transaccion = new Transaccion();
    TransaccionDAO transaccionDAO = new TransaccionDAO();


    int codigoCliente;
    int codigoTransaccion;
    double monto;
    List listaTra;    
    
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
        listaNuevaTarjeta = ntDAO.listar();
        if (menu.equals("home")) {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else if (menu.equals("System")) {
            request.getRequestDispatcher("System.jsp").forward(request, response);
        } else if (menu.equals("NuevaTarjeta")) {
            switch (accion) {
                case "Listar":
                    List<NuevaTarjeta> lista = ntDAO.listar();
                    request.setAttribute("listaNuevaTarjeta", lista);

                    break;
                case "AgregarCarrito":
                    int idp = Integer.parseInt(request.getParameter("id"));
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
        } else if (menu.equals("BancoTarjetas")) {
            switch (accion) {
                case "Listar":
                    List<NuevaTarjeta> lista = ntDAO.listar();
                    request.setAttribute("listaNuevaTarjeta", lista);

                    break;
                case "Comprar":
                    totalPagar = 0.0;
                    idp = Integer.parseInt(request.getParameter("id"));
                    nt = ntDAO.listarId(idp);
                    item = item + 1;
                    car = new Carrito();
                    car.setItem(item);
                    car.setIdNuevaTargeta(nt.getCodigoNuevaTarjeta());
                    car.setTitulo(nt.getTitulo());
                    car.setDescripcion(nt.getDescripcion());
                    car.setMonto(nt.getMonto());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad * nt.getMonto());
                    listaCarrito.add(car);
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("carrito", listaCarrito);
                    request.setAttribute("contador", listaCarrito.size());
                    request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                    break;

                case "AgregarCarrito":
                    int pos = -1; // Usamos -1 como valor por defecto para indicar que el item no está en la lista
                    cantidad = 1;
                    idp = Integer.parseInt(request.getParameter("id"));
                    nt = ntDAO.listarId(idp);

// Verificar si el producto ya está en el carrito
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if (idp == listaCarrito.get(i).getIdNuevaTargeta()) {
                            pos = i;
                            break;
                        }
                    }

                    if (pos != -1) {
                        // Si el producto ya está en el carrito, actualizamos la cantidad y el subtotal
                        cantidad = listaCarrito.get(pos).getCantidad() + 1; // Incrementa la cantidad por 1
                        double subtotal = listaCarrito.get(pos).getMonto() * cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubTotal(subtotal);
                    } else {
                        // Si el producto no está en el carrito, lo agregamos
                        item = item + 1;
                        car = new Carrito();
                        car.setItem(item);
                        car.setIdNuevaTargeta(nt.getCodigoNuevaTarjeta());
                        car.setTitulo(nt.getTitulo());
                        car.setDescripcion(nt.getDescripcion());
                        car.setMonto(nt.getMonto());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad * nt.getMonto());
                        listaCarrito.add(car);
                    }

                    request.setAttribute("contador", listaCarrito.size());
                    request.getRequestDispatcher("Controlador?accion=BancoTarjetas").forward(request, response);
                    break;
                case "Delete":
                    int idproducto = Integer.parseInt(request.getParameter("idp"));
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if (listaCarrito.get(i).getItem() == idproducto) {
                            listaCarrito.remove(i);
                        }
                    }

                    request.getRequestDispatcher("Controlador?menu=BancoTarjetas&accion=Carrito").forward(request, response);
                    break;
                case "Carrito":
                    totalPagar = 0.0;
                    request.setAttribute("carrito", listaCarrito);
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.getRequestDispatcher("Carrito.jsp").forward(request, response);
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
                    request.getRequestDispatcher("BancoTarjetas.jsp").forward(request, response);
            }

        } else if (menu.equals("Empleado")) {
            switch (accion) {
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
                    request.setAttribute("CargoEmpleado", listaEmp);
                break;
                case "Cancelar":
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        

        } else if (menu.equals("Cliente")) {
            request.getRequestDispatcher("Empleado.jsp").forward(request,response);
            
        //PRESTAMO
        }else if (menu.equals("Prestamo")){
            
            switch(accion){
                case "Listar":
                    List listaPrestamo = prestamosDAO.listar();
                    List listaClientes = clietneDao.listar();
                    request.setAttribute("prestamos", listaPrestamo);
                    request.setAttribute("clientes", listaClientes);
                break;
                case "Agregar":
                    String monto = request.getParameter("txtMonto");
                    String tPrestamo = request.getParameter("txtTipoPrestamo");
                    String tasaInteres = request.getParameter("txtTasaInteres");
                    String fechaInicio = request.getParameter("txtFechaInicio");
                    String fechaVencimiento = request.getParameter("txtFechaVencimiento");
                    String estado = request.getParameter("txtEstado");
                    codCli = Integer.parseInt(request.getParameter("ddlCliente"));
                    prestamos.setMonto(Double.parseDouble(monto));
                    prestamos.setTipoPrestamo(tPrestamo);
                    prestamos.setTasaInteres(Double.parseDouble(tasaInteres));
                    prestamos.setFechaInicio(fechaInicio);
                    prestamos.setFechaVencimiento(fechaVencimiento);
                    prestamos.setEstado(estado);
                    prestamos.setCodigoCliente(codCli);
                    prestamosDAO.agregar(prestamos);
                    request.getRequestDispatcher("Controlador?menu=Prestamo&accion=Listar").forward(request, response);
                break;
                
                case "Editar":
                    codPrestamos = Integer.parseInt(request.getParameter("codigoPrestamo"));
                    Prestamo e = prestamosDAO.listarPrestamos(codPrestamos);
                    request.setAttribute("prestamo", e);
                    request.getRequestDispatcher("Controlador?menu=Prestamo&accion=Listar").forward(request, response);
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
                    prestamos.setFechaInicio(fechaIni);
                    prestamos.setFechaVencimiento(fechaVen);
                    prestamos.setEstado(estad);
                    prestamos.setCodigoPrestamo(codPrestamos);
                    prestamosDAO.actualizar(prestamos);
                    request.getRequestDispatcher("Controlador?menu=Prestamo&accion=Listar").forward(request, response);
                break;
                
                case "Eliminar":
                    codPrestamos = Integer.parseInt(request.getParameter("codigoPrestamo"));
                    prestamosDAO.eliminar(codPrestamos);
                    request.getRequestDispatcher("Controlador?menu=Prestamo&accion=Listar").forward(request, response);
                break;
                
                case "Cancelar":
                    request.getRequestDispatcher("Controlador?menu=Prestamo&accion=Listar").forward(request, response);
                break;
                
                case "Buscar":
                    barraBuscar = request.getParameter("txtBuscar");
                    listaPres = prestamosDAO.barraBusqueda(barraBuscar);
                    request.setAttribute("Prestamo", listaPres);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                
            }
            
            request.getRequestDispatcher("Prestamo.jsp").forward(request, response);
            
            //Cliente
            
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
        } else if (menu.equals("Producto")) {
            request.getRequestDispatcher("Prestamo.jsp").forward(request, response);
        }else if (menu.equals("CargoEmpleado")){
            switch(accion){
                case "Listar":
                    List listaCargoEmpleado = cargoEmpleadoDAO.listar();
                    request.setAttribute("CargoEmpleado", listaCargoEmpleado);
                    break;
                case "Agregar":
                    String nombreCargo = request.getParameter("txtNombreCargo");
                    String descripcion = request.getParameter("txtDescripcion");
                    String salarioBase = request.getParameter("txtSalarioBase");
                    String nivelJerarquico = request.getParameter("txtNivelJerarquico");
                    String estado = request.getParameter("txtEstado");
                    cargoempleado.setNombreCargo(nombreCargo);
                    cargoempleado.setDescripcion(descripcion);
                    cargoempleado.setSalarioBase(Double.parseDouble(salarioBase));
                    cargoempleado.setNivelJerarquico(Integer.parseInt(nivelJerarquico));
                    cargoempleado.setEstado(estado);
                    cargoEmpleadoDAO.agregar(cargoempleado);
                    request.getRequestDispatcher("Controlador?menu=CargoEmpleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codigoCargoEmpleado = Integer.parseInt(request.getParameter("codigoCargoEmpleado"));
                    CargoEmpleado em = cargoEmpleadoDAO.listarCodigoCargoEmpleado(codigoCargoEmpleado);
                    request.setAttribute("Cargoempleado", em);
                    request.getRequestDispatcher("Controlador?menu=CargoEmpleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombCargo = request.getParameter("txtNombreCargo");
                    String descrip = request.getParameter("txtDescripcion");
                    String salBase = request.getParameter("txtSalarioBase");
                    String nivJerarquico = request.getParameter("txtNivelJerarquico");
                    String est = request.getParameter("txtEstado");
                    cargoempleado.setNombreCargo(nombCargo);
                    cargoempleado.setDescripcion(descrip);
                    cargoempleado.setSalarioBase(Double.parseDouble(salBase));
                    cargoempleado.setNivelJerarquico(Integer.parseInt(nivJerarquico));
                    cargoempleado.setEstado(est);
                    cargoempleado.setCodigoCargoEmpleado(codigoCargoEmpleado);
                    cargoEmpleadoDAO.actualizar(cargoempleado);
                    request.getRequestDispatcher("Controlador?menu=CargoEmpleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codigoCargoEmpleado = Integer.parseInt(request.getParameter("codigoCargoEmpleado"));
                    cargoEmpleadoDAO.eliminar(codigoCargoEmpleado);
                    request.getRequestDispatcher("Controlador?menu=CargoEmpleado&accion=Listar").forward(request, response);
                    break;
                case "Buscar":
                    barraBuscar = request.getParameter("txtBuscar");
                    listCargoEmpleado = cargoEmpleadoDAO.barraBusqueda(barraBuscar);
                    request.setAttribute("CargoEmpleado", listCargoEmpleado);
                break;

                case "Cancelar":
                    request.getRequestDispatcher("Controlador?menu=CargoEmpleado&accion=Listar").forward(request, response);
                break;
            }
            request.getRequestDispatcher("CargoEmpleado.jsp").forward(request, response);
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        // ------------------------- Cambios de Tipo cuenta -------------------------
        }else if (menu.equals("TipoCuenta")){
            switch(accion){
                case "Listar":
                    List listaTipoCuenta = tipoCuentaDAO.listar();
                    request.setAttribute("tipoCuentas", listaTipoCuenta);
                break;
                case "Agregar":
                    String tipoC = request.getParameter("txtTipoCuenta");
                    saldoMin = Double.parseDouble(request.getParameter("txtSaldoMinimoRequerido"));
                    interes = Double.parseDouble(request.getParameter("txtTazaDeInteres"));
                    impuestos = Double.parseDouble(request.getParameter("txtTazaDeImpuestos"));
                    String estado = (request.getParameter("txtEstado"));
                    tipoCuenta.setTipoCuenta(tipoC);
                    tipoCuenta.setSaldoMinimoRequerido(saldoMin);
                    tipoCuenta.setTazaDeInteres(interes);
                    tipoCuenta.setTazaDeImpuestos(impuestos);
                    tipoCuenta.setEstado(estado);
                    tipoCuentaDAO.agregar(tipoCuenta);
                    request.getRequestDispatcher("Controlador?menu=TipoCuenta&accion=Listar").forward(request, response);
                break;
                case "Editar":
                    codigoTipoCuenta = Integer.parseInt(request.getParameter("codigoTipoCuenta"));
                    TipoCuenta tpc = tipoCuentaDAO.listarCodigoTipoCuenta(codigoTipoCuenta);
                    request.setAttribute("tipoCuenta", tpc);
                    request.getRequestDispatcher("Controlador?menu=TipoCuenta&accion=Listar").forward(request, response);
                break;
                case "Actualizar":
                    String tc = request.getParameter("txtTipoCuenta");
                    saldoMin = Double.parseDouble(request.getParameter("txtSaldoMinimoRequerido"));
                    interes = Double.parseDouble(request.getParameter("txtTazaDeInteres"));
                    impuestos = Double.parseDouble(request.getParameter("txtTazaDeImpuestos"));
                    String est = (request.getParameter("txtEstado"));
                    tipoCuenta.setTipoCuenta(tc);
                    tipoCuenta.setSaldoMinimoRequerido(saldoMin);
                    tipoCuenta.setTazaDeInteres(interes);
                    tipoCuenta.setTazaDeImpuestos(impuestos);
                    tipoCuenta.setEstado(est);
                    tipoCuenta.setCodigoTipoCuenta(codigoTipoCuenta);
                    tipoCuentaDAO.actualizar(tipoCuenta);
                    request.getRequestDispatcher("Controlador?menu=TipoCuenta&accion=Listar").forward(request, response);
                break;
                case "Eliminar":
                    codigoTipoCuenta = Integer.parseInt(request.getParameter("codigoTipoCuenta"));
                    tipoCuentaDAO.eliminar(codigoTipoCuenta);
                    request.getRequestDispatcher("Controlador?menu=TipoCuenta&accion=Listar").forward(request, response);
                break;
     
                case "Buscar":
                    barraBuscar = request.getParameter("txtBuscar");
                    listaTipoC = tipoCuentaDAO.barraBusqueda(barraBuscar);
                    request.setAttribute("tipoCuentas", listaTipoC);
                break;
                case "Cancelar":
                    request.getRequestDispatcher("Controlador?menu=TipoCuenta&accion=Listar").forward(request, response);
                break;
            }
            request.getRequestDispatcher("TipoCuenta.jsp").forward(request, response);
        // ---------------------------------------------------------------------------
        }else if (menu.equals("Producto")){
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        } else if (menu.equals("NuevaVenta")) {
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
        }else if (menu.equals("Transaccion")){
            switch(accion){
                case "Listar":
                    List listaTransaccion = transaccionDAO.listar();
                    List listaCliente = clienteDao.listar();
                    request.setAttribute("transacciones", listaTransaccion);
                    request.setAttribute("clienteLista", listaCliente);                        
                    break;
                case "Agregar":
                    try{
                    String estadoTransaccion = request.getParameter("txtEstadoTransaccion");
                    String tipoTransaccion = request.getParameter("txtTipoTransaccion");
                    monto = Double.parseDouble(request.getParameter("txtMonto"));                    
                    String fecha = request.getParameter("txtFecha");
                    String estado = request.getParameter("txtEstado");
                    codigoCliente = Integer.parseInt(request.getParameter("ddlCliente"));  
                    transaccion.setEstadoTransaccion(estadoTransaccion);
                    transaccion.setTipoTransaccion(tipoTransaccion);
                    transaccion.setMonto(monto);
                    transaccion.setFecha(fecha);
                    transaccion.setEstado(estado);
                    transaccion.setCodigoCliente(codigoCliente);
                    transaccionDAO.agregar(transaccion);
                    request.getRequestDispatcher("Controlador?menu=Transaccion&accion=Listar").forward(request, response);                    
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break; 
                case "Editar":
                    codigoTransaccion = Integer.parseInt(request.getParameter("codigoTransaccion"));
                    Transaccion transa = transaccionDAO.listarCodigoTransaccion(codigoTransaccion);
                    request.setAttribute("transaccion", transa);
                    request.getRequestDispatcher("Controlador?menu=Transaccion&accion=Listar").forward(request, response);
                    break;             
                case "Actualizar":
                    try{
                    String estadoTra = request.getParameter("txtEstadoTransaccion");
                    String tipoTra = request.getParameter("txtTipoTransaccion");
                    monto = Double.parseDouble(request.getParameter("txtMonto"));                    
                    String fech = request.getParameter("txtFecha");
                    String est = request.getParameter("txtEstado");
                    codigoCliente = Integer.parseInt(request.getParameter("ddlCliente"));  
                    transaccion.setEstadoTransaccion(estadoTra);
                    transaccion.setTipoTransaccion(tipoTra);
                    transaccion.setMonto(monto);
                    transaccion.setFecha(fech);
                    transaccion.setEstado(est);
                    transaccion.setCodigoCliente(codigoCliente);   
                    transaccion.setCodigoTransaccion(codigoTransaccion);
                    transaccionDAO.actualizar(transaccion);                    
                    request.getRequestDispatcher("Controlador?menu=Transaccion&accion=Listar").forward(request, response);                    
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                case "Eliminar":
                    codigoTransaccion = Integer.parseInt(request.getParameter("codigoTransaccion"));
                    transaccionDAO.eliminar(codigoTransaccion);
                    request.getRequestDispatcher("Controlador?menu=Transaccion&accion=Listar").forward(request, response);
                break;
     
                case "Buscar":
                    barraBuscar = request.getParameter("txtBuscar");
                    listaTra = transaccionDAO.barraBusqueda(barraBuscar);
                    request.setAttribute("transacciones", listaTra);
                break;
                case "Cancelar":
                    request.getRequestDispatcher("Controlador?menu=Transaccion&accion=Listar").forward(request, response);
                break;                    
            }
            request.getRequestDispatcher("Transaccion.jsp").forward(request,response);
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
