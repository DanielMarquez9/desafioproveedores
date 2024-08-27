<html>
<head>
    <meta charset="UTF-8">
    <title>Edición de Proveedor</title>
</head>
<body>
    <h2>Edición de Proveedor</h2>
    <%
        Proveedor proveedor = (Proveedor) request.getAttribute("proveedor");
    %>
    <form action="ProveedorServlet" method="post">
        <input type="hidden" name="id" value="<%= proveedor.getId() %>">
        Nombre: <input type="text" name="nombre" value="<%= proveedor.getNombre() %>" required><br>
        Dirección: <input type="text" name="direccion" value="<%= proveedor.getDireccion() %>" required><br>
        Teléfono: <input type="text" name="telefono" value="<%= proveedor.getTelefono() %>" required><br>
        <input type="submit" value="Guardar">
    </form>
</body>
</html>
