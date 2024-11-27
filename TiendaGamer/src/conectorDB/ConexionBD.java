package conectorDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static Connection conexion;

    public static Connection getConexion() {
        if (conexion == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/tiendaGAMER";
                String usuario = "root";
                String contraseña = "";
                conexion = DriverManager.getConnection(url, usuario, contraseña);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conexion;
    }
}
