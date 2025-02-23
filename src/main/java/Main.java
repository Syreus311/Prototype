import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import prototype.Vehicle;
import prototype.VehicleRegistry;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleRegistry registry = new VehicleRegistry();
        List<Vehicle> clonedVehicles = new ArrayList<>();

        // Agregar un vehículo base al registro
        Vehicle baseVehicle = new Vehicle("Chasis universal", "Base", "Gasolina", "Estándar", "Blanco");
        registry.addPrototype("base_vehicle", baseVehicle);

        System.out.println("¡Bienvenido al sistema de clonación de vehículos!\n");

        boolean continueCloning = true;

        while (continueCloning) {
            // Menú principal antes de clonar un vehículo
            boolean validChoice = false;
            while (!validChoice) {
                System.out.println("=============================================");
                System.out.println("              MENÚ PRINCIPAL                 ");
                System.out.println("=============================================");
                System.out.println("1. Clonar un nuevo vehículo");
                System.out.println("2. Ver cuántos vehículos se han clonado y sus características");
                System.out.println("3. Comparar memoria entre dos vehículos clonados");
                System.out.println("4. Salir");

                System.out.print("Seleccione una opción (1-4): ");
                if (scanner.hasNextInt()) {
                    int option = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    switch (option) {
                        case 1:
                            validChoice = true;
                            break; // Salir del menú y proceder con la clonación
                        case 2:
                            System.out.println("\n=============================================");
                            System.out.println("        VEHÍCULOS CLONADOS HASTA AHORA       ");
                            System.out.println("=============================================");
                            System.out.println("Total de vehículos clonados: " + clonedVehicles.size());
                            for (int i = 0; i < clonedVehicles.size(); i++) {
                                System.out.println("\n---------------------------------------------");
                                System.out.println("Vehículo #" + (i + 1) + ":");
                                clonedVehicles.get(i).showInfo();
                                System.out.println("---------------------------------------------");
                            }
                            break;
                        case 3:
                            if (clonedVehicles.size() < 2) {
                                System.out.println("No hay suficientes vehículos clonados para comparar.");
                                break;
                            }

                            System.out.println("Seleccione los vehículos que desea comparar:");
                            for (int i = 0; i < clonedVehicles.size(); i++) {
                                System.out.println((i + 1) + ". Vehículo #" + (i + 1));
                            }

                            System.out.print("Seleccione el primer vehículo (1-" + clonedVehicles.size() + "): ");
                            int firstVehicle = scanner.nextInt() - 1;

                            System.out.print("Seleccione el segundo vehículo (1-" + clonedVehicles.size() + "): ");
                            int secondVehicle = scanner.nextInt() - 1;
                            scanner.nextLine(); // Consumir la nueva línea

                            if (firstVehicle >= 0 && firstVehicle < clonedVehicles.size() &&
                                    secondVehicle >= 0 && secondVehicle < clonedVehicles.size()) {
                                boolean memoryComparison = clonedVehicles.get(firstVehicle) == clonedVehicles.get(secondVehicle);
                                System.out.println("¿Los dos vehículos seleccionados comparten la misma referencia de memoria? " + memoryComparison);
                            } else {
                                System.out.println("Selección inválida. Intente de nuevo.");
                            }
                            break;
                        case 4:
                            System.out.println("\nSaliendo del sistema...");
                            continueCloning = false;
                            validChoice = true;
                            break;
                        default:
                            System.out.println("Error: Opción no válida. Inténtelo de nuevo.");
                    }
                } else {
                    System.out.println("Error: Ingrese solo números entre 1 y 4.");
                    scanner.next();
                }
            }

            if (!continueCloning) break;

            // Clonación del vehículo después del menú
            System.out.println("=============================================");
            System.out.println("       CLONACIÓN DE UN NUEVO VEHÍCULO       ");
            System.out.println("=============================================");

            Vehicle clonedVehicle = (Vehicle) registry.getClone("base_vehicle");

            // Selección de carrocería
            String[] bodyworks = {"Sedan", "SUV", "Deportivo", "Pickup"};
            clonedVehicle.setBodywork(selectOption(scanner, "Seleccione el tipo de carrocería:", bodyworks));

            System.out.println(); // Espacio para mejorar visualización

            // Selección de modelo
            String[] models = {"Alto", "Medio", "Bajo"};
            clonedVehicle.setModel(selectOption(scanner, "Seleccione el modelo:", models));

            System.out.println();

            // Selección de tipo de combustible
            String[] fuelTypes = {"Eléctrico", "Gasolina", "Híbrido", "Diésel"};
            clonedVehicle.setFuelType(selectOption(scanner, "Seleccione el tipo de combustible:", fuelTypes));

            System.out.println();

            // Ingreso de tipo de llantas
            String[] tireOptions = {"Llantas Todo Terreno", "Llantas de Nieve", "Llantas Deportivas"};
            clonedVehicle.setwheels(selectOption(scanner, "Seleccione el tipo de llantas:", tireOptions));

            System.out.println();

            // Selección de color
            String[] colors = {"Negro", "Blanco", "Gris", "Plateado", "Azul", "Rojo"};
            clonedVehicle.setColor(selectOption(scanner, "Seleccione el color:", colors));

            System.out.println();

            // Agregar el vehículo a la lista de clonados
            clonedVehicles.add(clonedVehicle);

            // Mostrar información del vehículo clonado
            System.out.println("=============================================");
            System.out.println("        VEHÍCULO CONFIGURADO CORRECTAMENTE   ");
            System.out.println("=============================================");
            clonedVehicle.showInfo();

            // Comparar memoria con el vehículo base
            boolean sameMemory = (baseVehicle == clonedVehicle);
            System.out.println("¿El vehículo base y el clonado comparten la misma referencia de memoria? " + sameMemory);
        }

        System.out.println("\nGracias por usar el sistema de clonación de vehículos. ¡Hasta luego!");
    }

    // Método para mostrar opciones y capturar la selección del usuario
    private static String selectOption(Scanner scanner, String message, String[] options) {
        System.out.println(message);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        int choice;
        do {
            System.out.print("Seleccione una opción (1-" + options.length + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese solo números entre 1 y " + options.length);
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > options.length);

        scanner.nextLine(); // Consumir la nueva línea
        return options[choice - 1];
    }
}