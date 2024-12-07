import java.io.*;
import java.util.*;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void cargaProductos(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String Registro;
            while ((Registro = br.readLine()) != null) {
                String[] data = Registro.split(",");
                int id = Integer.parseInt(data[0].trim());
                String nombre = data[1].trim();
                String categoria = data[2].trim();
                double precio = Double.parseDouble(data[3].trim());
                int cantidad = Integer.parseInt(data[4].trim());
                productos.add(new Producto(id, nombre, categoria, precio, cantidad));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error cargando productos: " + e.getMessage());
        }
    }

    public void crearProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto creado correctamente.");
    }

    public void actualizarProducto(int id, String name, String category, double price, int quantity) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setName(name);
                producto.setCategory(category);
                producto.setPrice(price);
                producto.setQuantity(quantity);
                System.out.println("Producto actualizado exitosamente.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void borraProducto(int id) {
        productos.removeIf(producto -> producto.getId() == id);
        System.out.println("Producto eliminado exitosamente.");
    }

    public void busquedaxcategoria(String category) {
        productos.stream()
                .filter(producto -> producto.getCategory().equalsIgnoreCase(category))
                .forEach(System.out::println);
    }

    public void generaReporte(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            double valorTotal = 0;
            for (Producto product : productos) {
                bw.write(product.toString());
                bw.newLine();
                valorTotal += product.getPrice() * product.getQuantity();
            }
            bw.write("Valor Total Inventario: " + valorTotal);
            bw.newLine();
            System.out.println("Reporte generado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error generando reporte: " + e.getMessage());
        }
    }

    public void calculoCantidadxCategoria(String category) {
        int totalQuantity = productos.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .mapToInt(Producto::getQuantity)
                .sum();
        System.out.println("Cantidad total de productos por categoria " + category + ": " + totalQuantity);
    }

    public void mayorPrecioProducto() {
        productos.stream()
                .max(Comparator.comparingDouble(Producto::getPrice))
                .ifPresent(product -> System.out.println("El producto de mayor precio: " + product));
    }
}
