package Modelo;

public class venta1 {

    private int id_venta;
    private int cantidad_venta;
    private int id_producto;
    private String modelo;
    private String color;
    private double precio;

    public venta1() {
    }

    public venta1(int id_venta, int cantidad_venta, int id_producto, String modelo, String color, double precio) {
        this.id_venta = id_venta;
        this.cantidad_venta = cantidad_venta;
        this.id_producto = id_producto;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
