package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Iinventarioproducto {
    private JTextField txtNombre;
    private JTextField txtStock;
    private JTextField txtPrecio;
    private JTextField txtprecioLlevar;
    private JTextField txtIVA;
    private JTextField txtcostoProduccion;
    private JTable table1;
    private JButton btnAgregar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JLabel nombre;
    private JLabel stock;
    private JLabel precio;
    private JLabel precioLlevar;
    private JLabel costoProduccion;
    private JLabel iva;



    public Iinventarioproducto() {
        txtNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txtStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txtPrecio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txtprecioLlevar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txtIVA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txtcostoProduccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
