public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;

        if (precio > 0) {
            this.precio = precio;
        } else {
            this.precio = 1.0;
            System.out.println("Precio inválido. Se asignó C$1.00.");
        }

        if (stock >= 0) {
            this.stock = stock;
        } else {
            this.stock = 0;
            System.out.println("Stock inválido. Se asignó 0.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
            System.out.println("Precio actualizado correctamente.");
        } else {
            System.out.println("Error: el precio debe ser mayor que 0.");
        }
    }

    public boolean vender(int cantidad) {
        if (cantidad <= 0 || cantidad > stock) {
            return false;
        }

        stock -= cantidad;
        return true;
    }

    public void reabastecer(int cantidad) {
        if (cantidad > 0) {
            stock += cantidad;
            System.out.println("Inventario actualizado correctamente.");
        } else {
            System.out.println(
                "Error: la cantidad debe ser mayor que 0."
            );
        }
    }
}