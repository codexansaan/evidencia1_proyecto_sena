package Model;

import Controller.ConexionBD;


import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;




public class MateriaPrimaDao {
    //Instancia de la conexion
    static ConexionBD conexion = new ConexionBD();
    static Connection conexi;
    static PreparedStatement statement;
    static ResultSet resultSet;

    //Método para listar los registros de la base de datos
    public static List<MateriaPrima> listarmateria() {
        String sql = "SELECT * FROM materiaprima";
        List<MateriaPrima> listaMateriaPrima = new ArrayList<>();

        try{
            conexi = conexion.conectarBaseDeDatos();
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
    }//Fin metodo listar.

    //Método para agregar registros a la base de datos
    public void agregarMateriaPrima(MateriaPrima materiaPrima) {
        String sql = "INSERT INTO materiaprima (Nombre, Stock, unidadmedida, preciounidad) VALUES (?,?,?,?)";
        try{

            conexi = conexion.conectarBaseDeDatos();
            statement = conexi.prepareStatement(sql);
            statement.setString(1, materiaPrima.getNombre());
            statement.setDouble(2, materiaPrima.getStock());
            statement.setString(3, materiaPrima.getUnidadMedida());
            statement.setDouble(4, materiaPrima.getPrecioUnidad());
            statement.executeUpdate();


        }catch (SQLException e) {
            System.err.println("Error en el método agregarMateriaPrima clase MateriaPrimaDao" + e.getMessage());
        }
    }//Fin método agregar

    //Método para eliminar registros de la base de datos
    public  void eliminarMateriaPrima(String nombre) {
        String sql = "DELETE FROM materiaprima WHERE nombre = ?";

        try {
            conexi = conexion.conectarBaseDeDatos();
            statement = conexi.prepareStatement(sql);
            statement.setString(1, String.valueOf(nombre));
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Registro eliminado con éxito.");
            } else {
                System.out.println("No se encontró ningún registro con ese nombre.");
                JOptionPane.showMessageDialog(null,
                        "No se encontró ningún registro con ese nombre.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar materia prima: " + e.getMessage());
        }
    }

    //Validar nombre de materia prima repetida
    public int esNombreDuplicado(String nombre) {
        String sql = "SELECT COUNT(*) FROM materiaprima WHERE nombre = ?";
        int count = 0;
        try {
            conexi = conexion.conectarBaseDeDatos();
            statement = conexi.prepareStatement(sql);
            statement.setString(1, String.valueOf(nombre));
            resultSet = statement.executeQuery();
            try {
                if (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            } catch (SQLException e) {
                System.err.println("Error en el método contarNombresDuplicados de ProductoDAO: "
                        + e.getMessage());
            }
        }catch (SQLException e) {
            System.err.println("Error en el método contarNombresDuplicados de ProductoDAO: "
                    + e.getMessage());
        }
        return count;
    }//Fin de nombre duplicado

    public void actualizarMateriaPrima(MateriaPrima materiaPrima) {
        String sql = "UPDATE materiaprima SET stock = ?, unidadMedida = ?, precioUnidad = ? WHERE nombre = ?";
        try {
            conexi = conexion.conectarBaseDeDatos();
            statement = conexi.prepareStatement(sql);
            statement.setDouble(1, materiaPrima.getStock());
            statement.setString(2, materiaPrima.getUnidadMedida());
            statement.setDouble(3, materiaPrima.getPrecioUnidad());
            statement.setString(4, materiaPrima.getNombre());
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Registro actualizado con éxito.");
            } else {
                System.out.println("No se encontró ningún registro con ese nombre.");
            }
        } catch (SQLException e) {
            System.err.println("Error en el método actualizarMateriaPrima de MateriaPrimaDao: "
                    + e.getMessage());
        }
    }
}
