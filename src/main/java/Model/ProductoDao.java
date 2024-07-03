package Model;

import Controller.ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {
    ConexionBD conexion =new ConexionBD();
    static Connection connection;
    static PreparedStatement statement;
    static ResultSet resultSet;

    public List listar(){
        String sql="SELECT * FROM productos";
        List<Producto> lista = new ArrayList<>();

        try{

            connection = conexion.ConectarBaseDeDatos(); //conecta la base de datos
            statement = connection.prepareStatement(sql); //prepara la consulta sql
            resultSet = statement.executeQuery();//ejecuta en el servidor
            while(resultSet.next()){
                Producto producto = new Producto();
                producto.setId(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setStock(resultSet.getInt(3));
                producto.setPrecio(resultSet.getInt(4));
                producto.setPrecioLLevar(resultSet.getDouble(5));
                producto.setIva(resultSet.getDouble(6));
                producto.setCosto(resultSet.getDouble(7));
                lista.add(producto);
            }
        }catch(SQLException e){
            System.out.println("Error al listar "+ e.getMessage());
        }
        return lista;
    }
}
