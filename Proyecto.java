import java.util.Random;
import java.util.Scanner;

public class Proyecto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int vidaJugador = 100;
        int pociones = 2;
        boolean explorando = true;

        System.out.println("🏰 ¡Bienvenido a la Mazmorra! 🏰");

        // Exploración de habitaciones (while)
        while (explorando && vidaJugador > 0) {
            System.out.println("\n🔹 Nueva habitación... ¿Qué habrá aquí?");
            int evento = random.nextInt(3); // 0 = enemigo, 1 = cofre, 2 = habitación vacía

            if (evento == 0) {  // Enemigo aparece
                System.out.println("⚔️ ¡Un enemigo aparece!");
                int vidaEnemigo = 30;

                // Combate con for (turnos)
                for (int turno = 1; vidaJugador > 0 && vidaEnemigo > 0; turno++) {
                    int ataqueJugador = random.nextInt(15) + 5;
                    int ataqueEnemigo = random.nextInt(10) + 3;

                    vidaEnemigo -= ataqueJugador;
                    vidaJugador -= ataqueEnemigo;

                    System.out.println("Turno " + turno + ": Atacas con " + ataqueJugador + " de daño.");
                    System.out.println("El enemigo te ataca con " + ataqueEnemigo + " de daño.");
                    System.out.println("Tu vida: " + vidaJugador + " | Vida del enemigo: " + vidaEnemigo);
                }

                if (vidaJugador <= 0) {
                    System.out.println("💀 ¡Has sido derrotado!");
                    break;
                } else {
                    System.out.println("🏆 ¡Venciste al enemigo!");
                }
            } else if (evento == 1) {  // Cofre con poción
                System.out.println("🎁 ¡Encontraste un cofre con una poción!");
                pociones++;
                System.out.println("Pociones disponibles: " + pociones);
                continue;  // Salta el resto del código y vuelve al inicio del while
            } else {
                System.out.println("🚪 La habitación está vacía.");
            }

            // Usar poción (do-while)
            String usarPocion;
            do {
                System.out.print("\n💊 ¿Quieres usar una poción? (si/no): ");
                usarPocion = scanner.next().toLowerCase();

                if (usarPocion.equals("si") && pociones > 0) {
                    vidaJugador += 20;
                    pociones--;
                    System.out.println("🩹 Usaste una poción. Vida actual: " + vidaJugador);
                } else if (usarPocion.equals("si")) {
                    System.out.println("❌ No tienes pociones.");
                }
            } while (usarPocion.equals("si") && pociones > 0);

            // Continuar explorando o salir
            System.out.print("\n🚪 ¿Seguir explorando? (si/no): ");
            explorando = scanner.next().equalsIgnoreCase("si");
        }

        System.out.println("\n🏁 ¡Fin de la aventura! Vida final: " + vidaJugador);
        scanner.close();
    }
}
