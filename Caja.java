public class Caja {
    private double totalVendido;
    private int numeroVentas;

    public Caja() {
        totalVendido = 0;
        numeroVentas = 0;
    }

    public double getTotalVendido() {
        return totalVendido;
    }

    public int getNumeroVentas() {
        return numeroVentas;
    }

    public boolean cobrar(Producto producto, int cantidad) {

        if (producto == null) {
            System.out.println("Error: producto inválido.");
            return false;
        }

        if (cantidad <= 0) {
            System.out.println(
                "Error: la cantidad debe ser mayor que 0."
            );
            return false;
        }

        if (!producto.vender(cantidad)) {
            System.out.println(
                "Venta rechazada: stock insuficiente."
            );
            return false;
        }

        double subtotal = producto.getPrecio() * cantidad;

        double descuento = 0;

        if (subtotal >= 300) {
            descuento = subtotal * 0.10;
        }

        double baseImponible = subtotal - descuento;

        double iva = Math.round(baseImponible * 0.15 * 100)
                     / 100.0;

        double total = Math.round(
            (baseImponible + iva) * 100
        ) / 100.0;

        System.out.println("\n----- TICKET -----");
        System.out.println(
            producto.getNombre() + " x " + cantidad
        );
        System.out.println("Subtotal: C$" + subtotal);
        System.out.println("Descuento: C$" + descuento);
        System.out.println("IVA (15%): C$" + iva);
        System.out.println("TOTAL: C$" + total);
        System.out.println("------------------");

        totalVendido += total;
        numeroVentas++;

        return true;
    }

    public void mostrarReporte() {
        System.out.println("\n===== REPORTE DEL DÍA =====");
        System.out.println("Número de ventas: " + numeroVentas);

        System.out.printf(
            "Total vendido: C$%.2f%n",
            totalVendido
        );

        System.out.println("===========================");
    }
}