import java.util.Objects;

public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;

    public Producto (int id, String nombre, String categoria, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad= cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = nombre;
    }

    public String getCategory() {
        return categoria;
    }

    public void setCategory(String category) {
        this.categoria = categoria;
    }

    public double getPrice() {
        return precio;
    }

    public void setPrice(double price) {
        this.precio = precio;
    }

    public int getQuantity() {
        return cantidad;
    }

    public void setQuantity(int quantity) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return id + ", " + nombre + ", " + categoria + ", " + precio + ", " + cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto product = (Producto) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
