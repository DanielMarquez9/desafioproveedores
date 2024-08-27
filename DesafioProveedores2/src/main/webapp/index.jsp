<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Proveedores</title>
</head>
<body>
    <h2>Ingreso de Proveedor</h2>
    <form action="ProveedorServlet" method="post">
        Nombre: <input type="text" name="nombre" required><br>
        Dirección: <input type="text" name="direccion" required><br>
        Teléfono: <input type="text" name="telefono" required><br>
        <input type="submit" value="Guardar">
    </form>
    
    <h2>Listado de Proveedores</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Dirección</th>
            <th>Teléfono</th>
            <th>Acciones</th>
        </tr>
        <%
            // Aquí se iterará sobre la lista de proveedores y se mostrarán los datos
            List<Proveedor> proveedores = (List<Proveedor>) request.getAttribute("proveedores");
            if (proveedores != null) {
                for (Proveedor proveedor : proveedores) {
        %>
        <tr>
            <td><%= proveedor.getId() %></td>
            <td><%= proveedor.getNombre() %></td>
            <td><%= proveedor.getDireccion() %></td>
            <td><%= proveedor.getTelefono() %></td>
            <td>
                <a href="ProveedorServlet?action=editar&id=<%= proveedor.getId() %>">Editar</a>
                <a href="ProveedorServlet?action=eliminar&id=<%= proveedor.getId() %>">Eliminar</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
