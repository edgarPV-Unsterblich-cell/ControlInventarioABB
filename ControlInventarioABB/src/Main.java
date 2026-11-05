import java.util.Scanner;

// Clase principal que contiene la interfaz de usuario por consola con un menú interactivo
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinarioBusqueda inventario = new ArbolBinarioBusqueda(); // Instanciamos el ABB
        char opcion;

        do {
            // Mostrar el menú interactivo en consola
            System.out.println("\n========================================");
            System.out.println("    SISTEMA DE CONTROL DE INVENTARIO    ");
            System.out.println("========================================");
            System.out.println("a) Registrar / Insertar nuevo producto");
            System.out.println("b) Buscar producto por nombre");
            System.out.println("c) Dar de baja / Eliminar producto");
            System.out.println("d) Mostrar inventario completo (InOrder)");
            System.out.println("e) Salir");
            System.out.print("Seleccione una opción (a-e): ");

            // Leer la opción ingresada por el usuario
            String entrada = scanner.nextLine().trim().toLowerCase();
            if (entrada.isEmpty()) {
                opcion = ' ';
            } else {
                opcion = entrada.charAt(0);
            }

            // Evaluar la opción seleccionada mediante un switch
            switch (opcion) {
                case 'a':
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreIns = scanner.nextLine().trim();
                    System.out.print("Ingrese la cantidad en stock: ");
                    int stock = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Ingrese el costo unitario ($): ");
                    double precio = Double.parseDouble(scanner.nextLine().trim());

                    // Llamada al método de inserción del ABB
                    inventario.insertar(nombreIns, stock, precio);
                    System.out.println(" Producto registrado con éxito.");
                    break;

                case 'b':
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String nombreBus = scanner.nextLine().trim();
                    // Llamada al método de búsqueda del ABB
                    NodoProducto encontrado = inventario.buscar(nombreBus);

                    if (encontrado != null) {
                        System.out.println("\n ¡Producto encontrado!");
                        System.out.println("  • Nombre : " + encontrado.nombre);
                        System.out.println("  • Stock  : " + encontrado.stock);
                        System.out.println("  • Precio : $" + encontrado.precio);
                    } else {
                        System.out.println(" Producto no encontrado en el inventario.");
                    }
                    break;

                case 'c':
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String nombreEli = scanner.nextLine().trim();
                    // Llamada al método de eliminación del ABB
                    inventario.eliminar(nombreEli);
                    System.out.println("🔄 Operación de baja procesada.");
                    break;

                case 'd':
                    // Llamada al recorrido InOrder para ver el inventario ordenado
                    inventario.mostrarInOrder();
                    break;

                case 'e':
                    System.out.println(" Saliendo del sistema de inventario. ¡Hasta luego!");
                    break;

                default:
                    System.out.println(" Opción inválida. Ingrese una opción entre 'a' y 'e'.");
            }
        } while (opcion != 'e'); // El ciclo se repite hasta que el usuario elija salir ('e')

        scanner.close(); // Cerramos el scanner para liberar recursos
    }
}