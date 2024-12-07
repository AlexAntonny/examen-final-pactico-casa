import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.cargaProductos("productos.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("|-------------------------------------------|");
            System.out.println("|            Inventario Productos           |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|1. Agregar Producto                        |");
            System.out.println("|2. Actualizar Producto                     |");
            System.out.println("|3. Eliminar Producto                       |");
            System.out.println("|4. Buscar Producto x Categoria,Nombre e Id |");
            System.out.println("|5. Calcular Precio Mayor Producto          |");
            System.out.println("|6. Cantidad Productos x Categoria          |");
            System.out.println("|7. Reporte de Inventario                   |");
            System.out.println("|8. Salir                                   |");
            System.out.println("|-------------------------------------------|");

            System.out.print("Digite # de Opción: ");
            int num1 = scanner.nextInt();
            scanner.nextLine();

            switch (num1) {
                case 1:
                    System.out.print("Ingrese:  ID, Nombre, Categoria, Precio, Cantidad (Separados por comas): ");
                    String[] data = scanner.nextLine().split(",");
                    inventario.crearProducto(new Producto(
                            Integer.parseInt(data[0].trim()),
                            data[1].trim(),
                            data[2].trim(),
                            Double.parseDouble(data[3].trim()),
                            Integer.parseInt(data[4].trim())
                    ));
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Ingrese el ID del producto que desea actualizar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese Nombre, Categoria, Precio, Cantidad (Separados por comas): ");
                    String[] updateData = scanner.nextLine().split(",");
                    inventario.actualizarProducto(id, updateData[0].trim(), updateData[1].trim(),
                            Double.parseDouble(updateData[2].trim()), Integer.parseInt(updateData[3].trim()));
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Ingrese ID de producto a eliminar: ");
                    int deleteId = scanner.nextInt();
                    inventario.borraProducto(deleteId);
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Ingrese categoria a buscar: ");
                    String categoria = scanner.nextLine();
                    inventario.busquedaxcategoria(categoria);
                    scanner.nextLine();
                    break;
                case 5:
                    inventario.mayorPrecioProducto();
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.print("Ingrese la categoria para contar los productos: ");
                    String cantidadCategoria = scanner.nextLine();
                    inventario.calculoCantidadxCategoria(cantidadCategoria);
                    scanner.nextLine();
                    break;
                case 7:
                    inventario.generaReporte("reporte_inventario.txt");
                    scanner.nextLine();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion invalida, intente nuevamente.");
            }
        }
    }
}
