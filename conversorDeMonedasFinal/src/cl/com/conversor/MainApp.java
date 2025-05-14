package cl.com.conversor;

import cl.com.conversor.model.ConversionRecord;
import cl.com.conversor.service.CurrencyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ConversionRecord> history = new ArrayList<>();

        while (true) {
            System.out.println("\nCONVERSOR DE MONEDAS");
            System.out.println("1. Realizar conversión");
            System.out.println("2. Ver historial");
            System.out.println("3. Salir");
            System.out.print("Seleccione opción: ");

            int opcion = scanner.nextInt();

            if (opcion == 3) break;

            switch (opcion) {
                case 1:
                    System.out.print("Moneda origen (ej: USD): ");
                    String from = scanner.next().toUpperCase();

                    System.out.print("Moneda destino (ej: EUR): ");
                    String to = scanner.next().toUpperCase();

                    System.out.print("Cantidad a convertir: ");
                    double amount = scanner.nextDouble();

                    try {
                        double rate = CurrencyService.getExchangeRate(from, to);
                        double result = amount * rate;
                        System.out.printf("\nResultado: %.2f %s = %.2f %s%n",
                                amount, from, result, to);

                        // Guardar en historial
                        history.add(new ConversionRecord(from, to, amount, result, rate));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\n--- Historial de conversiones ---");
                    if (history.isEmpty()) {
                        System.out.println("No hay conversiones registradas.");
                    } else {
                        for (int i = 0; i < history.size(); i++) {
                            System.out.println((i + 1) + ". " + history.get(i));
                        }
                    }
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
