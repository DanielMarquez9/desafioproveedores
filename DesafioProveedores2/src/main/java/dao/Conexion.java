package com.miempresa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection conn;
    private static final String URL = "jdbc:postgresql://localhost:5432/nombre_de_tu_base";
    private static final String USER = "tu_usuario";
    private static final String PASS = "tu_contraseña";

    public static Connection getConexion() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER, PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
