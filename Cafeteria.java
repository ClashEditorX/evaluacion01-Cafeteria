import java.util.Scanner;

public class Cafeteria {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Producto cafe = new Producto("Café americano", 45, 20);
        Producto cappuccino = new Producto("Cappuccino", 70, 15);
        Producto sandwich = new Producto("Sándwich", 95, 10);
        Producto galleta = new Producto("Galleta de avena", 30, 25);

        Caja caja = new Caja();

        int opcion;

        do {
            System.out.println("\n===== CAFETERÍA CI =====");
            System.out.println("1. Ver productos");
            System.out.println("2. Vender");
            System.out.println("3. Reabastecer");
            System.out.println("4. Cambiar precio");
            System.out.println("5. Reporte del día");
            System.out.println("0. Salir");

            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {

                case 1:
                    // Mostrar productos
                    System.out.println("\n===== PRODUCTOS =====");

                    mostrarProducto(1, cafe);
                    mostrarProducto(2, cappuccino);
                    mostrarProducto(3, sandwich);
                    mostrarProducto(4, galleta);

                    break;

                case 2:
                    // Realizar una venta
                    System.out.println("\n===== VENDER =====");

                    Producto productoVenta =
                            seleccionarProducto(
                                cafe, cappuccino, sandwich, galleta
                            );

                    if (productoVenta != null) {

                        int cantidad = leerEntero(
                            "Ingrese la cantidad: "
                        );

                        caja.cobrar(productoVenta, cantidad);
                    }

                    break;

                case 3:
                    // Reabastecer inventario
                    System.out.println("\n===== REABASTECER =====");

                    Producto productoReabastecer =
                            seleccionarProducto(
                                cafe, cappuccino, sandwich, galleta
                            );

                    if (productoReabastecer != null) {

                        int cantidad = leerEntero(
                            "Cantidad a reabastecer: "
                        );

                        productoReabastecer.reabastecer(cantidad);
                    }

                    break;

                case 4:
                    // Cambiar precio
                    System.out.println("\n===== CAMBIAR PRECIO =====");

                    Producto productoPrecio =
                            seleccionarProducto(
                                cafe, cappuccino, sandwich, galleta
                            );

                    if (productoPrecio != null) {

                        double nuevoPrecio = leerDouble(
                            "Ingrese el nuevo precio: "
                        );

                        productoPrecio.setPrecio(nuevoPrecio);
                    }

                    break;

                case 5:
                    // Mostrar reporte
                    caja.mostrarReporte();
                    break;

                case 0:
                    System.out.println(
                        "Gracias por utilizar Cafetería CI."
                    );
                    break;

                default:
                    System.out.println(
                        "Opción inválida. Intente nuevamente."
                    );
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }

    public static void mostrarProducto(
            int numero, Producto producto) {

        System.out.print(
            numero + ". " + producto.getNombre()
        );

        System.out.printf(
            " | Precio: C$%.2f",
            producto.getPrecio()
        );

        System.out.print(
            " | Stock: " + producto.getStock()
        );

        if (producto.getStock() < 5) {
            System.out.print(" (stock bajo)");
        }

        System.out.println();
    }

    public static Producto seleccionarProducto(
            Producto cafe,
            Producto cappuccino,
            Producto sandwich,
            Producto galleta) {

        System.out.println("\nSeleccione un producto:");
        System.out.println("1. Café americano");
        System.out.println("2. Cappuccino");
        System.out.println("3. Sándwich");
        System.out.println("4. Galleta de avena");

        int numero = leerEntero("Número del producto: ");

        switch (numero) {

            case 1:
                return cafe;

            case 2:
                return cappuccino;

            case 3:
                return sandwich;

            case 4:
                return galleta;

            default:
                System.out.println(
                    "Producto inválido. Intente nuevamente."
                );
                return null;
        }
    }

    public static int leerEntero(String mensaje) {

        while (true) {
            System.out.print(mensaje);

            try {
                return Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println(
                    "Error: ingrese un número entero válido."
                );
            }
        }
    }

    public static double leerDouble(String mensaje) {

        while (true) {
            System.out.print(mensaje);

            try {
                double numero = Double.parseDouble(
                    sc.nextLine().trim()
                );

                if (Double.isFinite(numero)) {
                    return numero;
                }

                System.out.println(
                    "Error: ingrese un número decimal válido."
                );

            } catch (NumberFormatException e) {
                System.out.println(
                    "Error: ingrese un número decimal válido."
                );
            }
        }
    }
}