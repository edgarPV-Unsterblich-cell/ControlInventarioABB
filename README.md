# 📦 Sistema de Control de Inventario en Tiempo Real (ABB en Java)

**Asignatura:** Estructura de Datos  
**By: Edgar.E.P.V**
**Lenguaje:** Java (JDK 8+)  
**Estructura de Datos:** Árbol Binario de Búsqueda (ABB)  
**Interfaz:** Consola / CLI  

---

## 📌 Descripción del Proyecto

Este proyecto consiste en una aplicación interactiva basada en consola para simular el **control de mercancías e inventario en tiempo real** de un almacén. 

Cada elemento del inventario se gestiona dinámicamente como un nodo dentro de un **Árbol Binario de Búsqueda (ABB)**, utilizando el **nombre del producto** como llave principal para mantener un ordenamiento alfabético constante.

### 🔑 Aspectos Clave de la Implementación
* **Llave Alfabética Unica:** Las comparaciones lexicográficas se realizan mediante el método `compareToIgnoreCase()` de la clase `String`.
* **Inserción Ordenada:** Los productos con nombres alfabéticamente menores se ubican en la rama izquierda y los mayores en la rama derecha.
* **Búsqueda Eficiente:** Implementa la estrategia de *Divide y Vencerás* para la localización de productos con una complejidad media de $\mathcal{O}(\log n)$.
* **Eliminación Manejando 3 Casos:**
  1. Nodo hoja (sin hijos).
  2. Nodo con un solo hijo.
  3. Nodo con dos hijos (utilizando el **sucesor inorden** —el menor elemento del subárbol derecho—).
* **Recorrido InOrder:** Permite listar el inventario completo formateado e impreso estrictamente en orden alfabético (A-Z).

---

## 📁 Estructura del Proyecto

El proyecto sigue una arquitectura clara y modular compuesta por 3 clases:

```text
src/
├── NodoProducto.java         # Representa cada producto y sus enlaces (izq, der)
├── ArbolBinarioBusqueda.java # Contiene la lógica y algoritmos del ABB
└── Main.java                 # Interfaz de usuario interactiva por consola (Scanner)
