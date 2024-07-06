package Controller;

import Model.MateriaPrima;
import Model.MateriaPrimaDao;
import View.IinvetariomateriaPrima;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import java.util.List;

public class ControladorMateriaPrima implements ActionListener {

    //variables globales
    private int id;
    private String nombre;
    private double stock;
    private String unidadMedida;
    private double precioUnidad;

    //Instancias
    MateriaPrima materiaPrima = new MateriaPrima();
    MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();
    IinvetariomateriaPrima materiaPrimavista = new IinvetariomateriaPrima();
    DefaultTableModel tableModel = new DefaultTableModel();

    //Constructor que recibe la vista como parametro
    public ControladorMateriaPrima(IinvetariomateriaPrima _materiaPrimavista) {
        this.materiaPrimavista = _materiaPrimavista;
        materiaPrimavista.setVisible(true);
        AgregarEventos();
        listarTabla();
    }

    private void AgregarEventos() {
        materiaPrimavista.getAgregarButton().addActionListener(this);
        materiaPrimavista.getActualizarButton().addActionListener(e -> validarduplicados());
        materiaPrimavista.getEliminarButton().addActionListener(e -> eliminarProductos());
        materiaPrimavista.getLimpiarButton().addActionListener(e -> limpiarcampos());
        materiaPrimavista.getTableMateriaPrima().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                llenarCampos(e);
                listarTabla();

            }
        });
    }

    private void listarTabla() {
        String[] titulos = new String[]{"Id", "Nombre", "Stock", "Unidad de medida", "Precio Unidad"};
        tableModel = new DefaultTableModel(titulos, 0);
        List<MateriaPrima> listaMateria = MateriaPrimaDao.listarmateria();
        for (MateriaPrima materiaPrima : listaMateria) {
            tableModel.addRow(new Object[]{
                    materiaPrima.getId(),
                    materiaPrima.getNombre(),
                    materiaPrima.getStock(),
                    materiaPrima.getUnidadMedida(),
                    materiaPrima.getPrecioUnidad()
            });
        }
        materiaPrimavista.getTableMateriaPrima().setModel(tableModel);
        materiaPrimavista.getTableMateriaPrima().setPreferredSize(new Dimension(350, tableModel.getRowCount() * 16));
    }
    //LLena los campos del formulario con los datos de la tabla.
    private void llenarCampos(MouseEvent e) {
        JTable target = (JTable) e.getSource();
        materiaPrimavista.getTxtNombre()
                .setText(materiaPrimavista.getTableMateriaPrima().getModel()
                        .getValueAt(target.getSelectedRow(), 1)
                        .toString());
        materiaPrimavista.getTxtStock()
                .setText(materiaPrimavista.getTableMateriaPrima().getModel()
                        .getValueAt(target.getSelectedRow(), 2)
                        .toString());
        materiaPrimavista.getTxtunidadMedida()
                .setText(materiaPrimavista.getTableMateriaPrima().getModel()
                        .getValueAt(target.getSelectedRow(), 3)
                        .toString());
        materiaPrimavista.getTxtprecioUnidad()
                .setText(materiaPrimavista.getTableMateriaPrima().getModel()
                        .getValueAt(target.getSelectedRow(), 4)
                        .toString());//Para el inventario
    }
    //Valida que no existan campos vacios
    private boolean validarDatos() {
        if ("".equals(materiaPrimavista.getTxtNombre().getText()) ||
                "".equals(materiaPrimavista.getTxtStock().getText()) ||
                "".equals(materiaPrimavista.getTxtunidadMedida().getText()) ||
                "".equals(materiaPrimavista.getTxtprecioUnidad().getText())) {
            JOptionPane.showMessageDialog(null, "Los campos no pueden ser vacíos",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    //Carga los datos para agregar
    private boolean cargardatos() {
        try {
            nombre = materiaPrimavista.getTxtNombre().getText();
            stock = Double.parseDouble(materiaPrimavista.getTxtStock().getText());
            unidadMedida = materiaPrimavista.getTxtunidadMedida().getText();
            precioUnidad = Double.parseDouble(materiaPrimavista.getTxtprecioUnidad().getText());

            return true;
        }catch (NumberFormatException e) {
            JOptionPane.showInternalMessageDialog(null,"Los campos Stock y Precio unidad deben ser numericos",
                    "error",JOptionPane.ERROR);
            System.out.println("Error al cargar los datos" + e);
            return false;
        }
    }
    //Limpia los campos del formulario
    private void limpiarcampos(){
        materiaPrimavista.getTxtNombre().setText("");
        materiaPrimavista.getTxtStock().setText("");
        materiaPrimavista.getTxtunidadMedida().setText("");
        materiaPrimavista.getTxtprecioUnidad().setText("");
        nombre = "";
        stock = Double.parseDouble((""));
        unidadMedida = "";
        precioUnidad = Double.parseDouble("");
    }

    private void agregarProductos() {
        try {


                    if (validarDatos()) {
                        if (cargardatos()) {
                            MateriaPrima materiaPrima = new MateriaPrima(nombre, stock, unidadMedida, precioUnidad);
                            materiaPrimaDao.Agregar(materiaPrima);
                            JOptionPane.showMessageDialog(null, "Registro agregado con éxito");
                        }
                    }
        }catch (Exception e){
            System.out.println("Error al agregar (ControladorProducto");
        }finally {
            listarTabla();
            limpiarcampos();
        }
    }

    private void eliminarProductos() {

        try {
            nombre = materiaPrimavista.getTxtNombre().getText();
            if ("".equals(materiaPrimavista.getTxtNombre().getText())) {
                JOptionPane.showMessageDialog(null, "Ingrese el nombre de la materia prima");
            } else {
                materiaPrimaDao.eliminarMateriaPrima(nombre);
                JOptionPane.showMessageDialog(null, "Registro eliminado con éxito");
            }
        }catch (NumberFormatException e){
            System.out.println("Error al eliminar el registro");
        }finally {
            listarTabla();
            limpiarcampos();
        }

    }

    //Validar duplicados
    private void validarduplicados() {

        try {
            nombre = materiaPrimavista.getTxtNombre().getText();
            int duplicados = materiaPrimaDao.esNombreDuplicado(nombre);

            if (duplicados > 0) {
                System.out.println(".");
                int response = JOptionPane.showConfirmDialog(null, "No se puede agregar la materia prima porque ya existe uno con ese nombre. " +
                        " Desea actualizar la materia prima", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    materiaPrimaDao.actualizarMateriaPrima(materiaPrima);
                } else if (response == JOptionPane.NO_OPTION) {
                    limpiarcampos();
                }
            }
        }catch(NumberFormatException e) {
            System.err.println("Error al validar los nombres duplicados");
        }
    }

       /* public static void main(String[] args) {
            MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();

            // Crear un objeto MateriaPrima con valores de prueba
            MateriaPrima materiaPrima = new MateriaPrima();
            materiaPrima.setNombre("Harina");
            materiaPrima.setStock(500.0);
            materiaPrima.setUnidadMedida("kg");
            materiaPrima.setPrecioUnidad(1.5);

            // Llamar al método de actualización
            materiaPrimaDao.actualizarMateriaPrima(materiaPrima);
        }*/







    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== materiaPrimavista.getAgregarButton()){
            agregarProductos();
        }
    } //materiaPrimavista.getTableMateriaPrima().setModel(tableModel);

}
    //Llenar campos de la tabla









