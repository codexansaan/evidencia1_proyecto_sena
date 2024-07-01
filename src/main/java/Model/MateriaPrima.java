package Model;

public class MateriaPrima {
    private int id;
    private String nombre;
    private double stock;
    private String unidadMedida;
    private double precioUnidad;

    //Constructor vacio
    public MateriaPrima() {
    }

    //Constructor para agregar
    public MateriaPrima(String nombre, Double stock, String unidadMedida, Double precioUnidad) {
        this.nombre = nombre;
        this.stock = stock;
        this.unidadMedida = unidadMedida;
        this.precioUnidad = precioUnidad;
    }

    //Constructor con todos los campos
    public MateriaPrima(int id, String nombre, Double stock, String unidadMedida, Double precioUnidad) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.unidadMedida = unidadMedida;
        this.precioUnidad = precioUnidad;
    }

    //getters y setters

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

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }
}/*Fin de la clase producto*/
