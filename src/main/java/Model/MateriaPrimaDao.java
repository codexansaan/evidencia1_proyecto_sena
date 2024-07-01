package Model;

import Controller.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MateriaPrimaDao {
    //Instancia de la conecion
    static ConexionBD conexion = new ConexionBD();
    static Connection conexi;
    static PreparedStatement statement;
    static ResultSet resultSet;

    public static List<MateriaPrima> listarmateria() {
        String sql = "SELECT * FROM materiaprima";
        List<MateriaPrima> listaMateriaPrima = new ArrayList<>();

        try{
            conexi = conexion.ConectarBaseDeDatos();
            statement = conexi.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                MateriaPrima materiaPrima = new MateriaPrima();
                materiaPrima.setId(resultSet.getInt(1));
                materiaPrima.setNombre(resultSet.getString(2));
                materiaPrima.setStock(resultSet.getDouble(3));
                materiaPrima.setUnidadMedida(resultSet.getString(4));
                materiaPrima.setPrecioUnidad(resultSet.getDouble(5));
                listaMateriaPrima.add(materiaPrima);
            }

        }catch(SQLException e){
            System.out.println("Error al crear lista " + e.getMessage());
        }
        return listaMateriaPrima;
    }

    public void Agregar(MateriaPrima materiaPrima) {
        String sql = "INSERT INTO materiaprima (Nombre, Stock, unidadmedida, preciounidad) VALUES (?,?,?,?)";
        try{
            conexi = conexion.ConectarBaseDeDatos();
            statement = conexi.prepareStatement(sql);
            statement.setString(1, materiaPrima.getNombre());
            statement.setDouble(2, materiaPrima.getStock());
            statement.setString(3, materiaPrima.getUnidadMedida());
            statement.setDouble(4, materiaPrima.getPrecioUnidad());
            statement.executeUpdate();
        }catch (SQLException e) {
            System.err.println("Error en el método Agregar clase MateriaPrimaDao" + e);
        }
    }//Fin método agregar




}
