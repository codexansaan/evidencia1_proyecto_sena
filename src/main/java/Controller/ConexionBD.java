package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {

    Connection conectar;
    String bd = "proyecto_sena_boulevar";
    String url = "jdbc:mysql://localhost:3306/" + bd;
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";


    public Connection ConectarBaseDeDatos() {
        try{
            Class.forName(driver);
            conectar = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa a la base de datos "+ bd);
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("No se pudo conectar a la base de datos "+bd);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    return conectar;

    };
    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        conexion.ConectarBaseDeDatos();
    }
}
