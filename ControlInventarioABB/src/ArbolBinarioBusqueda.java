// Clase que contiene toda la lógica y operaciones del Árbol Binario de Búsqueda (ABB)
public class ArbolBinarioBusqueda {
    private NodoProducto raiz; // Nodo raíz del árbol

    // Constructor: Inicializa el árbol vacío
    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    // Verifica si el árbol está completamente vacío
    public boolean estaVacio() {
        return raiz == null;
    }

    // --- 1. INSERCIÓN ---
    // Método público para insertar un nuevo producto respetando el orden alfabético del ABB
    public void insertar(String nombre, int stock, double precio) {
        raiz = insertarRecursivo(raiz, nombre, stock, precio);
    }

    // Método auxiliar recursivo para ubicar la posición correcta del nodo
    private NodoProducto insertarRecursivo(NodoProducto actual, String nombre, int stock, double precio) {
        // Si llegamos a un espacio vacío, aquí se crea el nuevo nodo
        if (actual == null) {
            return new NodoProducto(nombre, stock, precio);
        }

        // Comparamos alfabéticamente el nombre del producto
        int comparacion = nombre.compareToIgnoreCase(actual.nombre);
        if (comparacion < 0) {
            // Si es menor, va al subárbol izquierdo
            actual.izquierdo = insertarRecursivo(actual.izquierdo, nombre, stock, precio);
        } else if (comparacion > 0) {
            // Si es mayor, va al subárbol derecho
            actual.derecho = insertarRecursivo(actual.derecho, nombre, stock, precio);
        } else {
            // Si el producto ya existe, actualizamos su stock y precio
            System.out.println("⚠️ El producto ya existe. Se actualizará su stock y precio.");
            actual.stock = stock;
            actual.precio = precio;
        }
        return actual;
    }

    // --- 2. BÚSQUEDA (Divide y Vencerás - O(log n)) ---
    // Método público para buscar un producto por su nombre
    public NodoProducto buscar(String nombre) {
        return buscarRecursivo(raiz, nombre);
    }

    // Método auxiliar recursivo para buscar el producto
    private NodoProducto buscarRecursivo(NodoProducto actual, String nombre) {
        // Caso base: si es nulo o encontramos el nombre, retornamos el nodo
        if (actual == null || actual.nombre.equalsIgnoreCase(nombre)) {
            return actual;
        }

        // Si el nombre buscado es menor, buscamos a la izquierda; si no, a la derecha
        if (nombre.compareToIgnoreCase(actual.nombre) < 0) {
            return buscarRecursivo(actual.izquierdo, nombre);
        }
        return buscarRecursivo(actual.derecho, nombre);
    }

    // --- 3. ELIMINACIÓN (Casos: Hoja, 1 hijo, 2 hijos) ---
    // Método público para dar de baja/eliminar un producto
    public void eliminar(String nombre) {
        raiz = eliminarRecursivo(raiz, nombre);
    }

    // Método auxiliar recursivo para eliminar manejando los 3 casos
    private NodoProducto eliminarRecursivo(NodoProducto actual, String nombre) {
        if (actual == null) {
            System.out.println("❌ Producto no encontrado en el inventario.");
            return null;
        }

        int comparacion = nombre.compareToIgnoreCase(actual.nombre);
        if (comparacion < 0) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, nombre);
        } else if (comparacion > 0) {
            actual.derecho = eliminarRecursivo(actual.derecho, nombre);
        } else {
            // Caso 1 y 2: Nodo sin hijos o con un solo hijo
            if (actual.izquierdo == null) {
                return actual.derecho;
            } else if (actual.derecho == null) {
                return actual.izquierdo;
            }

            // Caso 3: Nodo con dos hijos (buscamos el sucesor inorden: el menor del subárbol derecho)
            NodoProducto sucesor = encontrarMinimo(actual.derecho);
            actual.nombre = sucesor.nombre;
            actual.stock = sucesor.stock;
            actual.precio = sucesor.precio;
            // Eliminamos el sucesor duplicado del subárbol derecho
            actual.derecho = eliminarRecursivo(actual.derecho, sucesor.nombre);
        }
        return actual;
    }

    // Encuentra el nodo con el valor menor (más a la izquierda)
    private NodoProducto encontrarMinimo(NodoProducto actual) {
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual;
    }

    // --- 4. RECORRIDO INORDER ---
    // Muestra todos los productos ordenados alfabéticamente
    public void mostrarInOrder() {
        if (estaVacio()) {
            System.out.println("📦 El inventario está vacío.");
        } else {
            System.out.println("\n--- INVENTARIO COMPLETO (ORDEN ALFABÉTICO) ---");
            System.out.printf("%-20s | %-10s | %-10s\n", "NOMBRE", "STOCK", "PRECIO ($)");
            System.out.println("--------------------------------------------------");
            inOrderRecursivo(raiz);
            System.out.println("--------------------------------------------------");
        }
    }

    // Recorrido recursivo: Izquierdo -> Raíz -> Derecho
    private void inOrderRecursivo(NodoProducto actual) {
        if (actual != null) {
            inOrderRecursivo(actual.izquierdo);
            System.out.printf("%-20s | %-10d | $%-9.2f\n", actual.nombre, actual.stock, actual.precio);
            inOrderRecursivo(actual.derecho);
        }
    }
}