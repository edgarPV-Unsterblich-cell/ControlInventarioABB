// Clase que representa cada nodo del Árbol Binario de Búsqueda (cada producto del almacén)
public class NodoProducto {
    String nombre;         // Llave alfabética única del producto (ordena el ABB)
    int stock;             // Cantidad disponible en el almacén
    double precio;         // Costo unitario del producto
    NodoProducto izquierdo; // Puntero al hijo izquierdo (productos menores alfabéticamente)
    NodoProducto derecho;   // Puntero al hijo derecho (productos mayores alfabéticamente)

    // Constructor para inicializar el nodo con sus datos básicos
    public NodoProducto(String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.izquierdo = null; // Al crearse, no tiene hijos
        this.derecho = null;
    }
}