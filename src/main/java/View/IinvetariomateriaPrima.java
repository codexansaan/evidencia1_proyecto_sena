package View;

import Controller.ControladorMateriaPrima;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IinvetariomateriaPrima extends javax.swing.JFrame {

    private JTextField txtNombre;
    private JTextField txtStock;
    private JTextField txtunidadMedida;
    private JTextField txtprecioUnidad;
    private JTable tableMateriaPrima;
    private JButton agregarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JLabel nombre;
    private JLabel stock;
    private JLabel unidadMedida;
    private JLabel precioUnidadMedida;
    private JButton limpiarButton;

    public static void main(String args[]) {

        IinvetariomateriaPrima materiaPrimavista = new IinvetariomateriaPrima();
        ControladorMateriaPrima controladorMateriaPrima = new ControladorMateriaPrima(materiaPrimavista);

    }
    //Inicializar los componentes
        public IinvetariomateriaPrima() {
            initComponents();
            limpiarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }

    private void initComponents() {
        txtNombre = new JTextField(20);
        txtStock = new JTextField(20);
        txtunidadMedida = new JTextField(20);
        txtprecioUnidad = new JTextField(20);
        agregarButton = new JButton("Agregar");
        actualizarButton = new JButton("Actualizar");
        eliminarButton = new JButton("Eliminar");
        tableMateriaPrima = new JTable();
        limpiarButton = new JButton("Limpiar");

        JPanel panelCampos = new JPanel();
        panelCampos.add(new JLabel("Nombre:"));
        panelCampos.add(txtNombre);
        panelCampos.add(new JLabel("Stock:"));
        panelCampos.add(txtStock);
        panelCampos.add(new JLabel("Unidad de medida"));
        panelCampos.add(txtunidadMedida);
        panelCampos.add(new JLabel("Precio unidad:"));
        panelCampos.add(txtprecioUnidad);


        JPanel panelBotones = new JPanel();
        panelBotones.add(agregarButton);
        panelBotones.add(actualizarButton);
        panelBotones.add(eliminarButton);
        panelBotones.add(limpiarButton);

        add(panelCampos, BorderLayout.NORTH);
        add(panelBotones);
        add(new JScrollPane(tableMateriaPrima), BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Inventario materia prima");
        pack();
        setLocationRelativeTo(null);

    }

    //getters y setters

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JButton getAgregarButton() {
        return agregarButton;
    }

    public JButton getActualizarButton() {
        return actualizarButton;
    }

    public JButton getEliminarButton() {
        return eliminarButton;
    }

    public JTextField getTxtStock() {
        return txtStock;
    }

    public JTextField getTxtunidadMedida() {
        return txtunidadMedida;
    }

    public JTextField getTxtprecioUnidad() {
        return txtprecioUnidad;
    }

    public JTable getTableMateriaPrima() {
        return tableMateriaPrima;
    }

    public JButton getLimpiarButton() {
        return limpiarButton;
    }


}

//Fin clase interfaz

