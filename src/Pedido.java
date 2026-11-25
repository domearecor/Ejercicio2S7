import java.util.ArrayList;

public class Pedido {
    private ArrayList<DetallePedido> detalles;

    public Pedido() {
        detalles = new ArrayList<>();
    }

    // Incluye el desafío: si el mismo producto ya existe, acumula la cantidad
    public void agregarProducto(Producto producto, int cantidad) {
        if (producto == null || cantidad <= 0) {
            return;
        }
        for (DetallePedido detalle : detalles) {
            if (detalle.getProducto() != null
                    && detalle.getProducto().getCodigo().equals(producto.getCodigo())) {
                detalle.setCantidad(detalle.getCantidad() + cantidad);
                return;
            }
        }
        detalles.add(new DetallePedido(producto, cantidad));
    }

    public double calcularTotal() {
        double total = 0.0;
        for (DetallePedido detalle : detalles) {
            total += detalle.calcularSubtotal();
        }
        return total;
    }

    public int cantidadDetalles() {
        return detalles.size();
    }

    public boolean eliminarDetalle(int posicion) {
        if (posicion >= 0 && posicion < detalles.size()) {
            detalles.remove(posicion);
            return true;
        }
        return false;
    }

    public String mostrarResumen() {
        if (detalles.isEmpty()) {
            return "El pedido no tiene detalles.\nTotal: $0.0";
        }
        String resumen = "=== RESUMEN DEL PEDIDO ===\n";
        for (int i = 0; i < detalles.size(); i++) {
            resumen += i + ". " + detalles.get(i).mostrarInformacion() + "\n";
        }
        resumen += "Total del pedido: $" + calcularTotal();
        return resumen;
    }
}