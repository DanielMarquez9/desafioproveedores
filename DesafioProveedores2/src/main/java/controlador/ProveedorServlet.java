package com.miempresa.controlador;

import com.miempresa.dao.ProveedorDAO;
import com.miempresa.modelo.Proveedor;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProveedorServlet")
public class ProveedorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProveedorDAO proveedorDAO;

    public ProveedorServlet() {
        super();
        proveedorDAO = new ProveedorDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        if (nombre != null && direccion != null && telefono != null &&
            !nombre.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty()) {
            Proveedor proveedor = new Proveedor(nombre, direccion, telefono);
            proveedorDAO.insertarProveedor(proveedor);
        }

        response.sendRedirect("ProveedorServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "editar":
                editarProveedor(request, response);
                break;
            case "eliminar":
                eliminarProveedor(request, response);
                break;
            default:
                listarProveedores(request, response);
                break;
        }
    }

    private void listarProveedores(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Proveedor> proveedores = proveedorDAO.obtenerTodosProveedores();
        request.setAttribute("proveedores", proveedores);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void editarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Proveedor proveedor = proveedorDAO.obtenerProveedorPorId(id);
        request.setAttribute("proveedor", proveedor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edicion.jsp");
        dispatcher.forward(request, response);
    }

    private void eliminarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        proveedorDAO.eliminarProveedor(id);
        response.sendRedirect("ProveedorServlet");
    }
}
