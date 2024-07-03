package View;

import Controller.ControladorMateriaPrima;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IinvetariomateriaPrima extends javax.swing.JFrame {

    //Paneles globales
    private JPanel panelPrincipal;
    private JPanel panelcampos;
    private JPanel panelbotones;

    //Titulo y componentes
    private JPanel titulo;
    private JLabel encabezado;
    private JLabel encabezadologo;

    //Panel campos
    private JLabel nombre;
    private JLabel stock;
    private JLabel unidadMedida;
    private JLabel precioUnidadMedida;
    private JTextField txtNombre;
    private JTextField txtStock;
    private JTextField txtunidadMedida;
    private JTextField txtprecioUnidad;

    //Panel botones
    private JButton agregarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JButton limpiarButton;

    //Tabla materia prima
    private JTable tableMateriaPrima;





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

        //Inicializa los componentes

        panelPrincipal = new JPanel(new BorderLayout());
        titulo = new JPanel( new BorderLayout());
        panelcampos = new JPanel(new GridLayout(4,4,5,10));
        panelbotones = new JPanel(new GridLayout(0,1,5,10));
        tableMateriaPrima = new JTable();
        encabezado = new JLabel("Inventario materia prima");
        encabezadologo = new JLabel("Boulevar Soft.");
        nombre = new JLabel("Nombre");
        txtNombre = new JTextField(5);
        stock = new JLabel("Stock");
        txtStock = new JTextField(5);
        unidadMedida = new JLabel("Unidad de medida");
        txtunidadMedida = new JTextField(5);
        precioUnidadMedida = new JLabel("Precio unidad");
        txtprecioUnidad = new JTextField(5);
        agregarButton = new JButton("Agregar");
        actualizarButton = new JButton("Actualizar");
        eliminarButton = new JButton("Eliminar");
        limpiarButton = new JButton("Limpiar");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        //Estilos
        encabezado.setFont(new java.awt.Font("Bodoni MT", 3, 24));
        encabezado.setForeground(new Color(161, 20, 25));
        encabezadologo.setFont(new java.awt.Font("Bodoni MT", 3, 28));
        encabezadologo.setForeground(new Color(161, 20, 25));
        nombre.setFont(new java.awt.Font("Bodoni MT", 3, 20));
        nombre.setForeground(new Color(161, 20, 25));
        stock.setFont(new java.awt.Font("Bodoni MT", 3, 20));
        stock.setForeground(new Color(161, 20, 25));
        unidadMedida.setFont(new java.awt.Font("Bodoni MT", 3, 20));
        unidadMedida.setForeground(new Color(161, 20, 25));
        precioUnidadMedida.setFont(new java.awt.Font("Bodoni MT", 3, 20));
        precioUnidadMedida.setForeground(new Color(161, 20, 25));
        titulo.setBackground(new Color(250,250,250));
        panelcampos.setBackground(new Color(250,250,250));
        agregarButton.setForeground(new Color(161,20,25));
        actualizarButton.setForeground(new Color(161,20,25));
        eliminarButton.setForeground(new Color(161,20,25));
        limpiarButton.setForeground(new Color(161,20,25));

        //Margenes
        panelPrincipal.setBorder(new EmptyBorder(5,5,5,5));
        panelcampos.setBorder(new EmptyBorder(2,40,5,40));

        //Añade los componentes a los paneles
        titulo.add(encabezado, BorderLayout.WEST);
        titulo.add(encabezadologo, BorderLayout.EAST);
        panelcampos.add(nombre);
        panelcampos.add(txtNombre);
        panelcampos.add(stock);
        panelcampos.add(txtStock);
        panelcampos.add(unidadMedida);
        panelcampos.add(txtunidadMedida);
        panelcampos.add(precioUnidadMedida);
        panelcampos.add(txtprecioUnidad);
        panelbotones.add(agregarButton);
        panelbotones.add(actualizarButton);
        panelbotones.add(eliminarButton);
        panelbotones.add(limpiarButton);

        //Añade los paneles al frame principal
        panelPrincipal.add(titulo, BorderLayout.NORTH);
        panelPrincipal.add(panelcampos, BorderLayout.CENTER);
        panelPrincipal.add(panelbotones, BorderLayout.EAST);
        panelPrincipal.add(new JScrollPane(tableMateriaPrima), BorderLayout.SOUTH);



        add(panelPrincipal);
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

