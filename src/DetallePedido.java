public class DetallePedido {
    private Producto producto;
    private int cantidad;

    public DetallePedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        if (producto == null) {
            return 0.0;
        }
        return producto.getPrecio() * cantidad;
    }

    public String mostrarInformacion() {
        String nombreProd = (producto != null) ? producto.getNombre() : "Sin producto";
        double precioUnit = (producto != null) ? producto.getPrecio() : 0.0;
        return nombreProd + " | Cant: " + cantidad + " | P. Unit: $" + precioUnit
                + " | Subtotal: $" + calcularSubtotal();
    }
}