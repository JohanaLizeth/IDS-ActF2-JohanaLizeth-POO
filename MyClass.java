import java.util.Scanner; // IMPORTACIÓN: Activa la antena para leer el teclado

class CuentaBancaria {
    String titular;
    double saldoDisponible;

    CuentaBancaria(String nombreTitular, double saldoInicial) {
        titular = nombreTitular;
        saldoDisponible = saldoInicial;
    }

    void registrarTransaccion(String concepto, double monto) {
        if (monto <= saldoDisponible) {
            saldoDisponible = saldoDisponible - monto;
            System.out.println("✅ Transaccion exitosa: " + concepto + " por $" + monto);
        } else {
            System.out.println("❌ Alerta para " + titular + ": Saldo insuficiente para " + concepto);
        }
    }

    void consultarBalance() {
        System.out.println("--- Balance disponible de " + titular + ": $" + saldoDisponible + " ---");
    }
}

public class MyClass {
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE GESTION DE PRESUPUESTO ===");
        CuentaBancaria cuentaUsuario = new CuentaBancaria("Johana Lizeth", 5000.0);
        
        String concepto = ""; // Variable para guardar el texto del gasto

        // 🔄 EL BUCLE: Se repetirá "mientras" el concepto no sea igual a la palabra "salir"
        while (!concepto.equalsIgnoreCase("salir")) {
            cuentaUsuario.consultarBalance(); // Muestra el dinero antes de gastar
            
            System.out.print("\nEscribe el concepto del gasto (o escribe 'salir' para terminar): ");
            concepto = teclado.nextLine(); // Leemos el texto del usuario

            // Si el usuario escribió "salir", el bucle se rompe inmediatamente
            if (concepto.equalsIgnoreCase("salir")) {
                System.out.println("\n👋 Saliendo del sistema. ¡Cuida tu dinero!");
                break; 
            }

            System.out.print("Escribe el monto de '" + concepto + "': $");
            double monto = teclado.nextDouble();
            teclado.nextLine(); // Limpieza del lector de teclado

            // El sistema procesa el gasto introducido
            cuentaUsuario.registrarTransaccion(concepto, monto);
            System.out.println("-------------------------------------------------");
        }
        
        teclado.close(); // Apagamos el lector al terminar
    }
}
