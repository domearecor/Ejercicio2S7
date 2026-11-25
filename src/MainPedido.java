public class MainPedido {
    public static void main(String[] args) {
        // Crear productos fuera del pedido
        Producto p1 = new Producto("P01", "Café en grano", 12.50);
        Producto p2 = new Producto("P02", "Taza térmica", 18.00);
        Producto p3 = new Producto("P03", "Prensa francesa", 24.00);
        Producto p4 = new Producto("P04", "Filtro reutilizable", 8.00);

        Pedido pedido = new Pedido();

        // Agregar al menos 4 detalles (y probar acumular cantidad con p1)
        pedido.agregarProducto(p1, 2);
        pedido.agregarProducto(p2, 1);
        pedido.agregarProducto(p3, 1);
        pedido.agregarProducto(p4, 3);
        pedido.agregarProducto(p1, 1); // Desafío: acumula 2 + 1 = 3 unidades de p1

        System.out.println("--- Pruebas mínimas ND-L1 ---");
        System.out.println("Cantidad de detalles (size()): " + pedido.cantidadDetalles());
        System.out.println("Total calculado: $" + pedido.calcularTotal());
        System.out.println(pedido.mostrarResumen());

        System.out.println("\n--- Eliminar detalle válido (índice 1) ---");
        System.out.println("Eliminado: " + pedido.eliminarDetalle(1));
        System.out.println("Nuevo size(): " + pedido.cantidadDetalles());

        System.out.println("\n--- Eliminar detalle inválido (índice 99) ---");
        System.out.println("Eliminado: " + pedido.eliminarDetalle(99));

        System.out.println("\n--- Resumen final ---");
        System.out.println(pedido.mostrarResumen());
    }
}