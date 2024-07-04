package Controller;

import Model.MateriaPrima;
import Model.MateriaPrimaDao;
import View.IinvetariomateriaPrima;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
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
        materiaPrimavista.getAgregarButton().addActionListener(e -> agregarProductos());
        materiaPrimavista.getActualizarButton().addActionListener(e -> actualizarMateriaPrima());
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

    private boolean cargardatos() {
        try {
            nombre = materiaPrimavista.getTxtNombre().getText();
            stock = Double.parseDouble(materiaPrimavista.getTxtStock().getText());
            unidadMedida = materiaPrimavista.getTxtprecioUnidad().getText();
            precioUnidad = Double.parseDouble(materiaPrimavista.getTxtprecioUnidad().getText());

            return true;
        }catch (NumberFormatException e) {
            JOptionPane.showInternalMessageDialog(null,"Los campos Stock y Precio unidad deben ser numericos",
                    "error",JOptionPane.ERROR);
            System.out.println("Error al cargar los datos" + e);
            return false;
        }
    }

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
            if (validarDatos()){
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
        }

    }

    private void actualizarMateriaPrima(){

        nombre = materiaPrimavista.getTxtNombre().getText();
        stock = Double.parseDouble(materiaPrimavista.getTxtStock().getText());
        unidadMedida = materiaPrimavista.getTxtprecioUnidad().getText();
        precioUnidad = Double.parseDouble(materiaPrimavista.getTxtprecioUnidad().getText());
        materiaPrimaDao.actualizarMateriaPrima(materiaPrima);
        listarTabla();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== materiaPrimavista.getAgregarButton()){
            agregarProductos();
        }
    } //materiaPrimavista.getTableMateriaPrima().setModel(tableModel);

}
    //Llenar campos de la tabla









