package Model;

public class Producto {

    private int id;
    private String nombre;
    private int stock;
    private double precio;
    private double precioLLevar;
    private double iva;
    private double costo;

    //Constructor vacio
    public Producto() {
    }

    //Constructor agregar
    public Producto(String nombre, int stock, double precio, double precioLLevar, double iva, double costo) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.precioLLevar = precioLLevar;
        this.iva = iva;
        this.costo = costo;
    }

    //Constructor
    public Producto(int id, String nombre, int stock, double precio, double precioLLevar, double iva, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.precioLLevar = precioLLevar;
        this.iva = iva;
        this.costo = costo;
    }

    //modificar o consultar
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioLLevar() {
        return precioLLevar;
    }

    public void setPrecioLLevar(double precioLLevar) {
        this.precioLLevar = precioLLevar;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
